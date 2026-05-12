package org.bajiepka.betting.service.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.bajiepka.betting.dto.event.SettleBetEventDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@ConditionalOnProperty(name = "rocketmq.enabled", havingValue = "true")
@RocketMQMessageListener(
    topic = "settle-bets-topic",
    consumerGroup = "settle-bets-consumer-group"
)
public class SettleBetsConsumer implements RocketMQListener<List<SettleBetEventDto>> {

    @Override
    public void onMessage(List<SettleBetEventDto> messages) {
        log.info("Received settle bets messages: {}", messages);
    }
}
