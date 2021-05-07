package com.example.registerapiproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

//    @POST("/api/Auth/login")
//    Call<LoginResponse> loginApi(
//          @Body LoginRequest loginRequest
//    );

    @FormUrlEncoded
  @POST("getToken")
    Call<LoginResponse> token(
         @Field("Username") String username,
         @Field("Password") String password,
         @Field("grant_type") String grant_type
    );


}
