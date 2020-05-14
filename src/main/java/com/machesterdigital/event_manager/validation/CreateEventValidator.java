package com.machesterdigital.event_manager.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

@Documented
@Constraint(validatedBy = CreateEventValidatorImpl.class)
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateEventValidator {

    String message() default "Id not allowed on creation of Event";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
