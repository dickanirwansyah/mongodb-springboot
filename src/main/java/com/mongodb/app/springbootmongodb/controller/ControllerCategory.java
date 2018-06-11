package com.mongodb.app.springbootmongodb.controller;

import com.mongodb.app.springbootmongodb.entity.Category;
import com.mongodb.app.springbootmongodb.request.CreateCategoryRequest;
import com.mongodb.app.springbootmongodb.request.GetCategoryRequest;
import com.mongodb.app.springbootmongodb.request.UpdateCategoryRequest;
import com.mongodb.app.springbootmongodb.response.ErrorResponse;
import com.mongodb.app.springbootmongodb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/category/api/v1/")
public class ControllerCategory {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listCategory(){
        return Optional.ofNullable(categoryService.listCategory())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CreateCategoryRequest request){
        return Optional.ofNullable(categoryService.createCategory(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody UpdateCategoryRequest request){
        return Optional.ofNullable(categoryService.updateCategory(request))
            .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.ACCEPTED))
            .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<Optional<Category>> getDetail(@PathVariable String categoryId){
        GetCategoryRequest request = GetCategoryRequest
                .builder()
                .categoryId(categoryId)
                .build();

        Optional<Category> category = findId(request);
        if (!category.isPresent()){
            return new ResponseEntity<Optional<Category>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<Category>>(category, HttpStatus.OK);
    }

    Optional<Category> findId(GetCategoryRequest request){
        return categoryService.getDetailCategory(request);
    }

    /**
     *
     * validation
     */

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlingError(MethodArgumentNotValidException exception){

        String errorMessage = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());

        return ErrorResponse.builder()
                .message(errorMessage)
                .status(false)
                .time(new Date())
                .build();
    }
}
