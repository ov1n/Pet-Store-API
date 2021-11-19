# PetStore Application

## Introduction

an API implemented to get pets and pet types. 
This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Packaging and running the application

If you want to build the java executable, execute the following command:

    ./gradlew build -Dquarkus.package.type=uber-jar

To run the application:

    java -jar build/petstore-runner.jar

The application can be also packaged using simple:

    ./gradlew build

To launch the test page, open your browser at the following URL

    http://localhost:8080/index.html

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

    ./gradlew quarkusDev

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## The APIs:

### Pets:

-	Get all pets:
 **GET**:  `http://localhost:8080/v1/pets`

-	Get a single pet
**GET**: `http://localhost:8080/v1/pets/{petId}`

-	Add a new pet:
**POST**: `http://localhost:8080/v1/pets/`

-	Update pet:
**PUT**: `http://localhost:8080/v1/pets/` 

-	Delete pet:
**DELETE**: `http://localhost:8080/v1/pets/`

### Pet Types:

-	Get all pet types:
**GET**: `http://localhost:8080/v1/petstype`

-	Get the pet type for a pet:
**GET**: `http://localhost:8080/v1/petstype/{petId}`

-	 Add a new pet type:
**POST**: `http://localhost:8080/v1/petstype`

-	Update pet type:
**PUT**: `http://localhost:8080/v1/pets/` 

-	Delete pet type:
**DELETE**: `http://localhost:8080/v1/pets/ `

## Creating a native executable

Mind having GRAALVM_HOME set to your Mandrel or GraalVM installation.

You can create a native executable using:

    ./gradlew build -Dquarkus.package.type=native

Or, if you don't have [Mandrel](https://github.com/graalvm/mandrel/releases/) or
[GraalVM](https://github.com/graalvm/graalvm-ce-builds/releases) installed, you can run the native executable
build in a container using:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true


### Health

The health status can be used to determine if the 'computing node' needs to be discarded/restarted or not. Specification [here](https://microprofile.io/project/eclipse/microprofile-health)

### Metrics

The Metrics exports _Telemetric_ data in a uniform way of system and custom resources. Specification [here](https://microprofile.io/project/eclipse/microprofile-metrics)

The example class **MetricController** contains an example how you can measure the execution time of a request.  The index page also contains a link to the metric page (with all metric info)

### JWT Auth

Using the OpenId Connect JWT token to pass authentication and authorization information to the JAX-RS endpoint. Specification [here](https://microprofile.io/project/eclipse/microprofile-rest-client)

### Open API

Exposes the information about your endpoints in the format of the OpenAPI v3 specification. Specification [here](https://microprofile.io/project/eclipse/microprofile-open-api)

The index page contains a link to the OpenAPI information of your endpoints.

