package com.charleychen.testscripts;

import com.charleychen.pojoclass.GetUserList;
import com.charleychen.pojoclass.SimpleUser;
import com.charleychen.utils.EndpointURL;
import com.charleychen.utils.URL;
import com.charleychen.webservices.methods.Webservices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TC_001 {

    Response response;

    @BeforeClass
    public void setUp() {
//        ArrayList<String> user = new ArrayList<>();
//        user.add("");
    }

    @Test
    public void verifyGetMethod() {
        Gson gson = new GsonBuilder().create();
        GetUserList getUserList;
        String url = URL.reqres + EndpointURL.LIST_USERS.getResourcePath();
        response = Webservices.Get(url);
        System.out.println(url);
        System.out.println(response.getBody().asString());
        if (response.getStatusCode() == 200) {
            getUserList = gson.fromJson(response.body().asString(), GetUserList.class);
            System.out.println(getUserList + "\n----------------------");
            System.out.println(getUserList.getAdditionalProperties());
            System.out.println(getUserList.getData());
            System.out.println(getUserList.getPage());
            System.out.println(getUserList.getPerPage());
            System.out.println(getUserList.getTotal());
            System.out.println(getUserList.getTotalPages());
        }
    }

    @Test
    public void verifyGetCountryById() {
        String url = URL.reqres + EndpointURL.SINGLE_USER.getResourcePath("2");
        response = Webservices.Get(url);
        System.out.println(url);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void verifySimpleUser() {
        Gson gson = new GsonBuilder().create();
        SimpleUser simpleUser;
        String url = URL.reqres + EndpointURL.SINGLE_USER.getResourcePath("2");
        response = Webservices.Get(url);
        if (response.statusCode() == 200) {
            simpleUser = gson.fromJson(response.getBody().asString(), SimpleUser.class);
            System.out.println(simpleUser.getData().getAvatar());
            System.out.println(simpleUser.getData().getId());
            Assert.assertEquals(Integer.valueOf(2), simpleUser.getData().getId());
        }
    }

    @DataProvider(name = "data")
    public  Object[][] getUserById(){
        Object[][] result = new Object[1][2];
        for (int i = 0; i < result.length; i++){
            result[i][0] = "0";
            result[i][1] = "0";
            result[i][2] = "0";
        }
        return result;
    }
}
