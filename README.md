# Domain Driven Design with Spring Boot 

# Dependencies
- docker
- docker-compose
- jdk8

# Usage - local env
## Set local environment
Befor you run the application, run docker MySql container and PhpMyAdmin container from the command line using next command:

``docker-compose up -d``

PhpMyAdmin should be available on `localhost:8000`. Username&Password: ``root:root``

## Run java application
Run these commands from the command line in order to run the application: 
- ``mvn install``
- ``java -jar target/excercise-0.0.1-SNAPSHOT.jar``
The application should be listening on port ``8082``

Run MySql Docker container before you run the integration tests. 
 

