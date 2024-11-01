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
- [API Documentation with Swagger](#API-Documentation-with-Swagger)
- [Conclusion](#Conclusion)
## Introduction
This is a Spring Boot application with CRUD functionalities and CockroachDB integration. This project also includes environment-based encryption and API documentation using Swagger.

## Prerequisites
Make sure you have the following installed on your local machine:
- Java 21
- Maven
- CockroachDB
- IDE (e.g., IntelliJ IDEA, Eclipse)


## Setup Instructions

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

1. Start the application:
   ```bash
   mvn spring-boot:run

2. Access the API on http://localhost:8080.

## Sample API Requests for Testing CRUD Operations

### Create a New User
- **Endpoint**: `/save/users`
- **Method**: `POST`
- **Content-Type**: `application/json`
- **Request Body**:
   ```json
   {
       "firstName": "Gamachis",
       "lastName": "awoke",
       "email": "gamachis@example.com",
       "phoneNumber": "0934567890"
   }
- **Response**:`An empty response with a 200 OK status if successful.` 
### Retrieve All Users
- **Endpoint**: `/users`
- **Method**: `GET`
- **Response**:
   ```json
   [
   {
       "id": "some-uuid",
       "firstName": "Gamachis",
       "lastName": "Doe",
       "email": "gamachis@example.com",
       "phoneNumber": "0934567890"
   },
    {
       "id": "some-uuid",
       "firstName": "gamachis",
       "lastName": "awoke",
       "email": "gamachis@example.com",
       "phoneNumber": "0934567890"
   }
   ]
### Update an Existing User
- **Endpoint**: `/update/users/{id}`
- **Method**: `PUT`
- **Content-Type**: `application/json`
- **Request Body**:
   ```json
   {
       "firstName": "Gamachis",
       "lastName": "awoke",
       "email": "gamachis@example.com",
       "phoneNumber": "0934567890"
   }
- **Response**:`An empty response with a 200 OK status if successful.`
  
### Delete a User
- **Endpoint**: `/delete/users/{id}`
- **Method**: `DELETE`
- **Response**:`An empty response with a 200 OK status if successful.`
- Replace {id} with the unique identifier of the user you want to update or delete.

## Configuring Environment Variables for Encryption
-For encryption, you need to configure an environment variable:
1. In your terminal, set the encryption key:
   ```bash
   set ENCRYPTION_KEY=16TestProjectKey
  Make sure the key length matches the requirements in the project’s encryption configuration.

## API Documentation with Swagger

Swagger UI provides a convenient way to interact with and test the APIs. To enable Swagger:
1. Add the following dependency to your pom.xml:
    ```bash
    <dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.0.2</version>
    </dependency>
2. After starting the application, access Swagger UI at:
    ```bash
     http://localhost:8080/swagger-ui.html
Swagger UI will list all available endpoints and allow you to test CRUD operations directly.

## Conclusion

This project provides a streamlined approach to building and managing a Spring Boot application with CockroachDB integration and CRUD capabilities. With support for encryption, Swagger API documentation, and configurable environment variables, this setup ensures security, scalability, and ease of use for developers. By following the provided instructions, you should be able to set up, configure, and run the application locally, test the CRUD operations, and explore the API endpoints using Swagger. This setup serves as a robust foundation for further enhancements and feature additions in your application.    
