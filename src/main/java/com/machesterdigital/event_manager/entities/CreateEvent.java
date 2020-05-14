package com.machesterdigital.event_manager.entities;

import com.machesterdigital.event_manager.validation.CreateEventValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@CreateEventValidator
public class CreateEvent {

    private int id;

    @NotBlank(message = "Event Name cannot be null")
    private String eventName;

    @NotNull(message = "Start Date Cannot be null")
    private Date startDate;

    @NotNull(message = "End Date Cannot be null")
    private Date endDate;

}
