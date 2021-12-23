# WisDumb

[![WisDumb Java and Docker Image CI](https://github.com/conivek/wisdumb/actions/workflows/build.yml/badge.svg)](https://github.com/conivek/wisdumb/actions/workflows/build.yml)

A Spring Boot/Java application for silly sayings masquerading as wisdom.

> The real _raison d'etre_ is to provide a project so simple that it doesn't get in the way of testing various modern architecture patterns and facilities, but that can still be contrived to add features to build those tests upon.

## Requirements

These requirements will be adjusted and implemented incrementally.

- UI
  - Unauth'd page to return random "wisdom," e.g., http[s]://<host:port>/ui/enlightenment.
  - Auth'd page for "wisdom" CRUD operations.
  - User registration page with [OpenID Connect](https://openid.net/connect/) provider authentication.
- Internal REST API Service
  - Return random "wisdom."
  - Support for "wisdom" CRUD operations.
- Build Using GitHub Actions
  - Maven build for the Spring Boot/Java app.
  - Docker image build.
  - Store artifacts using GitHub Packages.
- Deploy
  - Helm chart.
  - Deploy chart to local Kubernetes cluster using FluxCD.

## Build and Run

### GitHub CI/CD Workflow

WisDumb is automatically built for commits to the `main` branch, as well as for PRs that target the `main` branch. See [the WisDumb container page](https://github.com/conivek/wisdumb/pkgs/container/wisdumb) for the available WisDumb Docker images. You can run the Docker image locally.

```
$ docker run -it -p 8080:8080 --rm ghcr.io/conivek/wisdumb:pr-5
Unable to find image 'ghcr.io/conivek/wisdumb:pr-5' locally
pr-5: Pulling from conivek/wisdumb
...
Status: Downloaded newer image for ghcr.io/conivek/wisdumb:pr-5

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.1)

2021-12-22 23:23:43.347  INFO 1 --- [           main] conivek.wisdumb.WisdumbApplication       : Starting WisdumbApplication v0.1.0-SNAPSHOT using Java 11.0.13 on ed9dacb01dca with PID 1 (/opt/wisdumb/wisdumb.jar started by root in /)
...
2021-12-22 23:24:14.877  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-12-22 23:24:14.983  INFO 1 --- [           main] conivek.wisdumb.WisdumbApplication       : Started WisdumbApplication in 34.505 seconds (JVM running for 37.19)
```

### Local Workflow

The WisDumb jar file can be built and run from the command-line in the repository root directory.

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

2021-12-22 13:58:55.702  INFO 22280 --- [           main] conivek.wisdumb.WisdumbApplication       : Starting WisdumbApplication v0.1.0-SNAPSHOT using Java 11.0.11 on MC******.
...
2021-12-22 13:59:12.394  INFO 22280 --- [           main] conivek.wisdumb.WisdumbApplication       : Started WisdumbApplication in 23.149 seconds (JVM running for 24.643)
```

Test WisDumb by navigating to the main application UI page at http://localhost:8080/ui/enlightenment.

The WisDumb Docker image can also be built and run from the command-line in the repository root directory.

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

## Deploy

TBD
