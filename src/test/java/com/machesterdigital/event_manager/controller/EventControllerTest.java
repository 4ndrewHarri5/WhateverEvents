package com.machesterdigital.event_manager.controller;

import com.machesterdigital.event_manager.services.EventService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class EventControllerTest {


    EventService eventService = mock(EventService.class);
    EventController eventController = new EventController(eventService);

    @Test
    @Disabled
    void getEvents() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @Disabled
    void addEvent() {
    }

    @Test
    @Disabled
    void deleteEventById() {
    }

    @Test
    @Disabled
    void getEventById() {
    }
}