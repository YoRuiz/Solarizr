package com.example.ruiz.pruebasolarizr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ruiz.pruebasolarizr.Models.Anotacion;
import com.example.ruiz.pruebasolarizr.Models.Cliente;

import java.util.ArrayList;

/**
 * Created by Ruiz on 06/12/2016.
 */

public class miArrayAdapterAnotaciones extends ArrayAdapter<Anotacion>{
    public miArrayAdapterAnotaciones(Context context, int fila, int texto, ArrayList<Anotacion> objetos) {
        super(context, fila, texto, objetos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        //Ejemplo de arrayAdapter propio con reciclado
        ViewHolderAnotacion holder;
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (row==null) {

            row = inflater.inflate(R.layout.fila_fragment_anotaciones, parent, false);
            TextView cabecera = (TextView) row.findViewById(R.id.filaFragmentCabecera);
            TextView cuerpo = (TextView) row.findViewById(R.id.filaFragmentCuerpo);


            holder = new ViewHolderAnotacion(cabecera,cuerpo);
            row.setTag(holder);
        }else{
            holder = (ViewHolderAnotacion) row.getTag();
        }

        Anotacion c = (Anotacion) getItem(position);
        TextView cabecera= (TextView) holder.getCabecera();
        cabecera.setText(c.getCabecera());
        TextView cuerpo= (TextView) holder.getCuerpo();
        cuerpo.setText(c.getCuerpo());

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

class ViewHolderAnotacion{
    private TextView cabecera;
    private TextView cuerpo;

    public ViewHolderAnotacion(TextView cabecera,TextView cuerpo){
        this.cabecera=cabecera;
        this.cuerpo=cuerpo;
    }
    public TextView getCabecera() {
        return cabecera;
    }
    public TextView getCuerpo() {
        return cuerpo;
    }
}

