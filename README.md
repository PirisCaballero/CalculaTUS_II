# CalculaTUS_II
Second part of CalculaTUS

[![Build Status](https://travis-ci.com/PirisCaballero/CalculaTUS_II.svg?branch=master)](https://travis-ci.com/PirisCaballero/CalculaTUS_II)

## Getting Started
### Prerequisites
* Java 
* MySQL Workbench Server
* Maven

### Building and running the project
These are the steps that need to be followed in order to succesfully build and run the project on Windows:

#### 1. Install the project
1. Open a new CMD window and run the following commands:

Validates that the project is correct and all the necessary information is available.
```
mvn validate
```
Compiles the source code of the project.
```
mvn compile
```
Download dependencies.
```
mvn install
```

#### 2.  Run the client app
1. Open a new CMD window and run the following command:
```
mvn exec:java -Dexec.mainClass="es.deusto.spq.ventanas.VentanaLogin"
```
## Execute the tests
These are the commands that need to be introduced in order to run the project tests on Windows:
###  Tests without performance:
1. Open a new CMD window and run the following commands:

Tests the compiled source code using a suitable testing Framework.
```
mvn clean test
```
Processes and deploys the package if necessary in an environment where testing can be run.
```
mvn integration-test
```
