package org.bajiepka.betting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bajiepka.betting.dto.OutcomeEventDto;
import org.bajiepka.betting.dto.SettleBetEventDto;
import org.bajiepka.betting.kafka.KafkaProducerService;
import org.bajiepka.betting.repository.BetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OutcomesEventService {

  private final SettlementService settlementService;
  private final KafkaProducerService kafkaProducerService;
  private final BetRepository betRepository;

  public void processEvent(OutcomeEventDto outcomeEventDto) {
    log.info("Processing event: {}", outcomeEventDto);
    kafkaProducerService.sendOutcomeEvent(outcomeEventDto);
  }

  @Transactional(readOnly = true)
  public void publishSettleBetsAsync(
      OutcomeEventDto outcomeEventDto,
      Runnable onSuccess,
      Runnable onFailure
  ) {

    try {

      var betsByEvent = betRepository.findAllByEventId(outcomeEventDto.id());

      if (betsByEvent.isEmpty()) {
        onFailure.run();
        return;
      }

      settlementService.settleBetsAsync(
          betsByEvent.stream()
              .map(bet -> new SettleBetEventDto(bet.getEventWinnerId(), bet.getAmount()))
              .toList(),
          onSuccess,
          onFailure
      );

    } catch (Exception e) {
      log.error("Settlement unexpected exception by event: {}", outcomeEventDto.id(), e);
      onFailure.run();
    }
  }
}
