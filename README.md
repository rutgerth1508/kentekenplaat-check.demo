
# Dutch License Plate Validator

This is a Spring Boot application that validates Dutch license plates based on specified formats. The application provides an API to check the validity of license plates and returns the type of license (REGULAR, ROYAL, or DIPLOMATIC).

## Prerequisites

- Java 17
- Gradle
- An IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor

## Getting Started

### Build the Project

To build the project, run the following command:

```bash
./gradlew build
```

### Run the Application

To run the application, use the following command:

```bash
./gradlew bootRun
```

Once the application is running, you can access the Swagger UI at:

```
http://localhost:8080/swagger-ui/index.html
```

### Testing the Application

To run the tests, execute the following command:

```bash
./gradlew test
```

This will run all the unit tests defined in the project.

## API Endpoints

The application exposes an API endpoint to validate license plates. You can use tools like Postman or curl to test the API.

### Example Request

To validate a license plate, send a GET request to:

```
http://localhost:8080/api/license-plates/AA-38-73/validate
```

### Response

The API will return a JSON response indicating the validation result:

```json
{
  "valid": true,
  "result": "REGULAR"
}
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/)
