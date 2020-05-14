package com.machesterdigital.event_manager.services;

import com.machesterdigital.event_manager.entities.Event;
import com.machesterdigital.event_manager.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteById(Integer id) {
        eventRepository.deleteById(id);
    }

    public Optional<Event> findById(Integer id) {
        return eventRepository.findById(id);
    }
}
