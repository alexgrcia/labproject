package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AdmiListadoCiclo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admi_listado_ciclo );

        setTitle("Ciclo");

        ArrayList<String> historial = new ArrayList<>();


        historial.add("01-2019");
        historial.add("02-2019");


        ArrayAdapter<String> data = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,historial);

        ListView listView = (ListView) findViewById(R.id.Ciclo);
        listView.setAdapter(data);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent historial_detalle = new Intent(getApplicationContext(), AdmiModificarCiclo.class);
                startActivity(historial_detalle);
            }
        });
    }
}
