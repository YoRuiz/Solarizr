package com.example.ruiz.pruebasolarizr.Models;

/**
 * Created by Ruiz on 01/02/2017.
 */
import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class Cliente implements Parcelable{


        private int id;
        private String nombre;
        private String fechaNac;
        private String direccion;
        private String telefono;
        private Double latitud;
        private Double longitud;
        private Integer estado;
        private Integer idAdmin;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getFechaNac() {
            return fechaNac;
        }

        public void setFechaNac(String fechaNac) {
            this.fechaNac = fechaNac;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public Double getLatitud() {
            return latitud;
        }

        public void setLatitud(Double latitud) {
            this.latitud = latitud;
        }

        public Double getLongitud() {
            return longitud;
        }

        public void setLongitud(Double longitud) {
            this.longitud = longitud;
        }

        public Integer getEstado() {
            return estado;
        }

        public void setEstado(Integer estado) {
            this.estado = estado;
        }

        public Integer getIdAdmin() {
            return idAdmin;
        }

        public void setIdAdmin(Integer idAdmin) {
            this.idAdmin = idAdmin;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", estado=" + estado +
                ", idAdmin=" + idAdmin +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeValue(this.id);
        dest.writeString(this.nombre);
        dest.writeString(this.fechaNac);
        dest.writeString(this.direccion);
        dest.writeString(this.telefono);
        dest.writeValue(this.latitud);
        dest.writeValue(this.longitud);
        dest.writeValue(this.estado);
        dest.writeValue(this.idAdmin);

    }

    protected Cliente(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.nombre = in.readString();
        this.fechaNac = in.readString();
        this.direccion = in.readString();
        this.telefono = in.readString();
        this.latitud = (double) in.readValue(Double.class.getClassLoader());
        this.longitud = (double) in.readValue(Double.class.getClassLoader());
        this.estado =  (Integer) in.readValue(Integer.class.getClassLoader());
        this.idAdmin =  (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel source) {
            return new Cliente(source);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };
}

