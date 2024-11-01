# TEST-PROJECT 

## Table of Contents
- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
  - [How to Run the Project Locally](#how-to-run-the-project-locally)
  - [How to Set Up CockroachDB](#how-to-set-up-cockroachdb)
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

### How to Run the Project Locally
1. Clone the repository:
   ```bash
   git clone https://github.com/gemmme/test-project.git
   cd test-project

2. Clone the repository:
    ```bash
   mvn clean install

3. Set up the environment variables for encryption:
- **Create a .env file in the root directory and add the following line**:
