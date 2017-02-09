package com.example.ruiz.pruebasolarizr.Callbacks;

import com.example.ruiz.pruebasolarizr.MainActivity;
import com.example.ruiz.pruebasolarizr.Models.Anotacion;
import com.example.ruiz.pruebasolarizr.anotacionesFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ruiz on 09/02/2017.
 */

public class AnotacionCallback implements Callback<List<Anotacion>> {
    private anotacionesFragment main;
    private List<Anotacion> listaAnotaciones;

    public AnotacionCallback(anotacionesFragment main) {
        this.main = main;
    }

    public anotacionesFragment getMain() {

        return main;
    }

    public void setMain(anotacionesFragment main) {
        this.main = main;
    }

    public List<Anotacion> getListaAnotaciones() {
        return listaAnotaciones;
    }

    public void setListaAnotaciones(List<Anotacion> listaAnotaciones) {
        this.listaAnotaciones = listaAnotaciones;
    }

    @Override
    public void onResponse(Call<List<Anotacion>> call, Response<List<Anotacion>> response) {
        this.setListaAnotaciones(response.body());
        main.esperaAnotacionesRest(this);
    }

    @Override
    public void onFailure(Call<List<Anotacion>> call, Throwable t) {
int i=0;
        i++;
    }
}
