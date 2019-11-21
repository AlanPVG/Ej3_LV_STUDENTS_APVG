package com.example.ej3_lv_students;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String arrayAlumnos = "com.example.ej3_lv_students.arrayAlumnos";
    Button btnCheck;
    EditText nombre,apellidos,noCuenta,genero;
    public static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioGroup rbg=(RadioGroup) findViewById(R.id.radioGroup1);
        nombre = findViewById(R.id.Nombre);
        apellidos = findViewById(R.id.apPaterno);
        noCuenta = findViewById(R.id.No_Cuenta);
        btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int selected=rbg.getCheckedRadioButtonId();
                RadioButton gender=(RadioButton) findViewById(selected);
                if(nombre.length()!=0 && apellidos.length()!=0 && noCuenta.length()!=0 && rbg.getCheckedRadioButtonId()!=-1) {
                    listaAlumnos.add(new Alumno(nombre.getText().toString(), apellidos.getText().toString(),gender.getText().toString(), noCuenta.getText().toString()));
                    openListViewActivity();
                    nombre.setText("");
                    apellidos.setText("");
                    noCuenta.setText("");
                    rbg.clearCheck();
                }
                else{
                    Toast.makeText(MainActivity.this, "informacion incompleta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openListViewActivity(){
        ArrayList<Alumno> auxArrayAlumnos = listaAlumnos;
        Intent intent = new Intent(this, listViewActivity.class);
        intent.putExtra(arrayAlumnos,(Serializable) auxArrayAlumnos);
        startActivity(intent);
    }

}
