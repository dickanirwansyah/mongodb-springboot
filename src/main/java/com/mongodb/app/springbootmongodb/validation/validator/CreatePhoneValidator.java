package com.mongodb.app.springbootmongodb.validation.validator;

import com.mongodb.app.springbootmongodb.entity.Category;
import com.mongodb.app.springbootmongodb.repository.CategoryRepository;
import com.mongodb.app.springbootmongodb.request.CreatePhoneRequest;
import com.mongodb.app.springbootmongodb.validation.CreatePhoneValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public class CreatePhoneValidator implements ConstraintValidator<CreatePhoneValidation, CreatePhoneRequest>{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void initialize(CreatePhoneValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreatePhoneRequest value, ConstraintValidatorContext context) {
        if (value == null)
            return true;


        if (value.getNameOfPhone() == null || value.getNameOfPhone().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name phone must exists")
                    .addPropertyNode("nameOfPhone")
                    .addConstraintViolation();
            return false;
        }

        if (value.getCategoryOfPhone() == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("category phone must exists")
                    .addPropertyNode("categoryOfPhone")
                    .addConstraintViolation();
            return false;
        }

        Optional<Category> category = categoryRepository.findById(value.getCategoryOfPhone().getIdcategory());
        if (!category.isPresent()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("code categoryId not valid")
                    .addPropertyNode("categoryOfPhone")
                    .addConstraintViolation();
            return false;
        }

        if (value.getStockOfPhone() == 0 || value.getStockOfPhone() < 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("stock phone must exists")
                    .addPropertyNode("stockOfPhone")
                    .addConstraintViolation();
            return false;
        }

        if (value.getPriceOfPhone() == 0 || value.getPriceOfPhone() < 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("price phone must exists")
                    .addPropertyNode("priceOfPhone")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
