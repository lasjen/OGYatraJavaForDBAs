# OGYatraJavaForDBAs
Example code from Oracle Groundbreakers Yatra 2020 conference

You'll find the corresponding blogs at http://www.jcon.no/oracle/?p=1668.

## Preparing
To create the Oracle user used in the examples below run the following SQL script as SYS.
```
> docker ps -a
> docker exec -it 
CONTAINER ID        IMAGE                         COMMAND                  CREATED             STATUS                      PORTS                                                    NAMES
632f9c634f2e        oracle/database:12.1.0.2-ee   "/bin/sh -c 'exec $O…"   4 days ago          Exited (137) 42 hours ago                                                            ora12c-db-3
2b23de128b15        3dcc49dd7d5f                  "/bin/sh -c 'chmod u…"   4 days ago          Exited (255) 4 days ago                                                              epic_gauss
9cf2c97821e1        oracle/database:19.3.0-ee     "/bin/sh -c 'exec $O…"   5 weeks ago         Exited (255) 4 weeks ago    0.0.0.0:1522->1521/tcp, 0.0.0.0:5502->5500/tcp           ora19-db-02
18f356d106ab        ecp-dwh-batch/centos:8        "bash"                   5 weeks ago         Exited (255) 3 weeks ago                                                             batch-server
13187c2f0455        oracle/database:12.2.0.1-ee   "/bin/sh -c 'exec $O…"   19 months ago       Up 42 hours (healthy)       0.0.0.0:1521->1521/tcp, 5500/tcp, 0.0.0.0:2222->22/tcp   ora12c-db-1
```
Fint the CONTAINER ID for your database container, and run the following:
```
> docker exec -it 13187c2f0455 bash
[oracle@13187c2f0455 ~]$ sqlplus "/as sysdba"

SQL*Plus: Release 12.2.0.1.0 Production on Wed Jul 8 12:35:51 2020

Copyright (c) 1982, 2016, Oracle.  All rights reserved.


Connected to:
Oracle Database 12c Enterprise Edition Release 12.2.0.1.0 - 64bit Production

SQL> 
```
Then run the following SQLs:
```
create user appdata identified by app;
alter user appdata default tablespace users;
alter user appdata quota unlimited on users;
grant create session, alter session, create table, create view, create sequence, create procedure, create type, create trigger, create synonym to appdata;

```
The repository contains the following repositories:
- HelloWorld
- HelloWorldMaven
- HelloJdbc
- FlywayDemo
- SpringBootDemo
- SpringJpaDemo

The repositories was created in the above order.

## Projects
### Project: HelloWorld

Simplest Java application you could think off. 
Here I'm using the Java Compiler (javac) directly to compile the java code.
Additionally I'm using the Jar utility to create a packaged jar-file, together with a manifest file to make the jar executable.

### Project: HelloWorldMaven

With this project I'm introducing the Maven utility.

Commands which is used:
```
> mvn clean compile package
```
The Maven commands could also be ran separately:
```
> mvn clean compile
> mvn package
```

### Project: HelloJdbc
This project is intorducing JDBC code to access the Oracle database.
The code will be accessing an local database (named: orcl) running on default port 1521.
Username which is used is "APPDATA", with password "app".

### Project: FlywayDemo
This project will introduce the FlywayDB utility. We'll be using the maven plugin for flyway (see the BUILD config in the pom.xml).

In this part I talked about the flyway configuration (See plugins part in pom.xml), and the difference between Versioned and Repeatable migration files (Ref. the V1_1__ files and R__* files).

Commands that will be shown:

```
> mvn clean compile flyway:info
> mvn flyway:migrate
> mvn flyway:clean
```

### Project: SpringBootDemo
The project shows the use of Spring and Spring-boot frameworks.
The projects start off by using the Spring Initializr web page (http://start.spring.io).

The example includes java code which uses plain JDBC (See EmployeeJdbcRepository) and the Spring JdbcTemplate (See EmployeeTemplateRepository) to access the database. It also include a repository using JPA and Hibernate (See DocumentRepository).

### Project: SpringJpaDemo
This project build on the last project using JPA and Hibernate, showing different methods of writing java code towards the Oracle database. It also shows how you can use the Oracle Unified Connection Pool (UCP) instead of the pre-configured (Spring Boot) connection pool using HikariPool.

I hole you endjoyed the presentation.
If any questions please send me an e-mail (lasse.jenssen@eritec.no). I can't guarantee an immediate answer, but it's worth a try.
Good luch!