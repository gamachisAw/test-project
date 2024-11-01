# TEST-PROJECT 

A Spring Boot application with CRUD functionalities and CockroachDB integration. This project also includes environment-based encryption and API documentation using Swagger.

## Table of Contents
- [Introduction](#introduction)
- **Prerequisites**
- **Setting Up the Project Locally**
- **Configuring CockroachDB**
- **Running the Project Locally**
- **API Testing with Sample Requests**
- **Environment Variables Configuration**
- **API Documentation with Swagger**

## Prerequisites
Make sure you have the following installed on your local machine:
- Java 21
- Maven
- CockroachDB
- IDE (e.g., IntelliJ IDEA, Eclipse)


### 1. Event Creation & Management
- **Functionality**: Create, edit, and delete events with details such as name, description, location, date/time, and ticket information.
- **UI/UX**: Intuitive dashboard for organizers, with responsive design for desktop and mobile.

### 2. Ticketing System
- **Functionality**: Define different ticket types (free or paid), set prices, and limit availability. Generate QR-coded e-tickets.
- **UI/UX**: Seamless ticket selection and checkout with email confirmations.

### 3. RSVP System
- **Functionality**: Attendees can RSVP for events (both free and paid), and organizers can track real-time attendance.
- **UI/UX**: Simple RSVP buttons and real-time attendance lists.

### 4. User Authentication
- **Functionality**: Secure user registration and login, with roles-based access (organizers and attendees).
- **UI/UX**: Fast and simple registration with error handling, password reset, and role-based dashboards.

### 5. Payment Integration
- **Functionality**: Secure payment processing for ticket purchases, with transaction records and refund options.
- **UI/UX**: Intuitive and secure checkout flow, with email receipts and confirmation.

## Technical Infrastructure

### Database
- **Primary DB**: PostgreSQL for managing events, ticket data, RSVP tracking, and user authentication.
- **Real-Time Data**: Redis or Firebase for real-time RSVP tracking.

### Hosting & Deployment
- **Cloud Platform**: AWS, DigitalOcean, or Heroku for scalable hosting.
- **CI/CD Pipeline**: GitHub Actions or Jenkins for automating testing and deployment.

## Setting Up the Project

### Prerequisites

Ensure you have the following installed before starting the project:

- [Node.js](https://nodejs.org) (version 16.x or above)
- [Git](https://git-scm.com) 
- [Visual Studio Code (VSCode)](https://code.visualstudio.com)
- [PostgreSQL](https://www.postgresql.org/) for backend database

### Cloning the Repository

Clone the repository and navigate into the project directory:

```bash
git clone <repository-url>
cd <project-directory>
```

### Installing Dependencies

Install frontend and backend dependencies:

```bash
# For frontend
npm install

# For backend (Spring Boot dependencies)
mvn install
```

### Running the Project

Start the frontend and backend servers:

```bash
# Frontend
npm run dev

# Backend (using Maven)
mvn spring-boot:run
```

The application will be accessible at `http://localhost:3000` for the frontend.

## Contributing

Contributions are welcome! If you want to contribute to the project, please open an issue or create a pull request with a description of your proposed changes.

## License

This project is licensed under the MIT License.
