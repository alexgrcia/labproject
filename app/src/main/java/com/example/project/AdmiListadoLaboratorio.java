package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdmiListadoLaboratorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admi_activity_listado_laboratorio);
        setTitle("Laboratorios");

        ArrayList<String> historial = new ArrayList<>();

        historial.add("Laboratorio 1");
        historial.add("Laboratorio 2");
        historial.add("Laboratorio 3");

        ArrayAdapter<String> data = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,historial);

        ListView listView = (ListView) findViewById(R.id.Listado);
        listView.setAdapter(data);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent historial_detalle = new Intent(getApplicationContext(), AdmiModificarLaboratorio.class);
                startActivity(historial_detalle);
            }
        });

    }
}
