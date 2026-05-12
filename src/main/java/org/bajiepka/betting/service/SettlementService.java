package org.bajiepka.betting.service;

import java.util.List;
import org.bajiepka.betting.dto.SettleBetEventDto;

public interface SettlementService {

  void settleBetsAsync(List<SettleBetEventDto> settlements, Runnable onSuccess, Runnable onFailure);
}
