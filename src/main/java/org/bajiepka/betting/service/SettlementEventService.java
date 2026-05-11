package org.bajiepka.betting.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.bajiepka.betting.dto.SettleBetEventDto;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SettlementEventService {

  private final RocketMQTemplate rocketMQTemplate;

  public void settleBetsAsync(
      List<SettleBetEventDto> settlements,
      Runnable onSuccess,
      Runnable onFailure
  ) {

    if (!settlements.isEmpty()) {
      rocketMQTemplate.asyncSend("settle-bets-topic", settlements, new SendCallback() {

        @Override
        public void onSuccess(SendResult sendResult) {
          log.info("Successfully sent settlements to RocketMQ: {}", sendResult.getMsgId());
          onSuccess.run();
        }

        @Override
        public void onException(Throwable e) {
          log.error("Failed to send settlements to RocketMQ", e);
          onFailure.run();
        }
      });
    } else {
      onSuccess.run();
    }
  }
}
