# AGENTS.md — UI Automation Framework

## Project state

Phase 3 (Owner Configuration) complete. Phase 4 (Browser Management) complete. Phase 5 (Wait Strategy) complete. Phase 6 (TestNG XML) complete. Phase 7 (Test Grouping) complete. Phase 9 (Logging) complete. Selenium + TestNG + Maven Surefire + Owner are configured in `pom.xml`. URL is read from `config.properties` via `ConfigManager`/`FrameworkConfig`. Browser is managed by `DriverFactory`/`DriverManager` (ThreadLocal) reading `browser` from `config.properties`. Chrome and Edge are supported. Waits are centralized in `WaitUtil` and used by `BasePage`. Tests run through `src/test/resources/testng.xml`. Tests are grouped into smoke, sanity, and regression with Maven profiles. Logging is set up with SLF4J + Logback + Lombok @Slf4j; logback.xml controls output format (console + rolling file appender to target/logs/automation.log).

## Run commands

```powershell
mvn clean test                          # default suite (testng.xml)
mvn clean test -P smoke                 # smoke group only
mvn clean test -P sanity                # sanity group only
mvn clean test -P regression            # regression group only
```

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
