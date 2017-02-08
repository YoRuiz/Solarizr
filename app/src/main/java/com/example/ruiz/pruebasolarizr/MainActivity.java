package com.example.ruiz.pruebasolarizr;

import android.content.Intent;
import android.os.Parcelable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruiz.pruebasolarizr.Interfaces.IAdmin;
import com.example.ruiz.pruebasolarizr.Interfaces.ICliente;
import com.example.ruiz.pruebasolarizr.Models.Admin;
import com.example.ruiz.pruebasolarizr.Models.Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button botonLogin;
    Admin inputAdmin;
    EditText textoNombre;
    EditText textoPassword;
    TextView textoError;
    String SERVER_URL = "http://jajimenez.ciclo.iesnervion.es/solarizr_api/";

    int idAdmin;
    List<Cliente> listaClientes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonLogin = (Button) findViewById(R.id.botonLogin);
        botonLogin.setOnClickListener(this);

        textoNombre = (EditText) findViewById(R.id.textoNombreLogin);
        textoPassword = (EditText) findViewById(R.id.textoPasswordLogin);
        textoError = (TextView) findViewById(R.id.textoError);
    }

    @Override
    public void onClick(View v) {
            getAdminRest();
    }

    public String codifica64() {
        //inputAdmin = new Admin(0,textoNombre.getText().toString(), textoPassword.getText().toString());
        String credentials = textoNombre.getText().toString() + ":" + textoPassword.getText().toString();
        String auth = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        return auth;
    }

    public void getAdminRest(){
        Retrofit retrofit;

        AdminCallback adminCallback = new AdminCallback(this);

        retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IAdmin adminInter = retrofit.create(IAdmin.class);
        String base64 = codifica64();
        adminInter.getAdmins(base64).enqueue(adminCallback);
    }

    public void getClienteRest(){
        Retrofit retrofit;
        ClienteCallback clienteCallback = new ClienteCallback(this);

        retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ICliente clienteInter = retrofit.create(ICliente.class);
        String base64 = codifica64();
        clienteInter.getClientes(String.valueOf(idAdmin), base64).enqueue(clienteCallback);

    }

    public void esperaAdminRest(AdminCallback adminCallback){
        this.idAdmin = adminCallback.getId();
        getClienteRest();
    }
    public void esperaClienteRest(ClienteCallback clienteCallback){
        this.listaClientes = clienteCallback.getL();
        abreListaClientes();
    }
    public void errorServidor(){
        this.textoError.setText("Error del servidor");
    }

    public void abreListaClientes(){
        if(idAdmin!=0 && listaClientes==null) {
            textoError.setText("No tiene clientes asignados.");
        }else {
            if (listaClientes == null) {

                textoError.setText("Usuario o contraseña incorrectos.");
            }else{
                Intent i = new Intent(this, listaclientes.class);
                i.putParcelableArrayListExtra("listaCliente", (ArrayList<? extends Parcelable>) listaClientes);
                startActivity(i);
            }
        }
    }
}
