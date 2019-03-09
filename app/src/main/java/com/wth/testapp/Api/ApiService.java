package com.wth.testapp.Api;

import com.wth.testapp.Model.Person;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;


public interface ApiService {
    @POST("api/v1/auth/signin")
    Call<ResponseBody> LoginService(@Body RequestBody requestBody);


    @GET("api/v1/data")
    Call<Person> PERSON_CALL(@HeaderMap Map<String, String> header);

    @GET("api/v1/auth/signin")
    Call<Person> PERSON_CALL2(@Body RequestBody requestBody);


}
