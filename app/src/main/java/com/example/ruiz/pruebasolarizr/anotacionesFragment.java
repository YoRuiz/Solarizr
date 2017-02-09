package com.example.ruiz.pruebasolarizr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ruiz.pruebasolarizr.Callbacks.AnotacionCallback;
import com.example.ruiz.pruebasolarizr.Interfaces.IAnotaciones;
import com.example.ruiz.pruebasolarizr.Models.Anotacion;
import com.example.ruiz.pruebasolarizr.Models.Cliente;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class anotacionesFragment extends ListFragment {

    private String credenciales;
    private Cliente cliente;
    String SERVER_URL = "http://jajimenez.ciclo.iesnervion.es/solarizr_api/";
    private ArrayList<Anotacion> listaAnotaciones=new ArrayList();
    private ListView listaAndroid;
    private TextView textoError;
    View v;


    public anotacionesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cliente = getArguments().getParcelable("clienteSeleccionado");
            credenciales = getArguments().getString("credenciales");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_anotaciones, container, false);
        getAnotacionesRest();
        textoError = (TextView) v.findViewById(R.id.errorAnotaciones);
        //setListAdapter(new miArrayAdapterAnotaciones(v.getContext(), R.layout.fila_fragment_anotaciones, R.id.filaFragmentCabecera, listaAnotaciones));
        return v;
    }

    public void getAnotacionesRest() {
        Retrofit retrofit;
        AnotacionCallback anotacionCallback = new AnotacionCallback(this);
        retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IAnotaciones adminInter = retrofit.create(IAnotaciones.class);
        adminInter.getAnotaciones(String.valueOf(cliente.getId()), credenciales).enqueue(anotacionCallback);
    }
    public void esperaAnotacionesRest(AnotacionCallback anotacionCallback){
        this.listaAnotaciones = (ArrayList<Anotacion>) anotacionCallback.getListaAnotaciones();
        if(this.listaAnotaciones!=null){
            setListAdapter(new miArrayAdapterAnotaciones(v.getContext(), R.layout.fila_fragment_anotaciones, R.id.filaFragmentCabecera, listaAnotaciones));
        }else{
            textoError.setText("Este usuario no tiene anotaciones.");
        }
        //listaAndroid.setOnItemClickListener();
    }
}
