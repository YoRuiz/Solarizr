package com.example.ruiz.pruebasolarizr;

/**
 * Created by Ruiz on 25/01/2017.
 */

public class Admin {
    private int id;
    private String nombre;
    private String pass;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Admin(int id,String nombre, String pass) {
        this.id=id;
        this.nombre = nombre;
        this.pass = pass;
    }
}
