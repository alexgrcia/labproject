package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EncargadoCrearHorario extends AppCompatActivity {
    EditText edtHEntrada, edtHSalida, edtInicio, edtFFin;
    Calendar calendario = Calendar.getInstance( );
    Button btnGuardar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_encargado_crear_horario );
        edtHEntrada = findViewById( R.id.edtHEntrada );
        edtHSalida = findViewById( R.id.edtHSalida );

        edtFFin = findViewById( R.id.edtFFin );
        edtInicio = findViewById( R.id.edtInicio );

        btnCancelar = findViewById( R.id.btnCancelar );
        btnGuardar = findViewById( R.id.btnGuardar );

        setTitle( "Crear horarios" );
        Spinner spinner = (Spinner) findViewById( R.id.spinner11 );
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.instructores_array, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter( adapter );

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner12);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.ciclo_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);

        edtHSalida.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance( );
                int hour = mcurrentTime.get( Calendar.HOUR_OF_DAY );
                int minute = mcurrentTime.get( Calendar.MINUTE );

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog( EncargadoCrearHorario.this, new TimePickerDialog.OnTimeSetListener( ) {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        edtHSalida.setText( selectedHour + ":" + selectedMinute );
                    }
                }, hour, minute, true );
                mTimePicker.setTitle( "Select Time" );
                mTimePicker.show( );

            }

        } );

        edtHEntrada.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance( );
                int hour = mcurrentTime.get( Calendar.HOUR_OF_DAY );
                int minute = mcurrentTime.get( Calendar.MINUTE );

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog( EncargadoCrearHorario.this, new TimePickerDialog.OnTimeSetListener( ) {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        edtHEntrada.setText( selectedHour + ":" + selectedMinute );
                    }
                }, hour, minute, true );
                mTimePicker.setTitle( "Select Time" );
                mTimePicker.show( );

            }
        } );

        edtInicio.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                new DatePickerDialog( EncargadoCrearHorario.this, date2, calendario.get( Calendar.YEAR ), calendario.get( Calendar.MONTH ), calendario.get( Calendar.DAY_OF_MONTH ) ).show( );
            }
        } );

        edtFFin.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                new DatePickerDialog( EncargadoCrearHorario.this, date, calendario.get( Calendar.YEAR ), calendario.get( Calendar.MONTH ), calendario.get( Calendar.DAY_OF_MONTH ) ).show( );
            }

        } );

        btnGuardar.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext( ), "Datos Almacenados", Toast.LENGTH_LONG ).show( );
            }
        } );
        btnCancelar.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent cancelar = new Intent( getApplicationContext( ), EncargadoMainActivity.class );
                startActivity( cancelar );

            }
        } );
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener( ) {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            calendario.set( Calendar.YEAR, year );
            calendario.set( Calendar.MONTH, month );
            calendario.set( Calendar.DAY_OF_MONTH, dayOfMonth );
            actualizarInput( );

        }
    };

    private void actualizarInput() {
        String formatoDeFecha = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat( formatoDeFecha, Locale.US );

        edtFFin.setText( sdf.format( calendario.getTime( ) ) );

    }

    DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener( ) {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            calendario.set( Calendar.YEAR, year );
            calendario.set( Calendar.MONTH, month );
            calendario.set( Calendar.DAY_OF_MONTH, dayOfMonth );
            actualizarInput1( );

        }
    };

    private void actualizarInput1() {
        String formatoDeFecha = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat( formatoDeFecha, Locale.US );

        edtInicio.setText( sdf.format( calendario.getTime( ) ) );

    }
}
