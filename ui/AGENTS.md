# AGENTS.md — UI Automation Framework

## Project state

Scaffold Maven project at phase 0 of a 20-phase Selenium+TestNG framework buildout. `pom.xml` is barebones (Java 17 target, zero dependencies). Only source file: `src/main/java/automation/Main.java` (skeleton). No tests, no config, no CI.

**Java version:** `pom.xml` sets 17; phase prompts reference 25. Resolve before adding dependencies — ensure installed JDK matches the target.

## How to build

```powershell
mvn clean test
```

No dependencies declared yet — this command will succeed but skip tests (empty test directory).

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
