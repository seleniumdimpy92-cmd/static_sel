# DESIGN.md

## Architecture
- **DriverFactory** (thread-safe) supplies WebDriver instances per test thread.
- **Page Objects** encapsulate locators and operations (LoginPage).
- **Utils**: ConfigReader, WaitUtils for shared utilities.
- **Tests**: separated into UI and API packages; TestNG manages execution and data-driven tests.
- **Reporting**: Allure collects test results, attachments and steps.


## How framework handles flaky tests & sensitive data
- Flaky tests: use retry analyzer (not included by default), explicit waits, and test tagging for smoke/regression.
- Sensitive data: keep credentials and secrets out of repo; use CI secrets and environment variables. In local runs, pass sensitive data via system properties or a secure vault.

## Tech choices
- Selenium + WebDriverManager: widely used, stable.
- TestNG: flexible data providers and groupings.
- Rest-Assured: simple API test DSL.
- Allure: rich HTML reporting that's CI-friendly.

 ## DESIGN DOCUMENT OF POM FRAMEWORK

### FOLDER STRUCTURE OF POM FRAMEWORK: -

project-root/
├─ pom.xml
├─ README.md
├─ src/
│  ├─ main/
│  │  └─ java/com/example/framework/
│  │     ├─ config/         # config classes
│  │     ├─ utils/          # helpers (CSV reader, HTTP utils, logger)
│  │     └─ reporting/      # Extent manager/listener
│  └─ test/
│     └─ java/com/example/tests/
│        ├─ ui/
│        │  ├─ pages/
│        │  ├─ tests/
│        │  └─ base/
│        └─ api/
│           ├─ tests/
│           └─ base/
├─ resources/
│  ├─ testdata/
│  │  └─ login-data.csv
│  └─ config.properties
└─ reports/

TECH CHOICE: -


A. Java stack (preferred given candidate background)
● Selenium WebDriver + TestNG (or JUnit)
● Maven for build
● Rest Assured for API tests
● Allure/Extent for reports
● Git (push to GitHub/GitLab)





