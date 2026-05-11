package org.bajiepka.betting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bajiepka.betting.dto.OutcomeEventDto;
import org.bajiepka.betting.kafka.KafkaProducerService;
import org.bajiepka.betting.repository.BetRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {

    private final KafkaProducerService kafkaProducerService;

    public void processEvent(OutcomeEventDto outcomeEventDto) {
        log.info("Processing event: {}", outcomeEventDto);
        kafkaProducerService.sendOutcomeEvent(outcomeEventDto);
    }
}
