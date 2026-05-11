package org.bajiepka.betting.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record SettleBetEventDto(
    UUID winnerId,
    BigDecimal amount
) {

}
