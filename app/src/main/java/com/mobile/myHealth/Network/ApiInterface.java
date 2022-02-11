package com.mobile.myHealth.Network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApiInterface {

@FormUrlEncoded
@POST("mobile/mha/patientOperations.php")
Call<MessageResponse> sendOTP(@Field("phone") String phone,
                              @Field("username") String username,
                              @Field("api_call") String api_call,
                              @Field("token") String token);

@FormUrlEncoded
@POST("mobile/mha/patientOperations.php")
Call<MessageResponse> verifyOTP(@Field("phone") String phone,
                                @Field("username") String username,
                                @Field("api_call") String api_call,
                                @Field("otp") String otp,
                                @Field("id") String id,
                                @Field("token") String token);


@FormUrlEncoded
@POST("mobile/mha/patientOperations.php")
Call<MessageResponse> register(@Field("first_name") String first_name,
                               @Field("last_name") String last_name,
                               @Field("phone") String phone,
                               @Field("email") String email,
                               @Field("api_call") String api_call,
                               @Field("password") String password);


@FormUrlEncoded
@POST("mobile/mha/patientOperations.php")
Call<MessageResponse> email_login(@Field("email") String email,
                               @Field("api_call") String api_call,
                               @Field("password") String password);

@FormUrlEncoded
@POST("mobile/mha/patientOperations.php")
Call<MessageResponse> reset_password(@Field("token") String token,
                               @Field("id") String id,
                               @Field("email") String email,
                               @Field("api_call") String api_call,
                               @Field("password") String password);
}

