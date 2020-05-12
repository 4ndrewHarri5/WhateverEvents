package com.machesterdigital.event_manager.entities;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private int id;

    @NotBlank (message = "Event Name cannot be null")
    private String eventName;

    @NotNull(message = "Start Date Cannot be null")
    private Date startDate;

    @NotNull(message = "End Date Cannot be null")
    private Date endDate;

    public Event() {
    }

    @Builder
    public Event(String eventName, Date startDate, Date endDate) {
        this();
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
