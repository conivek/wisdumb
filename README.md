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
