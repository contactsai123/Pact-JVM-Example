
***Pact-JVM-Example***

Basic example of Consumer driven contract testing using Pact JVM broker and Gradle

**Overview of the PACT contract testing framework:**

I have 1 provider called "UserService" in src/main and 2 consumers "Consumer A" and "Consumer B" in src/test

UserService when called returns 4 attributes: {"name":"Peter","empid":"214","age":30,"salary":72402} where Salary is a random number between 50000 to 75000

Consumer A consumes only empid and age attributes

Consumer B consumes only name and empid attributes

salary attribute is not consumed by either Consumer A or Consumer B

Clone the project in your local

**1) How to run Provider:**
* First build the project and download dependenices ./gradlew clean build -xtest
* Run the gradle command ./gradlew bootRun
* or you can run UsrApplication.java from src/main package in IDE (Eclipse or similar)
* Open the browser: http://localhost:8111/user/Peter/214

**2) How to run Consumers:**
Build the project ./gradlew clean build -xtest


**3) To create PACT files:**
* Run the command ./gradlew test
* Pact files can be viewed in 'pacts' directory


**4) To publish PACT files to PACT broker:**
* Run the command ./gradlew pactPublish
* You need to set the pactURL, pactUsername and pactPassword in gradle.properties.
* You can register for a free broker at https://pact.dius.com.au/ or spin up a docker container (https://github.com/DiUS/pact_broker-docker)
* Once set, you can see the pact files being published in the Pact Broker

**5) To verify the Contract results in PACT broker:**
* Uncomment the line hasPactsFromPactBroker and comment hasPactsWith block in build.gradle
* Run the command ./gradlew pactVerify
* View the pact results in the Pact broker
