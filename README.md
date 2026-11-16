# Reactive Employee Management API
## Technology Stack
- Java 21
- Spring Boot
- Spring WebFlux
- Spring Data R2DBC
- PostgreSQL
- Maven
## Employee API Endpoints
Base URL: http://localhost:8081
| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | /api/employees | Create an employee |
| GET | /api/employees | Get all employees |
| GET | /api/employees/{id} | Get employee by ID |
| PUT | /api/employees/{id} | Update an employee |
| DELETE | /api/employees/{id} | Delete an employee |
## Sample Employee JSON
{
"employeeName": "John",
"salary": 50000.0
}
## Run the Application
Build:
mvn clean package
Run:
mvn spring-boot:run
## Test the API
Get all employees:
curl http://localhost:8081/api/employees
Get employee by ID:
curl http://localhost:8081/api/employees/1
Create employee:
curl -X POST http://localhost:8081/api/employees \
-H "Content-Type: application/json" \
-d '{"employeeName":"John","salary":50000}'

