# CalculaTUS_II
Second part of CalculaTUS

[![Build Status](https://travis-ci.com/PirisCaballero/CalculaTUS_II.svg?branch=master)](https://travis-ci.com/PirisCaballero/CalculaTUS_II)

## Getting Started
### Prerequisites
* Java 
* MySQL Workbench Server
* Maven

### Creating a schema in MySQL
1. Open a connection and run the following commands:
```
drop schema if exists calculatusdb;

create schema calculatusdb;

CREATE TABLE categoria(ID_Categoria INTEGER PRIMARY KEY,Nombre varchar(250) NOT NULL) ;


CREATE TABLE elementoscompra ( idTicket INTEGER,Nombre varchar(250) NOT NULL,Precio double NOT NULL,Cantidad int(11) NOT NULL);

CREATE TABLE locales (idLocales INTEGER PRIMARY KEY ,Nombre varchar(250) NOT NULL,Direccion varchar(250) NOT NULL,Codigo_postal int(11) NOT NULL,Opinion varchar(500) DEFAULT null,email_duenio varchar(250) NOT NULL);

CREATE TABLE opiniones ( idopinion INTEGER  PRIMARY KEY ,numEstrellas int(11) NOT NULL,opinion varchar(750) NOT NULL,emailUsuario varchar(250) NOT NULL);

CREATE TABLE productos (idproductos INTEGER PRIMARY KEY ,Nombre varchar(250),Precio double NOT NULL,idLocal int(11) NOT NULL,email_comprador varchar(250) NOT NULL,Categoria varchar(250) DEFAULT NULL);

CREATE TABLE tickets (idtickets INTEGER PRIMARY KEY ,email_comprador varchar(250) NOT NULL,Importe double NOT NULL,idLocal int(11) NOT NULL,fecha varchar(250) NOT NULL);

CREATE TABLE users (name varchar(250) NOT NULL,surname varchar(250) NOT NULL,email varchar(250) PRIMARY KEY,password varchar(250) NOT NULL,admin tinyint(4) NOT NULL DEFAULT 0,admin_email varchar(250) DEFAULT null);

```
2. Insert fixed rows
```
INSERT INTO categoria VALUES ( 0, "Alimentacion");
INSERT INTO categoria VALUES ( 1, "Salud/Higiene");
INSERT INTO categoria VALUES ( 2, "Ocio");
INSERT INTO categoria VALUES ( 3, "Tecnologia");
INSERT INTO categoria VALUES ( 4, "Facturas");
INSERT INTO categoria VALUES ( 5, "Ropa");
```

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
