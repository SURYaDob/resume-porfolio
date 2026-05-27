# Suraj Dobale - Portfolio Backend API

A **Spring Boot 3.2** REST API backend for Suraj Dobale's developer portfolio. Built with Java 17, H2 database, and Spring Data JPA.

## 🚀 Quick Start

### Prerequisites
- Java 17+ installed
- Maven 3.8+ (or use the Maven Wrapper)

### Run the application

```bash
# Clone and navigate to the backend
cd resume-porfolio/backend

# Build and run
./mvnw spring-boot:run

# Or with Maven directly
mvn spring-boot:run
```

The API will start at **http://localhost:8080**.

### Run tests

```bash
mvn test
```

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/health` | Health check with status, version, and timestamp |
| `GET` | `/api/info` | Get portfolio profile information |
| `GET` | `/api/projects` | List all featured projects |
| `GET` | `/api/skills` | List all technical skills with proficiency levels |
| `POST` | `/api/contact` | Submit a contact form message |
| `GET` | `/api/contact/messages` | Get all submitted messages |
| `GET` | `/api/contact/unread-count` | Get count of unread messages |
| `PUT` | `/api/contact/{id}/read` | Mark a message as read |
| `GET` | `/h2-console` | H2 Database console (dev only) |

## 📝 Example Requests

### Submit Contact Form
```bash
curl -X POST http://localhost:8080/api/contact \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Recruiter Name",
    "email": "recruiter@company.com",
    "subject": "Job Opportunity",
    "message": "Hi Suraj, we have an exciting opportunity for you!"
  }'
```

### Health Check
```bash
curl http://localhost:8080/api/health
```

## 🏗️ Project Structure

```
backend/
├── pom.xml
├── README_BACKEND.md
└── src/
    ├── main/
    │   ├── java/com/portfolio/
    │   │   ├── PortfolioApplication.java    # Entry point
    │   │   ├── config/
    │   │   │   └── CorsConfig.java          # CORS configuration
    │   │   ├── controller/
    │   │   │   ├── HealthController.java     # Health check endpoint
    │   │   │   ├── ContactController.java    # Contact form CRUD
    │   │   │   └── ProjectController.java    # Projects & skills API
    │   │   ├── model/
    │   │   │   ├── ContactMessage.java       # JPA entity
    │   │   │   ├── Project.java              # JPA entity
    │   │   │   └── Skill.java                # JPA entity
    │   │   ├── repository/
    │   │   │   └── ContactMessageRepository.java
    │   │   └── service/
    │   │       └── ContactService.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/com/portfolio/
            ├── PortfolioApplicationTests.java
            └── controller/
                └── ContactControllerTest.java
```

## 🛠️ Tech Stack

- **Java 17** — Modern Java with records, sealed classes, and pattern matching
- **Spring Boot 3.2** — Auto-configuration, embedded Tomcat
- **Spring Web** — RESTful API endpoints
- **Spring Data JPA** — Database access with Hibernate
- **H2 Database** — In-memory database for development
- **Jakarta Validation** — Request validation annotations
- **JUnit 5 + MockMvc** — Comprehensive testing
- **Maven** — Build and dependency management

## ☁️ Deployment Options

### Render (Free)
1. Push this repo to GitHub
2. Go to [render.com](https://render.com) → New Web Service
3. Connect your GitHub repo
4. Set:
   - **Root Directory:** `backend`
   - **Build Command:** `./mvnw clean package -DskipTests`
   - **Start Command:** `java -jar target/portfolio-backend-1.0.0.jar`
5. Add environment variable: `SPRING_PROFILES_ACTIVE=prod`

### Railway (Free)
1. Push this repo to GitHub
2. Go to [railway.app](https://railway.app) → New Project
3. Deploy from GitHub → Select `backend` directory
4. Railway auto-detects Maven projects

### Update the Frontend
After deploying, update the form action in `index.html`:
```html
<!-- Replace Formspree URL with your backend URL -->
<form id="contactForm" action="https://your-app.onrender.com/api/contact" method="POST">
```

## 📧 Production Email

For production, configure SMTP in `application.properties`:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=surajdobale29@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

Enable 2FA on Gmail and generate an App Password for the SMTP password.

---

Built with ☕ Java, Spring Boot, and ❤️
