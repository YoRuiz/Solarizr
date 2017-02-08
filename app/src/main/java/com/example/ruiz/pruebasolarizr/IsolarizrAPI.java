package com.example.ruiz.pruebasolarizr;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by jajimenez on 2/02/17.
 */

public interface IsolarizrAPI {
    @GET("Admin")
    Call<List<Admin>> getAdmin(@Header("Authorization")String value);
}
