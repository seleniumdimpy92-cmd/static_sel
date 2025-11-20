package com.example.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (driver.get() == null) {

            String browser = System.getProperty("browser", "chrome");

            switch (browser.toLowerCase()) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();

                    // Common options
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");

                    // Detect if running in GitHub Actions
                    if (System.getenv("GITHUB_ACTIONS") != null) {
                        chromeOptions.addArguments("--headless=new");
                        chromeOptions.addArguments("--window-size=1920,1080");
                        chromeOptions.addArguments("--disable-gpu");
                    }

                    driver.set(new ChromeDriver(chromeOptions));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();

                    // GitHub Actions needs headless for Firefox too
                    if (System.getenv("GITHUB_ACTIONS") != null) {
                        firefoxOptions.addArguments("-headless");
                    }

                    driver.set(new FirefoxDriver(firefoxOptions));
                    break;

                default:
                    throw new RuntimeException("Browser not supported: " + browser);
            }
        }

        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
