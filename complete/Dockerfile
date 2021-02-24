FROM maven as builder

LABEL name="CitrineInformaticsTechChallenge/zhuoli" \
    maintainer="zhuoliseattle@gmail.com" \
    type="lean"

# TODO: Change this path to where your own project path
WORKDIR /Users/zhuoli/Projects/java/gs-rest-service/complete

COPY . .

# Build
RUN mvn install

# Building from scratch to make it lean and secure
FROM openjdk:17 

# Copy our static executable
WORKDIR /Projects/java/gs-rest-service/complete/target
COPY --from=builder /Users/zhuoli/Projects/java/gs-rest-service/complete/target/*.jar /Projects/java/gs-rest-service/complete/target

# ENTRYPOINT ["java -jar rest-service-0.0.1-SNAPSHOT.jar"]
# ENTRYPOINT ["java --version"]
CMD [ "java", "-jar", "rest-service-0.0.1-SNAPSHOT.jar" ]