package com.mongodb.app.springbootmongodb.validation;


import com.mongodb.app.springbootmongodb.validation.validator.CreateCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;


@Target({ANNOTATION_TYPE, TYPE, PARAMETER, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CreateCategoryValidator.class})
@Documented
public @interface CreateCategoryValidation {

    String message() default "CreateCategoryValidation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
