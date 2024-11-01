# E-connect Event Management System (EMS)

**E-connect** is an event management platform aimed at simplifying the process of creating, managing, and attending events. Designed by **2GS Group**, this system allows event organizers to handle event creation, ticket sales, RSVP tracking, and secure payment integration. The Minimum Viable Product (MVP) for Phase 1 focuses on core functionality for both event organizers and attendees.

## Objectives of Phase 1 (MVP Development)

- **Event Creation and Management**: Create, edit, and manage events.
- **Ticketing System**: Both free and paid event ticketing with QR-coded e-tickets.
- **Payment Integration**: Secure payment processing for ticket sales.
- **RSVP Tracking**: Real-time RSVP management for event organizers.
- **User Authentication**: Secure registration and roles-based access.

## Frontend Development Stack

- **Next.js & React.js**: For building fast, server-rendered web applications.
- **Material UI (MUI)**: UI library for consistent design across the platform.
- **Tailwind CSS**: Utility-first CSS framework for custom UI development.
- **Axios**: For handling API requests efficiently.
- **Redux or Context API**: For managing state across the application.
- **React Router**: For seamless navigation across event pages, dashboards, and ticketing system.

## Backend Development Stack

- **Spring Boot**: Backend framework for handling event-related APIs, authentication, and secure payment gateways.
- **Spring Security**: For user authentication and roles-based access.
- **JWT Authentication**: Secure user sessions and access control.
- **PostgreSQL**: Primary database for structured data storage, including event details, tickets, RSVPs, and user data.
- **Redis or Firebase**: For real-time data syncing, especially for RSVP tracking.
- **OAuth 2.0**: Secure third-party authentication.

## Core Features (MVP)

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
