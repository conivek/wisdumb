# WisDumb

[![WisDumb Java and Docker Image CI](https://github.com/conivek/wisdumb/actions/workflows/build.yml/badge.svg)](https://github.com/conivek/wisdumb/actions/workflows/build.yml)

A Spring Boot/Java application for silly sayings masquerading as wisdom.

> The real _raison d'etre_ is to provide a project so simple that it doesn't get in the way of testing various modern architecture patterns and facilities, but that can still be contrived to add features to build those tests upon.

## Requirements

**Status**: Build pipeline is complete. App consists of only a stubbed HTML page. Next step will be support for deployment to Kubernetes.

- UI
  - Unauth'd page to return random "wisdom," e.g., http[s]://<host:port>/ui/enlightenment. _\[DONE\]_
  - Auth'd page for "wisdom" CRUD operations.
  - Use [OpenID Connect](https://openid.net/connect/) provider authentication.
- Internal REST API Service
  - Return random "wisdom."
  - Support for "wisdom" CRUD operations.
- Build Using GitHub Actions _\[DONE\]_
  - Maven build for the Spring Boot/Java app. _\[DONE\]_
  - Docker image build. _\[DONE\]_
  - Store artifacts using GitHub Packages. _\[DONE\]_
- Deploy
  - Package using a Helm chart.
  - Deploy Helm chart to local Kubernetes cluster using FluxCD.

## Build and Run

### GitHub CI/CD Workflow

WisDumb is automatically built for commits to the `main` branch, as well as for PRs that target the `main` branch. See [the WisDumb container page](https://github.com/conivek/wisdumb/pkgs/container/wisdumb) for the available WisDumb Docker images. You can run the Docker image locally.

```
$ docker run -it -p 8080:8080 --rm ghcr.io/conivek/wisdumb:main
Unable to find image 'ghcr.io/conivek/wisdumb:main' locally
main: Pulling from conivek/wisdumb
97518928ae5f: Already exists
56981b1bb25b: Already exists
36467aa27abe: Already exists
24f54b022573: Already exists
43b2490fd519: Pull complete
83237ec07d2c: Pull complete
Digest: sha256:1c898bf20a0b2ee00a193a7cae0f9204e4328687bc6936e67b870793321d36ed
Status: Downloaded newer image for ghcr.io/conivek/wisdumb:main

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.1)

2021-12-23 18:44:14.300  INFO 1 --- [           main] conivek.wisdumb.WisdumbApplication       : Starting WisdumbApplication v0.1.0-SNAPSHOT using Java 11.0.13 on 93d61a98b7d0 with PID 1 (/opt/wisdumb/wisdumb.jar started by root in /)
...
2021-12-23 18:44:50.142  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-12-23 18:44:50.209  INFO 1 --- [           main] conivek.wisdumb.WisdumbApplication       : Started WisdumbApplication in 38.748 seconds (JVM running for 40.954)
```

### Local Workflow

The WisDumb jar file can be built and run from the command-line in the repository root directory.

```
$ mvn package
Running `/Users/kevin.condon/repos/wisdumb/mvnw`...
[INFO] Scanning for projects...
...
[[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  30.694 s
[INFO] Finished at: 2021-12-23T13:24:53-05:00
[INFO] ------------------------------------------------------------------------

$ java -jar target/wisdumb-0.1.0-SNAPSHOT.jar
...
```

Test WisDumb by navigating to the main application UI page at http://localhost:8080/ui/enlightenment.

The WisDumb Docker image can also be built and run from the command-line in the repository root directory.

```
$ docker build . --file Dockerfile --tag wisdumb:local
docker build . --file Dockerfile --tag wisdumb:local
Sending build context to Docker daemon  66.39MB
...
Successfully built ccf6b9135536
Successfully tagged wisdumb:local

$ docker run -it -p 8080:8080 --rm wisdumb:local
...
```

## Deploy

TBD
