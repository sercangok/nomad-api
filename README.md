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

### Repo
```
maven { url 'https://dl.bintray.com/sercangok/maven'}
```

### Gradle
```
compile 'com.dev.sgok.zanella.nomad:nomad-api:1.0.1'
```
### Maven
```
<dependency>
  <groupId>com.dev.sgok.zanella.nomad</groupId>
  <artifactId>nomad-api</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```


## How to build from sources
* Checkout the sources
* `mvn package`


## ToDo

 - implement JobSpec
 - Blocking Queries
