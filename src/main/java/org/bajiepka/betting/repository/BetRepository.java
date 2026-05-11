package org.bajiepka.betting.repository;

import jakarta.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;
import org.bajiepka.betting.domain.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<Bet, UUID> {

  Optional<Bet> findEventById(@NotNull UUID id);
}
