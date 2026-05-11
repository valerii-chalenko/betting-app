package org.bajiepka.betting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class BettingApplication {

  public static void main(String[] args) {
    SpringApplication.run(BettingApplication.class, args);
  }

}
