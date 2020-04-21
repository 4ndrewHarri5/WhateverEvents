package com.machesterdigital.event_manager.controller;

import com.machesterdigital.event_manager.entities.Event;
import com.machesterdigital.event_manager.repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EventController {

    private final EventRepository eventRepository;

    // TODO add autowired?
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @ResponseBody
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getEvents(){
        try{
             return  ResponseEntity.ok(eventRepository.findAll());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, " Internal Server Error");
        }
    }


    @PostMapping("/events")
    public ResponseEntity<Event> addEvent(@RequestBody Event event){
        return  ResponseEntity.ok(eventRepository.save(event));
    }



    // Get event by id
    // Add event
    // Update event
    // Delete event

}
