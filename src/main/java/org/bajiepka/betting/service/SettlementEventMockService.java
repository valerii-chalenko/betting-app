package org.bajiepka.betting.service;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bajiepka.betting.dto.SettleBetEventDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(
    prefix = "rocketmq",
    name = "enabled",
    havingValue = "false",
    matchIfMissing = true
)
public class SettlementEventMockService implements SettlementService {

  @Override
  public void settleBetsAsync(
      List<SettleBetEventDto> settlements,
      Runnable onSuccess,
      Runnable onFailure
  ) {

    log.info("Successfully sent settlements to RocketMQ: {}", UUID.randomUUID());
    onSuccess.run();
  }
}
