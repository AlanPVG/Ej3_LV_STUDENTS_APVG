package com.example.ej3_lv_students;

import android.app.LauncherActivity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//Código para la activity contenedora del listView
public class listViewActivity extends AppCompatActivity {
    ListView lvDatosAlumno;
    private StudentAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final ArrayList<Alumno> arrDatosStudents = (ArrayList<Alumno>) getIntent().getSerializableExtra(MainActivity.arrayAlumnos);
        lvDatosAlumno = findViewById(R.id.datosAlumno);

        adaptador = new StudentAdapter(this,arrDatosStudents);//Creación de nuevo adaptador custom tipo "StudentAdapter"
        lvDatosAlumno.setAdapter(adaptador);//Se configura el listView de acuerdo a la estructura del adaptador creado

        //Cuando se presione un item, se muestra su ID a través de un mensaje Toast
        lvDatosAlumno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(listViewActivity.this,getString(R.string.identificationToast)+String.valueOf(arrDatosStudents.get(i).getID()), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
