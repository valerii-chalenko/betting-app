package org.bajiepka.betting.dto.event;

import java.math.BigDecimal;
import java.util.UUID;

public record SettleBetEventDto(
    UUID winnerId,
    BigDecimal amount
) {

}
