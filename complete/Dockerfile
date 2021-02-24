FROM maven as builder

LABEL name="CitrineInformaticsTechChallenge/zhuoli" \
    maintainer="zhuoliseattle@gmail.com" \
    type="lean"

WORKDIR /Users/zhuoli/Projects/java/gs-rest-service/complete

COPY . .

# Build
RUN mvn install

# Building from scratch to make it lean and secure
FROM openjdk

# Copy our static executable
WORKDIR /Projects/java/gs-rest-service/complete/target
COPY --from=builder /Users/zhuoli/Projects/java/gs-rest-service/complete/target/*.jar /Projects/java/gs-rest-service/complete/target

# ENTRYPOINT ["java -jar rest-service-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["ls"]
