package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class EncargadoModificarActividades extends AppCompatActivity {
    Button btnGuardar,btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.encargado_modificar_actividades );

        btnCancelar = findViewById( R.id.btnCancelar );
        btnGuardar = findViewById( R.id.btnGuardar );

        Spinner spinner = (Spinner) findViewById(R.id.Estado);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.status_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnGuardar.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(),"Datos Almacenados", Toast.LENGTH_LONG ).show();
            }
        } );

        btnCancelar.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent cancelar = new Intent( getApplicationContext(),EncargadoListadoActividades.class );
                startActivity( cancelar );

            }
        } );
    }
}
