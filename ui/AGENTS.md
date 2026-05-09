# AGENTS.md — UI Automation Framework

## Project state

Phase 2 (Page Object Model Refactor) complete. Selenium + TestNG + Maven Surefire are configured in `pom.xml`. `LoginTest.java` uses `LoginPage` and `BasePage` with no hardcoded locators. Browser creation remains inline (not yet managed by a driver factory).

## How to build

```powershell
mvn clean test
```

Runs the existing TestNG tests via Maven Surefire.

## Implementation sequence

The 20 phases are defined in `Selenium_Framework_Prompts/phase_*.txt`. Each phase must be implemented strictly one at a time, top to bottom. Phase `N` must be complete before starting phase `N+1`. Do not add technology not listed in the current phase's scope.

Key phase dependencies:
- Phase 1: add Selenium + TestNG + Maven Surefire to `pom.xml`
- Phase 3: add Owner config library
- Phase 6: create `testng.xml` under `src/test/resources/`
- Phase 8: add AssertJ
- Phase 9: add SLF4J/Logback
- Phase 10: add Allure
- Phase 12: JSON-based test data
- Phase 13: add DataFaker
- Phase 14: ThreadLocal WebDriver for parallel execution
- Phases 15–17: application discovery, page object generation, flow generation
- Phase 19: create `README.md`

## Target application

`https://abajora-dashboard.neop.co/ar/admin/login` — valid credentials: `admin@example.com` / `Neop2020!`

## Conventions

- all phases reference "Read and follow AGENTS.md strictly" — keep this file accurate
- phase 20 references `GEMINI.md` instead; treat as alias for this file
- Java package root: `automation`
- test sources go under `src/test/java`
- config/resources go under `src/test/resources`
- do not skip phases, do not add unlisted dependencies
- page objects go in `src/main/java/automation/pageobjects/`
- flow classes go in `src/main/java/automation/flow/`

## Dependency versions (latest stable)

Use the latest stable versions below. Validate before upgrading via the linked official sources.

| Technology | Version | Release date | Official source |
|---|---|---|---|
| JDK | 25 LTS | 2025-09-16 | [oracle.com](https://www.oracle.com/java/technologies/javase/25all-relnotes.html) |
| Selenium | 4.41.0 | 2026-02-20 | [selenium.dev](https://seleniumhq.github.io/downloads) |
| TestNG | 7.12.0 | 2026-01-22 | [central.sonatype.com](https://central.sonatype.com/artifact/org.testng/testng/7.12.0) |
| Maven Compiler Plugin | 3.15.0 | 2026-02-01 | [maven.apache.org](https://maven.apache.org/plugins/maven-compiler-plugin/dependency-info.html) |
| Maven Surefire | 3.5.5 | 2026-02-18 | [maven.apache.org](https://maven.apache.org/surefire/download.cgi) |
| Owner | 1.0.12 | 2020-06-07 | [github.com/matteobaccan/owner](https://github.com/matteobaccan/owner) |
| AssertJ | 3.27.7 | 2026-01-24 | [central.sonatype.com](https://central.sonatype.com/artifact/org.assertj/assertj-core/3.27.7) |
| SLF4J | 2.0.17 | 2025-02-25 | [slf4j.org](https://slf4j.org/manual.html) |
| Logback | 1.5.32 | 2026-02-16 | [logback.qos.ch](https://logback.qos.ch/setup.html) |
| Allure TestNG | 2.33.0 | 2026-02-20 | [mvnrepository.com](https://mvnrepository.com/artifact/io.qameta.allure/allure-testng) |
| Datafaker | 2.5.4 | 2026-02-11 | [github.com/datafaker-net/datafaker](https://github.com/datafaker-net/datafaker)
