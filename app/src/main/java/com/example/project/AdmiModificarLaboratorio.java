package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdmiModificarLaboratorio extends AppCompatActivity {
    Button btnGuardar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admi_activity_modificar_laboratorio);

        btnGuardar = findViewById( R.id.btnGuardar );
        btnCancelar = findViewById( R.id.btnCancelar );

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.edificios_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnGuardar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Datos modificados", Toast.LENGTH_LONG ).show();
            }
        } );

        btnCancelar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj3 = new Intent( getApplicationContext(), AdmiListadoLaboratorio.class );
                startActivity( obj3 );
            }
        } );
    }
}
