package com.example.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserAPITest {

    @Test
    public void testGetUser() {
        Response res = RestAssured.get("https://jsonplaceholder.typicode.com/users/1");
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertTrue(res.jsonPath().getString("username") != null);
    }
}
