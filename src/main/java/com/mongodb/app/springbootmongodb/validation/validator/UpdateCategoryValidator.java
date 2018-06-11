package com.mongodb.app.springbootmongodb.validation.validator;


import com.mongodb.app.springbootmongodb.entity.Category;
import com.mongodb.app.springbootmongodb.repository.CategoryRepository;
import com.mongodb.app.springbootmongodb.request.UpdateCategoryRequest;
import com.mongodb.app.springbootmongodb.validation.UpdateCategoryValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public class UpdateCategoryValidator implements ConstraintValidator<UpdateCategoryValidation, UpdateCategoryRequest>{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void initialize(UpdateCategoryValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(UpdateCategoryRequest value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value.getCategoryId() == null || value.getCategoryId().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("code categoryId must exists")
                    .addPropertyNode("categoryId")
                    .addConstraintViolation();
            return false;
        }

        Optional<Category> categoryId = categoryRepository.findById(value.getCategoryId());
        if(!categoryId.isPresent()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("code categoryId not valid")
                    .addPropertyNode("categoryId")
                    .addConstraintViolation();
            return false;
        }

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
