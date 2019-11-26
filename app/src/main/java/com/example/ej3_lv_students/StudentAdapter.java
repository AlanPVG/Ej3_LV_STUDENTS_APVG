package com.example.ej3_lv_students;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

//Adaptador custom/personalizado para mostrar los datos de los alumnos registrados

public class StudentAdapter extends ArrayAdapter<Alumno> {

    private Context sContext;
    private List<Alumno> listaAlumnos = new ArrayList<>();


    public StudentAdapter(@NonNull Context context, ArrayList<Alumno> list){
        super(context,0,list);
        sContext = context;
        listaAlumnos = list;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(sContext).inflate(R.layout.item_list,parent,false);

            Alumno currentStudent = listaAlumnos.get(position);

        //Para cada uno de los objetos tipo alumno que fueron creados y almacenados en un arreglo del mismo tipo
        //se coloca el valor de sus atributos en un item del listView

        //Set del ícono para identificar el género
        ImageView imageView_genderIcon = (ImageView)listItem.findViewById(R.id.imageView_genderIcon);
        imageView_genderIcon.setImageResource(currentStudent.getGenderIcon());

        //Set del atributo 'nombre' del alumno en un textView dedicado en el item
        TextView name = listItem.findViewById(R.id.textView_name);
        name.setText(currentStudent.getNombre());

        //Set del atributo 'apellidos' del alumno en un textView dedicado en el item
        TextView apellidos = listItem.findViewById(R.id.textView_lastName);
        apellidos.setText(currentStudent.getApellidos());

        //Set del atributo 'noCuenta' del alumno en un textView dedicado en el item
        TextView noCuenta = listItem.findViewById(R.id.textView_studentCount);
        noCuenta.setText(currentStudent.getNoCuenta());

        //Set del atributo 'gender' del alumno en un textView dedicado en el item
        TextView gender = listItem.findViewById(R.id.textView_gender);
        gender.setText(currentStudent.getGenero());

        //Se regresa el item configurado
        return listItem;
    }
}
