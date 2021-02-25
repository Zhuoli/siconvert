
# Description:
A Docker enabled WebServer to convert any properly formatted unit string to their SI counterparts.

### Convert Units
```
    METHOD: GET
    PATH: /units/si
    PARAMS: units - A unit string*
    RETURNS: conversion - A conversion object**
```
### Example Request:

```
GET /units/si?units=(degree/(minute*hectare)

{
      "unit_name": (rad/(s*m2)),
      "multiplication_factor": 2.9088820866572E-8
}

GET /units/si?units=(degree/minute)

{
      "unit_name": (rad/s),
      "multiplication_factor": 2.9088820866572E-4
}
```

# Requirement: Java11, Maven, Docker

## Build docker image and run:  
1. Update DockerFile: Replace "/Users/zhuoli/Projects/java/gs-rest-service/complete" to "{your project location}/gs-rest-service/complete" in complete/Dockerfile
1. cd ./complete
1. make image
1. make run

## Run locally:
1. cd ./complete
1. mvn install
1. cd ./target 
1. java -jar rest-service-0.0.1-SNAPSHOT.jar


## Run UnitTest
1. cd ./complete
1. mvn install
