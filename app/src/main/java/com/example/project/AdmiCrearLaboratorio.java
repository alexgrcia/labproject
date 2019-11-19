package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdmiCrearLaboratorio extends AppCompatActivity {
    Button btnGuardar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admi_activity_crear_laboratorio);

        Spinner spinner = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.edificios_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnGuardar = findViewById( R.id.btnGuardar );
        btnCancelar = findViewById( R.id.btnCancelar );

        btnGuardar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(),"Datos Almacenados", Toast.LENGTH_LONG ).show();
            }
        } );
        btnCancelar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresar = new Intent(getApplicationContext(), AdmiMainActivity.class);
                startActivity(regresar);
            }
        } );

    }
}
