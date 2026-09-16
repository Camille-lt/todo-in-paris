package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.service.ParisOpenDataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {

    private final ParisOpenDataService parisOpenDataService;

    public EventController(ParisOpenDataService parisOpenDataService) {
        this.parisOpenDataService = parisOpenDataService;
    }

    @GetMapping
    public List getAllEvents() {
        return parisOpenDataService.getEvents();
    }
}