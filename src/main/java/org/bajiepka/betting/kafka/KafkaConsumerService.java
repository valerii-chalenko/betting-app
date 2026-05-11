package org.bajiepka.betting.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bajiepka.betting.dto.OutcomeEventDto;
import org.bajiepka.betting.service.OutcomesEventService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final OutcomesEventService outcomesEventService;

    @KafkaListener(topics = "event-outcomes", groupId = "outcomes-group")
    public void consumeOutcomeEvent(OutcomeEventDto outcomeEventDto, Acknowledgment ack) {
        log.info("Consumed outcome event from Kafka: {}", outcomeEventDto);
        try {
            outcomesEventService.publishSettleBets(outcomeEventDto);
            ack.acknowledge();
            log.info("Acknowledged Kafka event: {}", outcomeEventDto.id());
        } catch (Exception e) {
            log.error("Failed to process and settle bets for event: {}. Message will not be acknowledged.", outcomeEventDto.id(), e);
        }
    }
}
