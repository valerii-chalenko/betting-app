package org.bajiepka.betting.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "bet")
public class Bet {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "event_id", nullable = false)
    private UUID eventId;

    @Column(name = "event_market_id", nullable = false)
    private UUID eventMarketId;

    @Column(name = "event_winner_id", nullable = false)
    private UUID eventWinnerId;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public UUID getEventMarketId() {
        return eventMarketId;
    }

    public void setEventMarketId(UUID eventMarketId) {
        this.eventMarketId = eventMarketId;
    }

    public UUID getEventWinnerId() {
        return eventWinnerId;
    }

    public void setEventWinnerId(UUID eventWinnerId) {
        this.eventWinnerId = eventWinnerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
