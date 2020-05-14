package com.machesterdigital.event_manager.validation;

import com.machesterdigital.event_manager.entities.CreateEvent;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class CreateEventValidatorImpl implements ConstraintValidator<CreateEventValidator, CreateEvent> {

   public void initialize(CreateEventValidator constraint) {
   }

   @Override
   public boolean isValid(CreateEvent event, ConstraintValidatorContext context) {
      if (event.getId() == 0) {
         log.info("ID IS ZERO - Able to create");
         return true;
      }

      context.disableDefaultConstraintViolation();

      if (event.getId() != 0){
         addIdValidationMessage(context);
         return false;
      }
      return true;
   }



   private void addIdValidationMessage(ConstraintValidatorContext context) {
      context.buildConstraintViolationWithTemplate(
              "Id cannot be specified when creating an event")
              .addPropertyNode("id")
              .addConstraintViolation();
   }

}
