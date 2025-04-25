# 1.  Start Module

## Overview
The **start** module contains the application bootstrap. It defines the `main()` entry point and initializes the Spring context.

## Files and Responsibilities

1. `com.snapgram.SnapgramApplication.java`
    - Annotated with `@SpringBootApplication`.
    - Defines `public static void main(String[] args)` to launch the Spring Boot app.
    - Configured with `@ComponentScan(basePackages = "com.snapgram")` to include all modules.


# 2. Controller Module

## Overview
The **Controller** module is the Presentation Layer in the DDD architecture. It exposes REST and RPC endpoints, handles HTTP requests, and delegates to application services.

## Packages and Responsibilities

1. `com.snapgram.controller.http`
   - Defines RESTful controllers (e.g., `Controller.java`).
   - Maps HTTP routes (`@RestController`, `@GetMapping`) to application service methods.
   - Validates requests and formats responses.

2. `com.snapgram.controller.model`
   - Contains request/response models specific to the controller layer.
   - Transforms between HTTP DTOs and application layer DTOs.

3. `com.snapgram.controller.rpc`
   - Hosts RPC interfaces (e.g., gRPC stubs).
   - Wraps application service calls for programmatic clients.


# 3. Application Module

## Overview
The **Application** module implements the Application Layer of the Domain-Driven Design (DDD) architecture. It orchestrates use cases, coordinates domain model interactions, and exposes high-level operations for the presentation layer.

## Packages and Responsibilities

1. `com.snapgram.application.brokerMQ`
   - Contains message broker integration for asynchronous tasks (e.g., publishing domain events over RabbitMQ or Kafka).
   - Provides publishers and event handlers to decouple application services from infrastructure.

2. `com.snapgram.application.exception`
   - Defines application-specific exceptions (e.g., `HiApplicationException`).
   - Contains error codes and handlers to translate lower-level errors into user-friendly messages.

3. `com.snapgram.application.model`
   - Holds DTOs and input/output data shapes used by application services.
   - Encapsulates request and response structures for use cases.

4. `com.snapgram.application.scheduler`
   - Implements scheduled tasks or batch jobs driven by application logic.
   - Uses Spring Scheduling (e.g., cron jobs for cleanup, report generation).

5. `com.snapgram.application.service`
   - Contains **Application Services** (e.g., `HiApplicationService`).
   - Coordinates calls to domain services, repositories, and infrastructure components.
   - Defines transactional boundaries and enforces consistency across operations.

# 4. Domain Module

## Overview
The **domain** module contains the Domain Layer of the DDD architecture. It encapsulates the core business logic, entities, value objects, and repository interfaces.

## Packages and Responsibilities

1. `com.snapgram.domain.model.entity`
   - Defines JPA entities or aggregate roots (e.g., `HiAggregate`).
   - Contains business rules and invariants enforced within entity methods.

2. `com.snapgram.domain.model.enums`
   - Declares domain-specific enumerations (e.g., status codes, types).

3. `com.snapgram.domain.repository`
   - Specifies repository interfaces (e.g., `HiDomainRepo`).
   - Abstracts persistence operations, enabling different implementations.

4. `com.snapgram.domain.service`
   - Contains domain services implementing complex business logic not naturally bound to a single entity.
   - Coordinates multiple entities and enforces domain invariants.

# 5. Infrastructure Module

## Overview
The **infrastructure** module provides technical implementations for interfaces declared in other layers. It handles persistence, caching, messaging, and external integrations.

## Packages and Responsibilities

1. `com.snapgram.infrastructure.cache`
   - Implements in-memory caching (e.g., Caffeine or `ConcurrentHashMap`).
   - Provides local cache decorators for performance.
   - Integrates with Redis for distributed caching.
   - Defines serializers and cache managers.

2. `com.snapgram.infrastructure.config`
   - Contains Spring configuration classes (e.g., `DataSourceConfig`, `RedisConfig`).
   - Sets up beans, property mappings, and environment-specific settings.

3. `com.snapgram.infrastructure.persistence.mapper`
   - Defines mapping between domain models and persistence models using MapStruct or manual mappers.

4. `com.snapgram.infrastructure.persistence.model`
   - Holds JPA entities or database schemas corresponding to domain entities.

5. `com.snapgram.infrastructure.persistence.repository`
   - Provides repository implementations (e.g., `HiInfrastructureRepo`) that extend Spring Data JPA or custom DAOs.
6. `com.snapgram.infrastructure.security`
   - Implements security features (e.g., JWT, OAuth2).
   - Provides authentication and authorization mechanisms.
   

# Example flow:
```
HTTP Request
    --> Security Filter / Middleware (Infrastructure)
        --> Controller (UI)
            --> Application Service (Application)
                --> Domain Service (Domain)
                    --> Repository Interface (Domain)
                        --> Repository Impl (Infrastructure)
                            --> Database / External Systems
```

[![Onion Architecture](https://www.hibit.dev/images/posts/2021/ddd_layers.png)](https://www.hibit.dev/images/posts/2021/ddd_layers.png)
