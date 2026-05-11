# Project Guidelines
    
This project contains a backend application (middleware) and a local environment for simulating betting activities.
The main goal of middleware is to identify incoming Kafka events according to existing bets. 
If the appropriate bet exists – event should be sent for settling to RocketMQ.
Bets must be stored in an in-memory database with entity, having: bet_id, user_id, event_id, event_market_id, event_winner_id, bet_amount columns.

Project structure & descriptions:
* Project contains a Spring Boot Java 25 backend application with Kafka & RocketMQ producers & consumers implemented
* Local environment implemented by using Docker Compose (Kafka, RocketMQ and auxiliary components)
* H2 should be used as an in-memory database by default
* Kafka local environment is configured without security and schemas to avoid connection complexities
* RocketMQ is configured according to default vendor recommentations
