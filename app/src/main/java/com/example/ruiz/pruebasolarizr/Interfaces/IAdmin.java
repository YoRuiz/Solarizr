package com.example.ruiz.pruebasolarizr.Interfaces;

/**
 * Created by Ruiz on 04/02/2017.
 */
import com.example.ruiz.pruebasolarizr.Models.Admin;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Header;

public interface IAdmin {
    @GET("Admin")
    Call<List<Admin>> getAdmins(@Header("Authorization") String base64);
}
