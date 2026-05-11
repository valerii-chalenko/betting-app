package org.bajiepka.betting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bajiepka.betting.domain.Bet;
import org.bajiepka.betting.dto.OutcomeEventDto;
import org.bajiepka.betting.dto.SettleBetEventDto;
import org.bajiepka.betting.kafka.KafkaProducerService;
import org.bajiepka.betting.repository.BetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OutcomesEventService {

    private final KafkaProducerService kafkaProducerService;
    private final BetRepository betRepository;

    public void processEvent(OutcomeEventDto outcomeEventDto) {
        log.info("Processing event: {}", outcomeEventDto);
        kafkaProducerService.sendOutcomeEvent(outcomeEventDto);
    }

    @Transactional(readOnly = true)
    public void publishSettleBets(OutcomeEventDto outcomeEventDto) {
        var settlements = betRepository.findAllByEventId(outcomeEventDto.id()).stream()
            .map(bet -> new SettleBetEventDto(bet.getEventWinnerId(), bet.getAmount()))
            .toList();

        if (!settlements.isEmpty()) {

        }
    }
}
