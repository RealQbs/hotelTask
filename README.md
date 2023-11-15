# Where to find:
1. API - main.kotlin.com.example.beusable.application.rest
2. Domain Models - main.kotlin.com.example.beusable.domain.model
3. Domain Logic - main.kotlin.com.example.beusable.domain.services
4. Tests - test.kotlin.com.example.beusable.service

# Available API:

**POST** "/api/occupancy" | **Request Body**: { "premium": Int, "economy": Int } 

# Note ad Tests

In example tests cases (case 4) there was mistake: *(output) Usage Economy: 1 (EUR 45.99)* but there is no entry 45.99. So I fixed output as it should be: *Usage Economy 1 (EUR 99.99), Usage Premium 7 (EUR 1099)*
