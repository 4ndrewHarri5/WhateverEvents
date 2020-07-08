package com.machesterdigital.event_manager.exceptions;

import com.machesterdigital.event_manager.entities.Event;

public class EventIdNotMatchUpdate extends Exception {

    private int id;

    public EventIdNotMatchUpdate(int id, Event event) {
        super(String.format("Id : '%s', does not match event Id update", id, event.getId()));
    }
}
