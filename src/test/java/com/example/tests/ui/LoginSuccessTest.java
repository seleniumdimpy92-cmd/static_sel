package com.example.tests.ui;

import com.example.pages.LoginPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSuccessTest extends BaseTest {

    @Test(description = "Login with valid credentials should succeed")
    @Description("Valid login: tomsmith / SuperSecretPassword!")
    public void testLoginSuccess() {
        LoginPage page = new LoginPage();
        page.open();
        page.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(page.isLoginSuccessful(), "Expected login to be successful.");
    }
}
