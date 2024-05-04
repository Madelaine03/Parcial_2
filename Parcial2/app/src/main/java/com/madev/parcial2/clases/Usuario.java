package com.madev.parcial2.clases;

//import android.os.Parcel;
//import android.os.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Usuario implements Parcelable {
    private String nombre;
    private String imagen;
    private String especie;
    private String estado;


    public Usuario(String nombre, String imagen, String especie, String estado) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.especie = especie;
        this.estado = estado;
    }

    protected Usuario(Parcel in) {
        nombre = in.readString();
        imagen = in.readString();
        especie = in.readString();
        estado = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(imagen);
        dest.writeString(nombre);
        dest.writeString(estado);
        dest.writeString(especie);
    }
}
