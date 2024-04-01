package org.example;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import static org.hamcrest.Matchers.equalTo;
public class HttpTests {

    @Test
    public void verifyStatusCode() {
        HttpHelper.getUsersResponse().assertThat().statusCode(200);
    }

    @Test
    public void verifyResponseHeader() {

        HttpHelper.getUsersResponse()
                .assertThat()
                .header("content-type", equalTo("application/json; charset=utf-8"));

    }

    @Test
    public void verifyResponseBody() {
            List<User> users = HttpHelper.getUsersResponse().extract().jsonPath().getList(".", User.class);
            Assert.assertEquals(users.size(), 10, "Number of users in the response body is not 10");
        }
    }

