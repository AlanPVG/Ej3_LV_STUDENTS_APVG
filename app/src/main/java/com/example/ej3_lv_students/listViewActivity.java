package com.example.ej3_lv_students;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listViewActivity extends AppCompatActivity {
    ListView lvDatosAlumno;
    private StudentAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Intent intent = getIntent();
        ArrayList<Alumno> arrDatosStudents = (ArrayList<Alumno>) getIntent().getSerializableExtra(MainActivity.arrayAlumnos);
        lvDatosAlumno = findViewById(R.id.datosAlumno);

        adaptador = new StudentAdapter(this,arrDatosStudents);
       // ArrayAdapter<Alumno> adaptador = new ArrayAdapter<>(listViewActivity.this, android.R.layout.simple_list_item_1,arrDatosStudents);
        lvDatosAlumno.setAdapter(adaptador);

    }
}
