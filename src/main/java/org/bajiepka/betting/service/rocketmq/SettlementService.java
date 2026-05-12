package org.bajiepka.betting.service.rocketmq;

import java.util.List;
import org.bajiepka.betting.dto.event.SettleBetEventDto;

public interface SettlementService {

  void settleBetsAsync(List<SettleBetEventDto> settlements, Runnable onSuccess, Runnable onFailure);
}
