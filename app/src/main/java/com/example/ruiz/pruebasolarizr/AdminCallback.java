package com.example.ruiz.pruebasolarizr;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.ruiz.pruebasolarizr.Interfaces.IAdmin;
import com.example.ruiz.pruebasolarizr.Models.Admin;

import java.io.Console;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ruiz on 01/02/2017.
 */

public class AdminCallback implements Callback<List<Admin>> {
    private int id;

    public List<Admin> getA() {
        return a;
    }

    public void setA(List<Admin> a) {
        this.a = a;
    }

    public MainActivity getMain() {
        return main;
    }

    public void setMain(MainActivity main) {
        this.main = main;
    }

    private MainActivity main;
    private List<Admin> a;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdminCallback(MainActivity main){
        this.main = main;
    }
    @Override
    public void onResponse(Call<List<Admin>> call, Response<List<Admin>> response) {
        int codigo = Integer.parseInt(Integer.toString(response.code()).substring(0, 1));
        if(codigo==4 || codigo==5){
            this.main.errorServidor();
        }else {
            this.a = response.body();
            this.id = Integer.parseInt(response.headers().get("idAdmin"));
            this.main.esperaAdminRest(this);
        }

    }

    @Override
    public void onFailure(Call<List<Admin>> call, Throwable t) {
        this.main.errorServidor();
    }
}
