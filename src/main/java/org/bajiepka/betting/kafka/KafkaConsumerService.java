package org.bajiepka.betting.kafka;

import lombok.extern.slf4j.Slf4j;
import org.bajiepka.betting.dto.OutcomeEventDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "event-outcomes", groupId = "betting-group")
    public void consumeOutcomeEvent(OutcomeEventDto outcomeEventDto) {
        log.info("Consumed outcome event from Kafka: {}", outcomeEventDto);
    }
}
