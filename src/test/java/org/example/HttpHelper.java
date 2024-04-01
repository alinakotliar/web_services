package org.example;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class HttpHelper {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static ValidatableResponse getUsersResponse() {
        return RestAssured.get(BASE_URL + "/users").then();
    }
}
