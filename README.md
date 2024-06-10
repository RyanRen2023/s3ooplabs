# Library Management System

## Project Description
This project is an assignment for the Library Management System (LMS), developed as part of the CST8288 course at Algonquin College. The system manages various library events such as workshops, book launches, kids' stories, and movie nights. The project demonstrates the use of design patterns, logging, and database operations.

## Table of Contents
- [Project Description](#project-description)
- [Table of Contents](#table-of-contents)
- [Installation](#installation)
- [Usage](#usage)
- [Classes and Features](#classes-and-features)
- [Tests](#tests)

## Installation

### Prerequisites
- Java 17 or higher
- MySQL
- Maven

### Setup

1. **Clone the repository**
    ```bash
    git clone https://github.com/yourusername/library-management-system.git
    cd library-management-system
    ```

2. **Set up MySQL Database**
    ```sql
    CREATE DATABASE bookvault;
    USE bookvault;
    CREATE TABLE IF NOT EXISTS events (
        event_id INT PRIMARY KEY AUTO_INCREMENT,
        event_name VARCHAR(255) NOT NULL,
        event_description TEXT NOT NULL,
        event_activities TEXT NOT NULL,
        admission_fees DECIMAL(4, 2) NOT NULL
    );
    ```

3. **Update Database Configuration**
   - Update the database connection details in the `DBConnection` class:
     ```java
     private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
     private String userString = "yourUsername";
     private String passwordString = "yourPassword";
     ```

4. **Build the project**
    ```bash
    mvn clean install
    ```

## Usage

### Running the Application

1. **Navigate to the `Client` class and run the `main` method**:
    ```java
    public static void main(String[] args) {
        // Example usage
    }
    ```

### Example Usage
- The `Client` class demonstrates how to create various events and store them in the database.
- Sample code to create and manage events:
    ```java
    Library publicLibrary = LibraryFactory.getLibraryByType(LibraryType.PUBLIC);
    Event movieNight = publicLibrary.createEvent(EventType.MOVIE_NIGHT);
    movieNight.setEventName("Summer Movie Night");
    movieNight.setEventDescription("A fun outdoor movie night.");
    DBOperations.createEvent(movieNight);
    ```

## Classes and Features

### Key Classes
- **Event**: Abstract class representing a generic event.
- **EventType**: Enumeration of event types.
- **Library**: Abstract class for libraries.
- **LibraryFactory**: Factory class for creating library instances.
- **LMSLogger**: Singleton logger class for handling log messages.
- **DBConnection**: Singleton class for managing database connections.
- **DBOperations**: Class for performing CRUD operations on the database.

### Logging
- The project uses `LMSLogger` for logging messages at different levels (INFO, DEBUG, ERROR, TRACE, WARN).

### Database Operations
- The `DBOperations` class provides methods to create, retrieve, update, and delete events in the MySQL database.

## Tests

### Running Tests
- The project includes JUnit tests for key functionalities. To run the tests, use:
    ```bash
    mvn test
    ```

### Key Test Classes
- `DBConnectionTest`
- `DBOperationsTest`
- `BookLaunchEventTest`
- `KidsStoryEventTest`
- `MovieNightEventTest`
- `WorkShopEventTest`
- `LMSLoggerTest`

