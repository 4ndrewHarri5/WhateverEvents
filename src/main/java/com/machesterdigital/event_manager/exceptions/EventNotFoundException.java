package com.machesterdigital.event_manager.exceptions;

public class EventNotFoundException extends Exception {
    private int id;
    public EventNotFoundException(int id) {
        super(String.format("Could not find Event with id : '%s'", id));
    }
}
