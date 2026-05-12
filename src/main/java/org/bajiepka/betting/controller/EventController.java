package org.bajiepka.betting.controller;

import jakarta.validation.Valid;
import org.bajiepka.betting.dto.event.OutcomeEventDto;
import org.bajiepka.betting.service.OutcomesEventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

  private final OutcomesEventService outcomesEventService;

  public EventController(OutcomesEventService outcomesEventService) {
    this.outcomesEventService = outcomesEventService;
  }

  @PostMapping
  public void processEvent(
      @Valid @RequestBody OutcomeEventDto outcomeEventDto
  ) {
    outcomesEventService.processEvent(outcomeEventDto);
  }
}
