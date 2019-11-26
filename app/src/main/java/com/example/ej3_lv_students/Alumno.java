package com.example.ej3_lv_students;

import java.io.Serializable;

public class Alumno implements Serializable {

    String nombre, apellidos;
    String   genero;
    String noCuenta;
    int genderIcon;
    int ID;
    static public int counter=1;


    //Constructor

    Alumno(int genderIcon, String nombre_alumno, String apellidosAlumno,String generoAlumno, String noCuentaAlumno){
        this.genderIcon = genderIcon;
        nombre = nombre_alumno;
        apellidos = apellidosAlumno;
        genero = generoAlumno;
        noCuenta = noCuentaAlumno;
        this.ID = counter++;

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
