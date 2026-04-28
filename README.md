Movie Booking System API
​A robust, scalable Spring Boot REST API for managing movie theater operations, show scheduling, and ticket bookings. The system features a stateless JWT-based authentication layer with Role-Based Access Control (RBAC).
​🚀 Features
​🔐 Security & Authentication
​JWT Integration: Stateless authentication using JSON Web Tokens.
​RBAC (Role-Based Access Control): Granular permissions for USER and ADMIN roles using Spring Security.
​Password Encryption: Secure credential storage using BCryptPasswordEncoder.
​🎬 Movie & Theater Management
​Movie Catalog: Search movies by genre, language, or title.
​Venue Management: Location-based theater discovery.
​Dynamic Scheduling: Link movies to specific theaters with unique showtimes and pricing.
​🎟️ Booking Engine
​Real-time Seat Validation: Prevents double-booking by checking specific seat numbers across existing active bookings.
​Capacity Management: Automatic checks to ensure theater capacity is never exceeded.
​Booking Lifecycle: Status management for PENDING, CONFIRMED, and CANCELLED states.
​Cancellation Policy: Built-in business logic preventing cancellations within 2 hours of showtime.
​🛠️ Tech Stack
​Framework: Spring Boot 3.x
​Security: Spring Security, JJWT (JSON Web Token)
​Persistence: Spring Data JPA
​Database: MySQL / PostgreSQL (JDBC)
​Lombok: To reduce boilerplate code.
​📂 Project Structure
Package Description
.controller REST Endpoints for Auth, Admin, Movies, Theaters, and Bookings.
.service Business logic, seat validation, and security orchestration.
.entity JPA Entities defining the database schema.
.DTO Data Transfer Objects for secure and clean API requests/responses.
.repository Abstraction layer for database queries.
.jwt Custom filters and utilities for token handling.
