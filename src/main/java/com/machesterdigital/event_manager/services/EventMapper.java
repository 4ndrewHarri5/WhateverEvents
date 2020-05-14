package com.machesterdigital.event_manager.services;

import com.machesterdigital.event_manager.entities.CreateEvent;
import com.machesterdigital.event_manager.entities.Event;

public class EventMapper {

    public static Event toEvent (CreateEvent createEvent){
        Event event = Event.builder()
                .eventName(createEvent.getEventName())
                .startDate(createEvent.getStartDate())
                .endDate(createEvent.getEndDate())
                .build();
        return event;
    }
}
