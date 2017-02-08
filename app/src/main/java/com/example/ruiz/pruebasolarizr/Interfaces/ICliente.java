package com.example.ruiz.pruebasolarizr.Interfaces;

/**
 * Created by Ruiz on 04/02/2017.
 */
import com.example.ruiz.pruebasolarizr.Models.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ICliente {
    @GET("Admin/{id}/Cliente")
    Call<List<Cliente>> getClientes(@Path("id") String id, @Header("Authorization")String base64);
}
