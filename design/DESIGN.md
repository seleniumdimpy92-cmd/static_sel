# DESIGN.md

## Architecture
- **DriverFactory** (thread-safe) supplies WebDriver instances per test thread.
- **Page Objects** encapsulate locators and operations (LoginPage).
- **Utils**: ConfigReader, WaitUtils for shared utilities.
- **Tests**: separated into UI and API packages; TestNG manages execution and data-driven tests.
- **Reporting**: Allure collects test results, attachments and steps.

## Folder structure
See top-level README. The structure is designed to scale: add more pages under `pages/`, services under `api/` and helpers in `utils/`.

## How framework handles flaky tests & sensitive data
- Flaky tests: use retry analyzer (not included by default), explicit waits, and test tagging for smoke/regression.
- Sensitive data: keep credentials and secrets out of repo; use CI secrets and environment variables. In local runs, pass sensitive data via system properties or a secure vault.

## Tech choices
- Selenium + WebDriverManager: widely used, stable.
- TestNG: flexible data providers and groupings.
- Rest-Assured: simple API test DSL.
- Allure: rich HTML reporting that's CI-friendly.
