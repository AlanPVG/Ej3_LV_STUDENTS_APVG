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
    Button bttnSubmit,bttnCheck,bttnClear;
    EditText nombre,apellidos,noCuenta,genero;
    String genderString = null;

    public static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioGroup rbg=(RadioGroup) findViewById(R.id.radioGroup1);
        nombre = findViewById(R.id.Nombre);
        apellidos = findViewById(R.id.apPaterno);
        noCuenta = findViewById(R.id.No_Cuenta);
        bttnSubmit = findViewById(R.id.bttnSubmit);
        bttnCheck = findViewById(R.id.bttnCheck);
        bttnClear = findViewById(R.id.bttnClear);

        bttnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int selected=rbg.getCheckedRadioButtonId();
                RadioButton gender=(RadioButton) findViewById(selected);
                RadioButton maleRadioButton, femaleRadioButton;

                maleRadioButton = (RadioButton) findViewById(R.id.radioButton1);

                if(nombre.length()!=0 && apellidos.length()!=0 && noCuenta.length()!=0 && rbg.getCheckedRadioButtonId()!=-1) {
                    if (noCuenta.length()==10) {
                        genderString = gender.getText().toString();
                        if (maleRadioButton.isChecked()) {
                            listaAlumnos.add(new Alumno(R.mipmap.male, nombre.getText().toString(), apellidos.getText().toString(), gender.getText().toString(), noCuenta.getText().toString()));
                        } else {
                            listaAlumnos.add(new Alumno(R.mipmap.female, nombre.getText().toString(), apellidos.getText().toString(), gender.getText().toString(), noCuenta.getText().toString()));
                        }

                        openListViewActivity();
                        nombre.setText("");
                        apellidos.setText("");
                        noCuenta.setText("");
                        rbg.clearCheck();
                    }
                    else{
                        Toast.makeText(MainActivity.this, getString(R.string.toastIncompleteNoAccount), Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, getString(R.string.toastIncompleteForm), Toast.LENGTH_SHORT).show();
                }
            }
        });

        bttnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListViewActivity();
            }
        });

        bttnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaAlumnos.clear();
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
