

# Requirement: Java11, Maven, Docker

## Build docker image and run:  
1. Replace "/Users/zhuoli/Projects/java/gs-rest-service/complete" to "{your project location}/gs-rest-service/complete" in complete/Dockerfile
1. cd ./complete
1. make image
1. make run

## Run locally:
1. cd ./complete
1. mvn install
1. cd ./target 
1. java -jar rest-service-0.0.1-SNAPSHOT.jar
