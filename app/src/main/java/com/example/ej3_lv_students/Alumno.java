package com.example.ej3_lv_students;

import java.io.Serializable;

public class Alumno implements Serializable {

    String nombre, apellidos;
    String   genero;
    String noCuenta;


    //Constructor

    Alumno(String nombre_alumno, String apellidosAlumno, String generoAlumno, String noCuentaAlumno){
        nombre = nombre_alumno;
        apellidos = apellidosAlumno;
        genero = generoAlumno;
        noCuenta = noCuentaAlumno;

    }

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
}
