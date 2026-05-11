package org.bajiepka.betting.controller;

import jakarta.validation.Valid;
import org.bajiepka.betting.dto.OutcomeEventDto;
import org.bajiepka.betting.service.EventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

  private final EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @PostMapping
  public void processEvent(
      @Valid @RequestBody OutcomeEventDto outcomeEventDto
  ) {
    eventService.processEvent(outcomeEventDto);
  }
}
