package com.example.tests.ui;

import com.example.pages.LoginPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFailureTest extends BaseTest {

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][] {
            { "wronguser", "wrongpass" },
            { "tomsmith", "badpassword" }
        };
    }

    @Test(dataProvider = "invalidCredentials", description = "Login with invalid credentials should fail")
    @Description("Invalid login combinations")
    public void testLoginFailure(String user, String pass) {
        LoginPage page = new LoginPage();
        page.open();
        page.login(user, pass);
        Assert.assertTrue(page.isLoginFailed(), "Expected login to fail for: " + user);
    }
}
