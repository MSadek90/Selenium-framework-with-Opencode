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

## Version policy

When adding or updating any dependency or plugin, always search for the latest stable version from its official source (Maven Central, official website, or GitHub releases). Do not hardcode versions — resolve them fresh each time.
