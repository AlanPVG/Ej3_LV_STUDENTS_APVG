package com.example.ej3_lv_students;

import java.io.Serializable;

//Clase Alumno

public class Alumno implements Serializable {

    //Atributos
    String nombre, apellidos;
    String   genero;
    String noCuenta;//Numero de cuenta
    int genderIcon;
    int ID;
    static public int counter=1;


    //Constructor

    Alumno(int genderIcon, String nombre, String apellidos,String genero, String noCuenta){
        this.genderIcon = genderIcon;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.noCuenta = noCuenta;
        this.ID = counter++;//Se incrementa el contador cada que se crea un nuevo registro de alumno

    }


    public int getGenderIcon(){return genderIcon;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }



    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public int getID(){
        return  ID;
    }
}
