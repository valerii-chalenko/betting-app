package org.bajiepka.betting;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest(properties = {
    "rocketmq.name-server=127.0.0.1:9876",
    "rocketmq.producer.group=test-group",
    "spring.autoconfigure.exclude=org.apache.rocketmq.spring.autoconfigure.RocketMQAutoConfiguration"
})
class BettingApplicationTests {

  @MockitoBean
  private RocketMQTemplate rocketMQTemplate;

  @Test
  void contextLoads() {
  }

}
