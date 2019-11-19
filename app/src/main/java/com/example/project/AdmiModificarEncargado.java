package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdmiModificarEncargado extends AppCompatActivity {
    Button btnGuardar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admi_activity_modificar_encargado);

        btnGuardar = findViewById( R.id.btnGuardar );
        btnCancelar = findViewById( R.id.btnCancelar );

        btnGuardar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Datos modificados", Toast.LENGTH_LONG ).show();
            }
        } );

        btnCancelar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj3 = new Intent( getApplicationContext(), AdmiListadoEncargados.class );
                startActivity( obj3 );
            }
        } );
    }
}
