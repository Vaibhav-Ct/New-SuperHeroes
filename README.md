# SuperHeroes Management System 🦸‍♂️

## Introduction
Welcome to the **SuperHeroes Management System**! This project is a simple Spring Boot application designed to manage superhero data. You can create, retrieve, update, and delete superhero records using RESTful APIs.

## Features
- 🌟 Insert a new superhero using POST requests.
- 🔍 Retrieve superhero details by name or universe using GET requests.
- 🔄 Update existing superhero details using PUT requests.
- ❌ Delete a superhero by name using DELETE requests.

## Technologies Used
- **Java** – Core programming language
- **Spring Boot** – Framework for building REST APIs
- **MongoDB** – NoSQL database for storing superhero data
- **Docker** – For containerizing the application
- **Postman** – For testing and API interactions


## Installation
To set up the project locally:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Vaibhav-Ct/SuperHeroes-Memory.git

2. Build the application:
./mvnw clean install

4. ./mvnw spring-boot:run
Verify: The application should be running on http://localhost:8080.

5. Running the Application
Once the application is running, you can interact with it using:

### POST - Insert a New Superhero
curl -X POST "http://localhost:8080/api/superhero" -H "Content-Type: application/json" -d '{"name": "Iron Man", "power": "Genius Intellect", "gender": "Male", "age": 45, "universe": "Marvel"}'

### GET - Retrieve All Superheroes
curl -X GET "http://localhost:8080/api/heroes"

### GET - Retrieve Superheroes by Name or Universe
curl -X GET "http://localhost:8080/api/superhero?name=Iron%20Man"

curl -X GET "http://localhost:8080/api/superhero?universe=Marvel"

### PUT - Update Superhero Details
curl -X PUT "http://localhost:8080/api/superheroes/Iron%20Man" -H "Content-Type: application/json" -d '{"power": "Advanced Technology", "age": 46}'

### DELETE - Delete a Superhero
curl -X DELETE "http://localhost:8080/api/superheroes/Iron%20Man"

### Endpoints
Insert a superhero: POST /api/superhero
Insert many superheroes: POST /api/superheroes
Update a superhero: PUT /api/superheroes/{name}
Delete a superhero: DELETE /api/superheroes/{name}
Retrieve by name or universe: GET /api/superhero

### Database
The project uses MongoDB as the database to store superhero records. The MongoDB container is running locally on http://localhost:27017.

### Running MongoDB with Docker
docker run -d -p 27017:27017 --name mongodb-container mongo:6.0.20

