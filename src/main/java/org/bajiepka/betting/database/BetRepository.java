package org.bajiepka.betting.database;

import java.util.List;
import java.util.UUID;
import org.bajiepka.betting.database.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<Bet, UUID> {

    List<Bet> findAllByEventId(UUID eventId);
}
