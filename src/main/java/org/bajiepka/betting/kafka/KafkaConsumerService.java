package org.bajiepka.betting.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bajiepka.betting.dto.OutcomeEventDto;
import org.bajiepka.betting.service.OutcomesEventService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

  private final OutcomesEventService outcomesEventService;

  @Async
  @KafkaListener(topics = "event-outcomes", groupId = "outcomes-group")
  public void consumeOutcomeEvent(OutcomeEventDto outcomeEventDto, Acknowledgment ack) {

    Runnable successCallback = () -> {
      ack.acknowledge();
      log.info("Acknowledged Kafka event: {}", outcomeEventDto.id());
    };

    Runnable failureCallback = () -> log.error(
        "Failed to process and settle bets for event: {}. Message will not be acknowledged.",
        outcomeEventDto.id()
    );

    outcomesEventService.publishSettleBetsAsync(outcomeEventDto, successCallback, failureCallback);

    log.info("Consumed outcome event from Kafka: {}", outcomeEventDto);
  }
}
