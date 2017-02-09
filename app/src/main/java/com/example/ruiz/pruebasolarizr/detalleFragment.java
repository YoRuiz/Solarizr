package com.example.ruiz.pruebasolarizr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruiz.pruebasolarizr.Models.Cliente;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link detalleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class detalleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Cliente miCliente;

    private TextView nombre;
    private TextView direccion;
    private TextView telefono;

    public detalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            miCliente = getArguments().getParcelable("clienteSeleccionado");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        nombre = (TextView) getView().findViewById(R.id.detalleNombre);
        nombre.setText(miCliente.getNombre());
        direccion = (TextView) getView().findViewById(R.id.detalleDireccion);
        direccion.setText(miCliente.getDireccion());
        telefono = (TextView) getView().findViewById(R.id.detalleTelefono);
        telefono.setText(miCliente.getTelefono());
    }
}
