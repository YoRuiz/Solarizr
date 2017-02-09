package com.example.ruiz.pruebasolarizr.Callbacks;

import com.example.ruiz.pruebasolarizr.MainActivity;
import com.example.ruiz.pruebasolarizr.Models.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ruiz on 04/02/2017.
 */

public class ClienteCallback implements Callback<List<Cliente>> {
    public List<Cliente> getL() {
        return l;
    }

    public void setL(List<Cliente> l) {
        this.l = l;
    }

    public ClienteCallback(MainActivity main) {
        this.main = main;
    }

    public MainActivity getMain() {

        return main;
    }

    public void setMain(MainActivity main) {
        this.main = main;
    }

    private MainActivity main;
    private List<Cliente> l;
    @Override
    public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {

            setL(response.body());
            this.main.esperaClienteRest(this);


    }

    @Override
    public void onFailure(Call<List<Cliente>> call, Throwable t) {
        this.main.errorServidor();
    }
}
