package com.example.tests.api;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeAPITest {

    @Test
    public void testInvalidUser() {
        int status = RestAssured.get("https://jsonplaceholder.typicode.com/users/99999").getStatusCode();
        Assert.assertEquals(status, 404);
    }
}
