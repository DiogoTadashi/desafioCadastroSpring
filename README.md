Pet Registration API

A REST API for pet registration and management built with Spring Boot.

## Features

* Create a new pet
* Update pet information
* Delete a pet
* Find a pet by ID
* List all registered pets
* Search pets using multiple criteria
* Input validation
* Global exception handling
* Unit tests with JUnit and Mockito

## Technologies

* Java 21
* Spring Boot 3
* Spring Data JPA
* PostgreSQL
* Hibernate
* JUnit 5
* Mockito
* Maven

## Requirements

* Java 21+
* Maven 3.9+
* PostgreSQL


## API Endpoints

| Method | Endpoint     | Description             |
| ------ | ------------ | ----------------------- |
| POST   | /pets        | Create a new pet        |
| GET    | /pets        | List all pets           |
| GET    | /pets/search | Search pets by criteria |
| GET    | /pets/{id}   | Find pet by ID          |
| PUT    | /pets/{id}   | Update pet              |
| DELETE | /pets/{id}   | Delete pet              |

## Search Examples
By Name
GET /pets/search?name=Nina

By Breed
GET /pets/search?breed=Labrador

By Name and City
GET /pets/search?name=Nina&city=Rio%20Preto

By TypePet and SexPet
GET /pets/search?typePet=DOG&sexPet=FEMALE

## Author

Diogo Tadashi
