package com.example.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdmiListadoEncargados extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admi_activity_listado_encargados);

        //instancia de la base
        dbContext database = new dbContext(getApplicationContext());
        db = database.getWritableDatabase();

        //se obtienen todos los encargados
        String consultaSQL = "select * from empleados where emp_tipo = 1";
        Cursor data = db.rawQuery(consultaSQL,null);

        while(data.moveToNext())
        {

        }

        setTitle("Encargados");

        String[] historial = new String[3];

        historial[0] =("Juan Perez");
        historial[1] =("Maria Ramirez ");
        historial[2] =("Jose Felix");

       ArrayCustomAdapter ca = new ArrayCustomAdapter(this,historial,R.layout.row_user_list);

        ListView listView = (ListView) findViewById(R.id.ListaEncargados);
        listView.setAdapter(ca);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent historial_detalle = new Intent(getApplicationContext(), AdmiModificarEncargado.class);
                startActivity(historial_detalle);
            }
        });

    }
}
