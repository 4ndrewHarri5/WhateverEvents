package com.machesterdigital.event_manager.controller;

import com.machesterdigital.event_manager.entities.Event;
import com.machesterdigital.event_manager.exceptions.EventNotFoundException;
import com.machesterdigital.event_manager.repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
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


    // TODO fix so cannot have same id
    @PostMapping("/events")
    public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event){
        return  ResponseEntity.ok(eventRepository.save(event));
    }


    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> deleteEventById(@PathVariable(value = "id") Integer id){
        eventRepository.deleteById(id);
        return  ResponseEntity.ok().build();
    }

    @ResponseBody
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Integer id) throws EventNotFoundException {
        return ResponseEntity.ok(eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id)));


    }

    // Get event by id
    // Add event
    // Update event
    // Delete event

}
