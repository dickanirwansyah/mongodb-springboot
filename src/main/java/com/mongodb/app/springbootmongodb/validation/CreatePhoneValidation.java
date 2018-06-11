package com.mongodb.app.springbootmongodb.validation;


import com.mongodb.app.springbootmongodb.validation.validator.CreatePhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


@Target({ANNOTATION_TYPE, TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CreatePhoneValidator.class})
@Documented
public @interface CreatePhoneValidation {

   String message() default "CreatePhoneValidation";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};

   String[] path() default {};
}
