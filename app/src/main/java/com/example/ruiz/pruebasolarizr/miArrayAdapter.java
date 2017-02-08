package com.example.ruiz.pruebasolarizr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ruiz.pruebasolarizr.Models.Cliente;

import java.util.ArrayList;

/**
 * Created by Ruiz on 06/12/2016.
 */

public class miArrayAdapter extends ArrayAdapter<Cliente>{
    public miArrayAdapter(Context context, int fila, int texto, ArrayList<Cliente> objetos) {
        super(context, fila, texto, objetos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        //Ejemplo de arrayAdapter propio con reciclado
        ViewHolder holder;
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (row==null) {

                row = inflater.inflate(R.layout.fila_cliente, parent, false);
                TextView id = (TextView) row.findViewById(R.id.filaId);
            TextView nombre = (TextView) row.findViewById(R.id.nombreFila);
            TextView direccion = (TextView) row.findViewById(R.id.direccionFila);

            holder = new ViewHolder(id,nombre,direccion);
                row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }

            Cliente c = (Cliente) getItem(position);
            TextView id= (TextView) holder.getId();
            id.setText(""+c.getId());
            TextView nombre= (TextView) holder.getNombre();
            nombre.setText(c.getNombre());
            TextView direccion= (TextView) holder.getDireccion();
            direccion.setText(c.getDireccion());

        return row;
    }
    @Override
    public int getItemViewType(int position){
        return 0;
    }
    public int getViewTypeCount(){
        return 2;
    }

}

class ViewHolder{
    private TextView id;
    private TextView nombre;
    private TextView direccion;

    public ViewHolder(TextView id,TextView nombre, TextView direccion){
        this.id=id;
        this.nombre=nombre;
        this.direccion=direccion;

    }

    public TextView getId() {
        return id;
    }
    public TextView getNombre() {
        return nombre;
    }
    public TextView getDireccion() {
        return direccion;
    }
}
