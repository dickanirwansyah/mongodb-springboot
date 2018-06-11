package com.mongodb.app.springbootmongodb.controller;

import com.mongodb.app.springbootmongodb.entity.Category;
import com.mongodb.app.springbootmongodb.entity.Phone;
import com.mongodb.app.springbootmongodb.request.CreatePhoneRequest;
import com.mongodb.app.springbootmongodb.response.ErrorResponse;
import com.mongodb.app.springbootmongodb.service.PhoneService;
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
@RequestMapping(value = "/phone/api/v1")
public class ControllerPhone {

    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> listPhone(){
        return Optional.ofNullable(phoneService.listPhone())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Phone>>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Phone> createPhone(@Valid @RequestBody CreatePhoneRequest request){
        return Optional.ofNullable(phoneService.createPhone(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Phone>(HttpStatus.BAD_REQUEST));
    }

    /**
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
