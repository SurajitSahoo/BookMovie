# 🎬 Movie Booking System API

A robust and scalable Spring Boot REST API for managing movies, theaters, show scheduling, and ticket bookings. The application uses JWT-based authentication and Role-Based Access Control (RBAC) to secure endpoints and manage user permissions.

## 🚀 Features

### 🔐 Authentication & Security
- JWT-based stateless authentication.
- Role-Based Access Control (USER and ADMIN).
- Password encryption using BCrypt.
- Secured REST endpoints using Spring Security.

### 🎥 Movie Management
- Retrieve and search movies by title, genre, and language.
- Manage movie details and information.
- Admin-controlled movie operations.

### 🏢 Theater & Show Management
- Manage theater details and locations.
- Schedule movies in specific theaters.
- Configure showtimes and ticket prices.
- Manage show availability and theater capacity.

### 🎟️ Booking Management
- Book tickets for available shows.
- Validate seat availability.
- Prevent duplicate seat bookings.
- Manage booking statuses: PENDING, CONFIRMED, and CANCELLED.
- Cancellation policy that prevents cancellation within two hours of showtime.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| Spring Boot | REST API development |
| Spring Security | Authentication and authorization |
| JWT | Token-based authentication |
| Spring Data JPA | Database operations |
| MySQL / PostgreSQL | Relational database |
| Maven | Dependency management |
| Lombok | Reducing boilerplate code |
| Postman | API testing |
| Git & GitHub | Version control |

## 📂 Project Structure

```text
MovieBooking/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/MovieBooking/App/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── model/
│   │   │       ├── dto/
│   │   │       ├── config/
│   │   │       ├── security/
│   │   │       └── AppApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── .gitignore
└── README.md
```

*Note: Adjust package and folder names to match your actual source code.*

## ⚙️ Installation & Setup

### Prerequisites
- Java 17 or the Java version configured in the project.
- Maven.
- MySQL or PostgreSQL.
- Postman (optional, for API testing).

### 1. Clone the Repository

```bash
git clone https://github.com/SurajitSahoo/BookMovie.git
cd BookMovie
```

### 2. Configure the Database

Create a database in MySQL:

```sql
CREATE DATABASE bookmovie;
```

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/bookmovie}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:your_password}

spring.jpa.hibernate.ddl-auto=update
```

Configure your JWT secret using an environment variable as well. Never commit real credentials or signing secrets to GitHub.

### 3. Run the Application

```bash
mvn spring-boot:run
```

The backend will start at:

`http://localhost:8080`

## 🔑 Authentication Flow

1. Register a user account.
2. Log in with valid credentials.
3. Receive a JWT token.
4. Include the token in the `Authorization` header for secured endpoints.
5. Access resources according to the assigned role.

Example:

```http
Authorization: Bearer <your_jwt_token>
```

## 🔌 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/registernormaluser` | Register a user |
| POST | `/api/auth/login` | Authenticate a user |
| GET | `/api/movies/getallmovies` | Retrieve all movies |
| POST | `/api/booking/createbooking` | Create a booking |

*These are example endpoints based on the project API; verify them against your actual controller mappings.*

## 🧪 Testing

Use Postman to test the REST APIs.

- Test user registration and login.
- Verify JWT authentication.
- Check USER and ADMIN permissions.
- Test movie and show management.
- Verify seat availability and booking cancellation rules.

## 🔒 Security Highlights

- Passwords are stored using BCrypt hashing.
- JWT supports stateless authentication.
- Role-based authorization protects restricted operations.
- Environment variables can be used to manage sensitive configuration.
- Booking validation checks seat availability before confirming a reservation.

## 🔮 Future Enhancements

- Online payment integration.
- Email and SMS booking notifications.
- Movie ratings and reviews.
- Seat selection with a visual seating layout.
- Docker-based deployment.
- Automated unit and integration testing.

## 🖼️ Screenshots

### Home Page
![Home Page](src/images/Home.png)

### Login Page
![Login Page](src/images/LogIN.png)

### Booking Page
![Movies Page](src/images/Movies.png)

## 👨‍💻 Author

**Surajit Sahoo**

- GitHub: [SurajitSahoo](https://github.com/SurajitSahoo)
