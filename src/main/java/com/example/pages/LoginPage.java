package com.example.pages;

import com.example.core.DriverFactory;
import com.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver = DriverFactory.getDriver();
    private WaitUtils wait = new WaitUtils(driver, 10);

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button.radius");
    private By flash = By.id("flash");

    public void open() {
        String base = System.getProperty("baseUrl", "https://the-internet.herokuapp.com");
        driver.get(base + "/login");
    }

    public void login(String user, String pass) {
        wait.visibilityOf(username);
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginSuccessful() {
        wait.visibilityOf(flash);
        return driver.findElement(flash).getText().toLowerCase().contains("you logged into");
    }

    public boolean isLoginFailed() {
        wait.visibilityOf(flash);
        return driver.findElement(flash).getText().toLowerCase().contains("your username is invalid")
                || driver.findElement(flash).getText().toLowerCase().contains("your password is invalid");
    }
}
