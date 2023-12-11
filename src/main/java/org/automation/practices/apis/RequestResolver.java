package org.automation.practices.apis;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestResolver {


    public RequestSpecification resolve(String baseURL)
    {
        RestAssured.baseURI = baseURL;
        RequestSpecification requestSpecification = null;

        return requestSpecification.given();
    }
}
