package com.charleychen.utils;

import org.testng.annotations.Test;

public enum  EndpointURL {

    ADD_COUNTRY("/countries/details"),
    UPDATE_COUNTRY("/countries/update/details"),
    GET_COUNTRY_BY_ID("/country/"),
    DELETE_COUNTRY("/country/"),
    GET_COUNTRIES("/countries"),
    ROOT("/"),
    LIST_USERS("/api/users?page=2"),
    CREATE("/api/users"),
    UPDATE("/api/users/2"),
    DELATE("/api/users/2"),
    SINGLE_USER("/api/users/");




    String resourcePath;
    EndpointURL(String resourcePath){
        this.resourcePath = resourcePath;
    }

    public String getResourcePath(){
        return this.resourcePath;
    }

    public String getResourcePath(String data){
        return this.resourcePath + data;
    }

    public static void main(String[] args) {
        System.out.println(EndpointURL.ADD_COUNTRY.getResourcePath());
        System.out.println(URL.fixURL + EndpointURL.ADD_COUNTRY.getResourcePath());
        String rootURL = URL.fixURL + EndpointURL.ROOT.getResourcePath();
        System.out.println(rootURL);
    }



}
