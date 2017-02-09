package com.example.ruiz.pruebasolarizr;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ruiz.pruebasolarizr.Models.Cliente;

import java.util.ArrayList;

public class listaclientes extends ListActivity implements ListView.OnItemClickListener {
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ListView listaAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaclientes);
//        if(savedInstanceState!=null) {
            this.listaAndroid = (ListView) findViewById(android.R.id.list);
            listaClientes = this.getIntent().getParcelableArrayListExtra("listaCliente");
//        }else{
//            listaClientes = null;
//        }
        setListAdapter(new miArrayAdapter(this, R.layout.fila_cliente, R.id.nombreFila, listaClientes));
        listaAndroid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intentCliente = new Intent(this, detalleCliente.class);
        intentCliente.putExtra("credenciales", this.getIntent().getStringExtra("credenciales"));
        intentCliente.putExtra("clienteSeleccionado", listaClientes.get(position));
        startActivity(intentCliente);
    }
}
