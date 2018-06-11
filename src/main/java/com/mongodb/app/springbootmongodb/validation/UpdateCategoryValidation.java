package com.mongodb.app.springbootmongodb.validation;


import com.mongodb.app.springbootmongodb.validation.validator.UpdateCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;

@Target({ANNOTATION_TYPE, METHOD, TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UpdateCategoryValidator.class})
@Documented
public @interface UpdateCategoryValidation {

    String message() default "UpdateCategoryValidation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
