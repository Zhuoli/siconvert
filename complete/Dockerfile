# Build the backend binary
FROM maven as builder

LABEL name="CitrineInformaticsTechChallenge/zhuoli" \
    maintainer="zhuoliseattle@gmail.com" \
    type="lean"

# Install git + SSL ca certificates.
# Git is required for fetching the dependencies.
# Ca-certificates is required to call HTTPS endpoints.
RUN apk update && apk add --no-cache git ca-certificates && update-ca-certificates

ENV GO111MODULE=on

WORKDIR /Users/zhuoli/Projects/java/gs-rest-service


# Copy the go source
COPY . .

RUN apt install maven -y

# Build
RUN mvn install

# Building from scratch to make it lean and secure
FROM scratch

# Copy our static executable
COPY --from=builder /go/bin/backend /go/bin/backend
# Copy our config files
COPY --from=builder /go/src/goarc.io/arcplatform/customlocations/config/ /config/

# Use an unprivileged user.
USER customlocationsuser:customlocationsuser

ENTRYPOINT ["/go/bin/backend"]
