# StudentService
A service for CRUD operations available to authorized users via JWT

♦ Project Stack:
* Java 17
* Spring Boot 3.3.5
* Spring Data JPA
* postgresql
* oAuth2
* Docker
* Lombok  

♦ Instructions for deploying the project:
* Build a project using mvn commands
    * `clean`
    * `install`
* Build an image and run the docker container using the command:
    * `docker build -t student-service . && docker compose up`

To test the application, you can use:    
* A ready-made collection of requests in Postman, they are located in the directory ./StudentService.postman_collection.json;  
* Using CURL queries.

♦ CURL requests:
1. User registration:
   ```zsh
   curl -X POST "http://localhost:8080/api/auth/register"   -H "Content-Type: application/json"   -d '{  
    "username": "user_name",  
    "email": "user_email",  
    "password": "user_password"
   }'  
   ```
2. User authentication and receipt in the JWT response:
   ```zsh
   curl -X POST "http://localhost:8080/api/auth/login"   -H "Content-Type: application/json"   -d '{
    "username": "user_name",  
    "password": "user_password"
   }'  
   ```

***

(**All requests are made with the JWT(Access Token) you received in paragraph 2**)

3. Adding information about a new student:
```zsh
   curl -X PUT "http://localhost:8080/api/resource"   -H "Content-Type: application/json"   -H "Authorization: bearer $yourToken"   -d '{
    "firstName": "student_first_name",  
    "lastName": "student_second_name",  
    "patronymic": "student_patronymic",  
    "groupStudents": "student_group",  
    "averageGrade": "student_average_grade"
}' 
```
4. Getting information about a student by id:
```zsh
    curl -X GET "http://localhost:8080/api/resource/{id}"   -H "Authorization: bearer $yourToken" 
```
5. Updating student information by id:
```zsh
    curl -X POST "http://localhost:8080/api/resource"   -H "Content-Type: application/json"   -H "Authorization: bearer $yourToken"   -d '{
    "id":  "user_id",  
    "firstName": "user_firstName",  
    "lastName": "user_lastName",  
    "patronymic": "user_patronymic",  
    "groupStudents": "user_group_students",  
    "averageGrade": "user_average_grade"
}'
```
6. Deleting information about a student by id:
```zsh
    curl -X DELETE "http://localhost:8080/api/resource/{id}"   -H "Authorization: bearer $yourToken" 
```

