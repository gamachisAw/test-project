# TEST-PROJECT 

## Table of Contents
- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
  - [Setup Project Locally](#setup-Project-Locally)
  - [How to Set Up CockroachDB](#how-to-set-up-cockroachdb)
  - [How to Run the Project Locally](#how-to-run-the-project-locally)
- [Sample API Requests for Testing CRUD Operations](#sample-api-requests-for-testing-crud-operations)
- [Configuring Environment Variables for Encryption](#configuring-environment-variables-for-encryption)
- [License](#license)

## Introduction
This is a Spring Boot application with CRUD functionalities and CockroachDB integration. This project also includes environment-based encryption and API documentation using Swagger.

## Prerequisites
Make sure you have the following installed on your local machine:
- Java 21
- Maven
- CockroachDB
- IDE (e.g., IntelliJ IDEA, Eclipse)


## Setup Instructions
1. Clone the repository:

### Setup Project Locally
1. Clone the repository:
   ```bash
   git clone https://github.com/gemmme/test-project.git
   cd test-project

2. Install the project dependencies:
    ```bash
   mvn clean install

3. Make sure Java 21 is installed and set up properly, as the project relies on this version.

### How to Set Up CockroachDB
1. Install CockroachDB by following the instructions on the official CockroachDB website.
   
2. Start a local CockroachDB cluster:
    ```bash
     start-single-node --insecure --listen-addr=localhost:26257 --http-addr=localhost:3030
    
3. Create the database: Open another terminal window and execute the following command to enter CockroachDB SQL shell:
    ```bash
    cockroach sql --insecure

4. Create the database:
    ```bash
     CREATE DATABASE test;
5. Update your application.properties file to include CockroachDB connection details:
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:26257/test?sslmode=disable
   spring.datasource.username=root
   spring.datasource.password=
   spring.datasource.driver-class-name=org.postgresql.Driver

         
### How to Run the Project Locally

3. Set up the environment variables for encryption:
4. 
   
- **Create a .env file in the root directory and add the following line**:
  ```bash
  ENCRYPTION_KEY=16TestProjectKey.

4. Run the application:
   ```bash
   mvn spring-boot:run
5. The application should now be running on http://localhost:8080.
