Template
==============================================================================

[![Java CI with Maven](https://github.com/RyanSkraba/mvn-scala-template/actions/workflows/maven.yml/badge.svg)](https://github.com/RyanSkraba/mvn-scala-template/actions/workflows/maven.yml)

(This is a project in progress)

Using
------------------------------------------------------------------------------

You can import the library into your project from [maven central](https://central.sonatype.com/artifact/com.tinfoiled/docopt4s_2.13):

```xml
<dependency>
  <groupId>com.skraba</groupId>
  <artifactId>template</artifactId>
  <version>0.0.0</version>
</dependency>
```

Building
------------------------------------------------------------------------------

```sh
# Build, format and run all tests
mvn spotless:apply clean verify
```

Running
------------------------------------------------------------------------------

```bash
mvn package
# Using the uber jar
alias mvn-scala-template='java -jar '$(pwd)'/target/mvn-scala-template-*-SNAPSHOT.jar'
mvn-scala-template --help
```
