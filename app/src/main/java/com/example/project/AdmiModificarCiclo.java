package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AdmiModificarCiclo extends AppCompatActivity {
    EditText edtFInicio,edtFFin;
    Calendar calendario = Calendar.getInstance();
    Button btnGuardar,btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admi_modificar_ciclo );

        edtFFin = findViewById(R.id.edtFFin );
        edtFInicio = findViewById( R.id.edtFInicio );

        btnGuardar = findViewById( R.id.btnGuardar );
        btnCancelar = findViewById( R.id.btnCancelar );

        edtFInicio.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog( AdmiModificarCiclo.this,date, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        } );

        edtFFin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog( AdmiModificarCiclo.this,date, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH)).show();
            }

        } );

        btnGuardar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Datos Almacenados", Toast.LENGTH_SHORT ).show();
            }
        } );


        btnCancelar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresar = new Intent( getApplicationContext(), AdmiMainActivity.class );
                startActivity( regresar );
            }
        } );
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, month);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }
    };

    private void actualizarInput() {
        String formatoDeFecha = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        edtFFin.setText(sdf.format(calendario.getTime()));
    }

}
