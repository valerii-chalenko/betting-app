package org.bajiepka.betting.repository;

import java.util.List;
import java.util.UUID;
import org.bajiepka.betting.domain.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<Bet, UUID> {

    List<Bet> findAllByEventId(UUID eventId);
}
