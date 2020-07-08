package com.machesterdigital.event_manager.controller;

import com.machesterdigital.event_manager.entities.CreateEvent;
import com.machesterdigital.event_manager.entities.Event;
import com.machesterdigital.event_manager.exceptions.EventNotFoundException;
import com.machesterdigital.event_manager.services.EventMapper;
import com.machesterdigital.event_manager.services.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @ResponseBody
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getEvents(){
        log.info("Get all events");
        try{
             return  ResponseEntity.ok(eventService.findAll());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, " Internal Server Error");
        }
    }

    @PostMapping("/events")
    public ResponseEntity<Event> addEvent(@Valid @RequestBody CreateEvent createEvent){
        Event event = EventMapper.toEvent(createEvent);
        return  ResponseEntity.ok(eventService.createEvent(event));
    }


    /* TODO implement update Event

    @PutMapping("/events/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable int eventId,
                                             @RequestBody @Valid Event event) {

//         Event retrievedEvent = get Event By id
//         Event updatedEvent = EventMapper.toEventUpdate(eventId, retrievedEvent, updatedEvent)
//         save in repository (eventId, updatedEvent)
//         Event updatedEvent = new Event();
//         eventService.updateEvent(updatedEvent);



        return ResponseEntity.of(null);
    }

     */




    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> deleteEventById(@PathVariable(value = "id") Integer id){
        log.info("Delete by Id");
        eventService.deleteById(id);
        return  ResponseEntity.ok().build();
    }

    @ResponseBody
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Integer id) throws EventNotFoundException {
        log.info("Get event by id");
        return ResponseEntity.ok(eventService.findById(id)
                    .orElseThrow(() -> new EventNotFoundException(id)));
    }

}
