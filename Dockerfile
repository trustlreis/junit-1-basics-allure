FROM ubuntu:latest

ARG ALLURE_VERSION
ENV ALLURE_VERSION=${ALLURE_VERSION:-2.22.0}

# Install Java 17
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Install Maven
RUN apt-get install -y maven

# Install Python and its dependencies
RUN apt-get install -y python3 python3-pip
RUN pip3 install --upgrade pip
RUN pip3 install setuptools lxml allure-python-commons

# Install Allure
RUN apt-get install -y curl
RUN curl -o allure-${ALLURE_VERSION}.tgz -Ls https://github.com/allure-framework/allure2/releases/download/${ALLURE_VERSION}/allure-${ALLURE_VERSION}.tgz \
    && tar -zxvf allure-${ALLURE_VERSION}.tgz \
    && rm allure-${ALLURE_VERSION}.tgz
ENV PATH="/allure-${ALLURE_VERSION}/bin:${PATH}"

# Set working directory
WORKDIR /app

# Copy the project files to the container
COPY . /app

# Build the project and the documentation site
RUN mvn clean install site

# Expose the Allure report port
EXPOSE 8080

WORKDIR /app/target/site

# Command to start Allure report server
CMD ["python3", "-m", "http.server", "8080"]
