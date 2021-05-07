package com.example.registerapiproject;

public class ApiUtils {

    private ApiUtils() {}


    public static ApiInterface getAPIService() {

        return APIClient.getClient().create(ApiInterface.class);
    }
}