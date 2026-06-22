# Pet Registration API
A REST API for pet registration and management built with Spring Boot.

## 🌐 Live Demo
API available at: https://desafiocadastrospring-production.up.railway.app

Example:
GET https://desafiocadastrospring-production.up.railway.app/pets

## Features
- Create a new pet
- Update pet information
- Delete a pet
- Find a pet by ID
- List all registered pets
- Search pets using multiple criteria
- Input validation
- Global exception handling
- Unit tests with JUnit and Mockito

## Technologies
- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Hibernate
- JUnit 5
- Mockito
- Maven
- Docker
- Railway (Deploy)

## Requirements
Java 21+

Maven 3.9+

PostgreSQL

## API Endpoints

| Method | Endpoint     | Description             |
| ------ | ------------ | ----------------------- |
| POST   | /pets        | Create a new pet        |
| GET    | /pets        | List all pets           |
| GET    | /pets/search | Search pets by criteria |
| GET    | /pets/{id}   | Find pet by ID          |
| PUT    | /pets/{id}   | Update pet              |
| DELETE | /pets/{id}   | Delete pet              |


## How to Run Locally
1. Clone the repository
git clone https://github.com/DiogoTadashi/desafioCadastroSpring.git
cd desafioCadastroSpring

2. Start the database
docker-compose up -d

3. Configure environment variables

Create a .env file in the root directory:
```
DB_URL=jdbc:postgresql://localhost:5432/petsdb
DB_USER=postgres
DB_PASS=yourpassword
DB_NAME=petsdb
```

4. Run the application
./mvnw spring-boot:run

The API will be available at:
http://localhost:8080

## Search Examples
### By Name

```http
GET /pets/search?name=Nina
```

### By Breed

```http
GET /pets/search?breed=Shih
```

### By Name and City

```http
GET /pets/search?name=Nina&city=Rio%20Preto
```

### By TypePet and SexPet

```http
GET /pets/search?typePet=DOG&sexPet=FEMALE
```
## Request Example
```
POST /pets
{
  "name": "Nina",
  "lastName": "Amorim",
  "typePet": "DOG",
  "sexPet": "FEMALE",
  "address": {
    "street": "Rua 14",
    "city": "Jales",
    "houseNumber": "3054"
  },
  "age": 2.0,
  "ageUnit": "YEARS",
  "weight": 15.5,
  "breed": "Shih Tzu"
}
```
## Author

Diogo Tadashi
[GitHub](https://github.com/DiogoTadashi) · [LinkedIn](https://www.linkedin.com/in/diogotadashi/)
