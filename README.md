# WisDumb

[![Java CI with Maven](https://github.com/conivek/wisdumb/actions/workflows/build.yml/badge.svg)](https://github.com/conivek/wisdumb/actions/workflows/build.yml)

A Spring Boot/Java application for silly sayings masquerading as wisdom.

The real _raison d'etre_ is to provide a project so simple that it doesn't get in the way of testing various modern architecture patterns and facilities, but that can still be contrived to add features to build those tests upon.

## Requirements

These requirements will be adjusted and implemented incrementally.

- UI
  - Unauth'd page to return random "wisdom."
  - Auth'd page for "wisdom" CRUD operations.
  - User registration page with [OpenID Connect](https://openid.net/connect/) provider authentication.
- REST API
  - Unauth'd service to return random "wisdom."
  - Auth'd service for "wisdom" CRUD operations.
- Build
  - Java app build via Maven.
  - Container build.
  > Use GitHub facilities? Local Jenkins server? Where to store artifacts?
- Deploy
  - Helm chart.
  > Target local Kubernetes cluster. Secret management?
- CI/CD
  - Target local Kubernetes cluster. FluxCD?

## Build and Run

WisDumb can be built and run from the command-line with the following commands from the repository root directory.

```
$ mvn clean install
Running `/Users/kevin.condon/repos/wisdumb/mvnw`...
[INFO] Scanning for projects...
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  34.858 s
[INFO] Finished at: 2021-12-22T13:57:41-05:00
[INFO] ------------------------------------------------------------------------

$ java -jar target/wisdumb-0.1.0-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.1)

2021-12-22 13:58:55.702  INFO 22280 --- [           main] conivek.wisdumb.WisdumbApplication       : Starting WisdumbApplication v0.1.0-SNAPSHOT using Java 11.0.11 on MC02RR269FVH6.
...
2021-12-22 13:59:12.394  INFO 22280 --- [           main] conivek.wisdumb.WisdumbApplication       : Started WisdumbApplication in 23.149 seconds (JVM running for 24.643)
```

Test WisDumb by navigating to the main application UI page at http://localhost:8080/ui/enlightenment.

If you have Docker installed, a WisDumb Docker image can also be built and run as follows. Note that a Docker image is automatically built in the project GitHub CI/CD pipeline.

```
$ docker build . --file Dockerfile --tag wisdumb:0.1.0-SNAPSHOT
Sending build context to Docker daemon  66.24MB
...
Successfully built b3bd6e98cc27
Successfully tagged wisdumb:0.1.0-SNAPSHOT

$ docker run -it -p 8080:8080 --rm wisdumb:0.1.0-SNAPSHOT

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.1)

2021-12-22 19:07:31.294  INFO 1 --- [           main] conivek.wisdumb.WisdumbApplication       : Starting WisdumbApplication v0.1.0-SNAPSHOT using Java 11.0.13 on 6d809bb4ba88 with PID 1 (/opt/wisdumb/wisdumb.jar started by root in /)
...
2021-12-22 19:08:09.311  INFO 1 --- [           main] conivek.wisdumb.WisdumbApplication       : Started WisdumbApplication in 41.69 seconds (JVM running for 45.054)
```
