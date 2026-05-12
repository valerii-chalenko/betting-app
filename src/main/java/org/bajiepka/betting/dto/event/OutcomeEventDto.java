package org.bajiepka.betting.dto.event;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record OutcomeEventDto(
    @NotNull
    UUID id,
    @NotNull
    UUID winnerId,
    @NotNull
    String name
) {

}
