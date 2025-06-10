# Use an image of an official, production-ready distribution of the OpenJDK
FROM amazoncorretto:17

# Install tar and gzip to allow Maven wrapper to work
RUN yum install -y tar && yum install -y gzip tar && rm -rf /var/cache/yum

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper files into the container
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# Download the dependencies (necessary for faster builds in the future)
RUN ./mvnw dependency:go-offline -B

# Copy the source code into the container
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Run the application
CMD ["java", "-jar", "/app/target/server-0.0.1-SNAPSHOT.jar"]