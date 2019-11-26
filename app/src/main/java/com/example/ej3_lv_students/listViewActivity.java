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

public class listViewActivity extends AppCompatActivity {
    ListView lvDatosAlumno;
    private StudentAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final ArrayList<Alumno> arrDatosStudents = (ArrayList<Alumno>) getIntent().getSerializableExtra(MainActivity.arrayAlumnos);
        lvDatosAlumno = findViewById(R.id.datosAlumno);

        adaptador = new StudentAdapter(this,arrDatosStudents);
        lvDatosAlumno.setAdapter(adaptador);

        lvDatosAlumno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(listViewActivity.this,"ID:"+String.valueOf(arrDatosStudents.get(i).getID()), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
