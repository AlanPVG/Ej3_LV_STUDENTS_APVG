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
        final RadioGroup rbg=(RadioGroup) findViewById(R.id.radioGroup1);//Grupo de botones radiales definidos para el género
        nombre = findViewById(R.id.Nombre);
        apellidos = findViewById(R.id.apellidos);
        noCuenta = findViewById(R.id.No_Cuenta);
        bttnSubmit = findViewById(R.id.bttnSubmit);
        bttnCheck = findViewById(R.id.bttnCheck);
        bttnClear = findViewById(R.id.bttnClear);

        //"Click" en el botón de envío
        bttnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int selected=rbg.getCheckedRadioButtonId();
                RadioButton gender=(RadioButton) findViewById(selected);
                RadioButton maleRadioButton;

                maleRadioButton = (RadioButton) findViewById(R.id.radioButton1);

                //Si los campos todos los campos han sido llenados y se ha seleccionado un género, se continua  a la
                //siguiente validación
                if(nombre.length()!=0 && apellidos.length()!=0 && noCuenta.length()!=0 && rbg.getCheckedRadioButtonId()!=-1) {
                    //Si el número de cuenta es de exactamente 10 dígitos se continua a la siguiente validación
                    if (noCuenta.length()==10) {
                        genderString = gender.getText().toString();
                        //Si se identifica que el género elegido es "masculino", se crea el objeto con los datos ingresados y se le
                        //asigna el ícono correspondiente al género
                        if (maleRadioButton.isChecked()) {
                            listaAlumnos.add(new Alumno(R.mipmap.male, nombre.getText().toString(), apellidos.getText().toString(), gender.getText().toString(), noCuenta.getText().toString()));
                        } else {
                            //Si el género elegido no es masculino, entones se eligió el femenino y se crea el objeto
                            //con los datos ingresados y se le asigna el ícono correspondiente al género
                            listaAlumnos.add(new Alumno(R.mipmap.female, nombre.getText().toString(), apellidos.getText().toString(), gender.getText().toString(), noCuenta.getText().toString()));
                        }

                        //Se limpian los campos del formulario
                        Toast.makeText(MainActivity.this, getString(R.string.succesfulRegister), Toast.LENGTH_SHORT).show();
                        nombre.setText("");
                        apellidos.setText("");
                        noCuenta.setText("");
                        rbg.clearCheck();

                    }
                    else{
                        //Si el número de cuenta no es de 10 dígitos se notifica con un mensaje Toast
                        Toast.makeText(MainActivity.this, getString(R.string.toastIncompleteNoAccount), Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    //Si todos los campos no son llenados, se notifica de esto con un mensaje Toast
                    Toast.makeText(MainActivity.this, getString(R.string.toastIncompleteForm), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Al presionar el botón de "ir a registro" se abre la activity contenedora del listView que a su vez alberga el registro de alumnos
        bttnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListViewActivity();
            }
        });

        //Botón de limpieza de registro
        bttnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaAlumnos.clear();//Se eliminan los elementos tipo Alumno de la lista
                Alumno.counter=1;//Se resetea el valor para del contador para el ID de los alumnos
                //Notificación de eliminación de registros
                Toast.makeText(MainActivity.this, getString(R.string.toastRegisterCleared), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Método para pasar la lista de elementos tipo Alumno a la clase que define el listView
    public void openListViewActivity(){
        ArrayList<Alumno> auxArrayAlumnos = listaAlumnos;
        Intent intent = new Intent(this, listViewActivity.class);
        intent.putExtra(arrayAlumnos,(Serializable) auxArrayAlumnos);
        startActivity(intent);
    }

}
