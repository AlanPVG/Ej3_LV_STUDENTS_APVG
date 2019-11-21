package com.example.ej3_lv_students;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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

        TextView name = listItem.findViewById(R.id.textView_name);
        name.setText(currentStudent.getNombre());

        TextView apellidos = listItem.findViewById(R.id.textView_lastName);
        apellidos.setText(currentStudent.getApellidos());

        TextView noCuenta = listItem.findViewById(R.id.textView_studentCount);
        noCuenta.setText(currentStudent.getNoCuenta());

        TextView gender = listItem.findViewById(R.id.textView_gender);
        gender.setText(currentStudent.getGenero());

        return listItem;
    }
}
