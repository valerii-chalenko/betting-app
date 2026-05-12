# Run application

1. Have Java 21 JDK installed
2. Build application with `./mvnw clean install`
3. Remove image if exists by `docker image rm betting-app:latest --force`
3. Build the application environment using two options below:

This application supports two running modes:
- 1. Standalone (with both Kafka and RocketMQ working in local environment)
- 2. Docker (with Kafka and RocketMQ mock enabled, due to technical issues while container setup)

Please, choose the appropriate environment setup for the mentioned modes:
- For Standalone use `docker compose -f .\docker-compose.yml -f .\docker-compose.local.yml up -d` 
- For Docker use `docker compose -f .\docker-compose.yml up -d`

This will start Kafka broker and RocketMQ broker locally with appropriate hosts and ports configured.

# Use application

Application contains test data that could be used to display betting flow - predefined bets by event `40575836-5ad7-4512-bf67-3016966a42c4` at database:

- 97159469-1d83-4889-8785-f36ea77b3aae
- 2a337aaa-0c06-4617-951a-e07f1832b107

Please, use them to validate bet settlement flow by using any http request tool like:

```http request
###
POST http://localhost:8081/api/v1/events
Content-Type: application/json

{
    "id": "40575836-5ad7-4512-bf67-3016966a42c4",
    "winnerId": "18935861-3ea6-4d7f-bc4f-a731a8dec151",
    "name": "Some name"
}
```

If you're using IntelliJ Idea - simply execute http request from file `bet-outcomes.http`
