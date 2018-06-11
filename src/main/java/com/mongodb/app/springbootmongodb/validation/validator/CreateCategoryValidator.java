package com.mongodb.app.springbootmongodb.validation.validator;

import com.mongodb.app.springbootmongodb.repository.CategoryRepository;
import com.mongodb.app.springbootmongodb.request.CreateCategoryRequest;
import com.mongodb.app.springbootmongodb.validation.CreateCategoryValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CreateCategoryValidator implements ConstraintValidator<CreateCategoryValidation, CreateCategoryRequest>{

    @Autowired private CategoryRepository categoryRepository;

    @Override
    public void initialize(CreateCategoryValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateCategoryRequest value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value.getNameOfCategory() == null || value.getNameOfCategory().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name must exists")
                    .addPropertyNode("nameOfCategory")
                    .addConstraintViolation();
            return false;
        }

        if (value.getDescriptionOfCategory() == null || value.getDescriptionOfCategory().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("description must exists")
                    .addPropertyNode("descriptionOfCategory")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
