nomad-api [![Build Status](https://travis-ci.org/zanella/nomad-api.png?branch=master)](https://travis-ci.org/zanella/nomad-api)
==============================================================================================================

Java client for Nomad's HTTP API (https://www.nomadproject.io)

## How to use
```java
import io.github.zanella.nomad.NomadClient;

final NomadClient nomadClient = new NomadClient("localhost");

nomadClient.v1.<api>.<endpoint>
```


## How to add nomad-api into your project
### Gradle
```
compile "io.github.zanella.nomad:nomad-api:0.6"
```
### Maven
```
<dependency>
  <groupId>io.github.zanella.nomad</groupId>
  <artifactId>nomad-api</artifactId>
  <version>0.6</version>
</dependency>
```


## How to build from sources
* Checkout the sources
* `mvn package`


## ToDo

 - implement JobSpec
 - Blocking Queries
