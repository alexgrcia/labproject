package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdmiCrearEdificio extends AppCompatActivity {
    Button btnGuardar,btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admi_crear_edificio );

        btnCancelar = findViewById( R.id.btnCancelar );
        btnGuardar = findViewById( R.id.btnGuardar );

        btnGuardar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(),"Datos Almacenados",Toast.LENGTH_LONG ).show();
            }
        } );

        btnCancelar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresar = new Intent( getApplicationContext(),AdmiMainActivity.class );
                startActivity( regresar );
            }
        } );
    }
}
