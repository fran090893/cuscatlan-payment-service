# cuscatlan-payment-service
The payment microservice handles the processing and simulation of payments, integrating with the order microservice to obtain order details for payment calculation.

## Features
- Simulates payment processing.
- Integrates with the order microservice to retrieve order details by order ID.
- User authentication and authorization using JWT.
- Request validation and error handling.

## Prerequisites
- Java 17
- Spring Boot 3.3.4
- Maven 3.x
- H2 Database (for local testing)

## Installation
1. Clone the repository:
   git clone https://github.com/fran090893/cuscatlan-payment-service.git
2. Navigate to the project directory:
   cd productservice
3. Build the project with Maven:
   mvn clean install
4. Run the microservice:
   mvn spring-boot:run