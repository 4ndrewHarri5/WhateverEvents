package com.machesterdigital.event_manager.entities;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    //Validator - look into this more. See TestUtils in SAM (Ask Johanna).
    private static final ValidatorFactory FACTORY = Validation.buildDefaultValidatorFactory();
    private static final Validator VALIDATOR = FACTORY.getValidator();
    private static final Date START_DATE = Date.valueOf("2020-05-11");
    private static final Date END_DATE = Date.valueOf("2020-05-11");
    private static final String EVENT_NAME = "Event Name";

    @Test
    public void should_be_invalid_without_required_fields() {
        Event event = Event.builder().build();
        List<String> errors = getErrors(event);
        assertThat(errors).contains("Event Name cannot be null");
        assertThat(errors).contains("Start Date Cannot be null");
        assertThat(errors).contains("End Date Cannot be null");
        assertThat(errors).hasSize(3);
    }

    @Test
    public void should_be_valid_with_required_fields() {
        Event event = Event.builder()
                .eventName(EVENT_NAME)
                .startDate(START_DATE)
                .endDate(END_DATE)
                .build();
        List<String> errors = getErrors(event);
        assertThat(errors).hasSize(0);
    }

    //Add to TestUtils class
    public static List<String> getErrors(Object obj) {
        return new ArrayList<>(getValidator().validate(obj))
                .stream()
                .map(ConstraintViolation::getMessage)
                .sorted()
                .collect(Collectors.toList());
    }

    public static Validator getValidator() {
        return VALIDATOR;
    }
}