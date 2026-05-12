package org.bajiepka.betting.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bajiepka.betting.dto.OutcomeEventDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${spring.kafka.template.default-topic}")
    private String topic;
    private final KafkaTemplate<String, OutcomeEventDto> kafkaTemplate;

    public void sendOutcomeEvent(OutcomeEventDto outcomeEventDto) {
        log.info("Sending outcome event to Kafka: {}", outcomeEventDto);

        var key = outcomeEventDto.id().toString();
        kafkaTemplate.send(topic, key, outcomeEventDto)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("Successfully sent event to Kafka: {}", result.getRecordMetadata());
                    } else {
                        log.error("Failed to send event to Kafka", ex);
                    }
                });
    }
}
