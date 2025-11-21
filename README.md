# Selenium Java Automation Framework (Starter)

This repository is a starter automation framework built with:
- Java 17
- Selenium WebDriver
- TestNG
- Rest-Assured (API tests)
- Allure (reporting)
- WebDriverManager (driver management)


## How to run locally (Linux / macOS / WSL)
- Install Java 17 and Maven
- Checkout this repo or unzip package
- Run UI + API tests: `mvn clean test`
- To change browser: `mvn -Dbrowser=firefox test` (default: chrome)
- Allure results are generated under `target/allure-results` and can be served with the Allure CLI.

## CI
A GitHub Actions workflow is included in `.github/workflows/ci.yml` to run tests and upload results as an artifact.

## Files of interest
- `src/main/java/com/example/core/DriverFactory.java` — driver handling
- `src/main/java/com/example/pages/LoginPage.java` — page object for demo site
- `src/test/java/com/example/tests/*` — tests
- `design/DESIGN.md` — architecture & rationale
- `RETROSPECTIVE.md` — trade-offs and next steps

