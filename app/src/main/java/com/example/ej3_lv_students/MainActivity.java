package com.example.ej3_lv_students;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String arrayAlumnos = "com.example.ej3_lv_students.arrayAlumnos";
    Button btnCheck;
    EditText nombre,apellidos,noCuenta,genero;
    String nombreString;
    public static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.Nombre);
        apellidos = findViewById(R.id.apPaterno);
        noCuenta = findViewById(R.id.No_Cuenta);
        genero = findViewById(R.id.Genero);
        btnCheck = findViewById(R.id.btnCheck);
        nombreString = nombre.getText().toString();
        btnCheck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listaAlumnos.add( new Alumno(nombre.getText().toString(),apellidos.getText().toString(),genero.getText().toString(),noCuenta.getText().toString()));
                openListViewActivity();
                nombre.setText("");
                apellidos.setText("");
                noCuenta.setText("");
                genero.setText("");
            }
        });
    }

    public void openListViewActivity(){
        ArrayList<Alumno> auxArrayAlumnos = listaAlumnos;
        Intent intent = new Intent(this, listViewActivity.class);
        intent.putExtra(arrayAlumnos,(Serializable) auxArrayAlumnos);
        startActivity(intent);
    }

    public String toStringCopy()
    {
        return getClass().getName()+"@"+Integer.toHexString(hashCode());
    }
}
