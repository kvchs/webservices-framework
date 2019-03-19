package com.charleychen.webservices.methods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class Webservices {

    public static String authToken;

    public static Response Post(String uRI, String stringJSON) {
        RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
//        RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.post(uRI);
        return response;
    }

    public static Response Get(String uRI) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.get(uRI);
        return response;
    }

    public static Response Put(String uRI, String stringJSON) {
        RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.put(uRI);
        return response;
    }

    public static Response Delete(String uRI) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.delete(uRI);
        return response;
    }

    public static Response PostCallWithHeader(String uRI, String stringJson) {
        RequestSpecification requestSpecification = RestAssured.given().body(stringJson);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", authToken);
        Response response = requestSpecification.post(uRI);
        return response;
    }

    public static Response PutCallWithHeader(String uRI, String stringJSON) {
        RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", authToken);
        requestSpecification.header("companyid", 101);
        Response response = requestSpecification.put(uRI);
        return response;
    }

    public static void loginToApplication(String uRI, String username, String password){
        RequestSpecification requestSpecification = RestAssured.given().auth().form(username, password);
        Response response = requestSpecification.get(uRI);
        JSONObject jsonObject = new JSONObject(response);
        String auth = jsonObject.getString("authToken");
        authToken = auth;
    }
}
