package org.bajiepka.betting.kafka;

import static org.bajiepka.betting.config.KafkaConfig.TOPIC_OUTCOMES;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bajiepka.betting.dto.OutcomeEventDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, OutcomeEventDto> kafkaTemplate;

    public void sendOutcomeEvent(OutcomeEventDto outcomeEventDto) {
        log.info("Sending outcome event to Kafka: {}", outcomeEventDto);
        kafkaTemplate.send(TOPIC_OUTCOMES, outcomeEventDto.id().toString(), outcomeEventDto)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("Successfully sent event to Kafka: {}", result.getRecordMetadata());
                    } else {
                        log.error("Failed to send event to Kafka", ex);
                    }
                });
    }
}
