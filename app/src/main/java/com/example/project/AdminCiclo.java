package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Locale;

public class AdminCiclo extends AppCompatActivity {
    EditText edtFInicio,edtFFin,edtNombreCiclo;
   Calendar calendario = Calendar.getInstance();
   RadioButton rdbActivo, edbIncactivo;
   Button btnGuardar,btnCancelar;

   SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admin_ciclo );

        //instancia de la base de datos
        dbContext db = new dbContext(getApplicationContext());
        database = db.getReadableDatabase();


        edtFFin = findViewById(R.id.edtFFin );
        edtFInicio = findViewById( R.id.edtFInicio );
        edtNombreCiclo = findViewById(R.id.edtCiclo);

        rdbActivo = findViewById(R.id.radioButton5);
        edbIncactivo = findViewById(R.id.radioButton6);

        btnGuardar = findViewById( R.id.btnGuardar );
        btnCancelar = findViewById( R.id.btnCancelar );



        edtFInicio.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog( AdminCiclo.this,date2, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        } );

        edtFFin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog( AdminCiclo.this,date, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH)).show();
            }

        } );

        btnGuardar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String status = "Activo";
                if(edbIncactivo.isChecked()){
                    status = "Inactivo";
                }

                String queryCiclo = "insert into ciclos(ci_codigo, ci_fecha_inicio,ci_fecha_fin,ci_estado)"+
                                    "values('"+edtNombreCiclo.getText().toString()+"','"+edtFInicio.getText().toString()+"','"+edtFFin.getText().toString()+"','"+status+"')";
                Cursor cursor = database.rawQuery(queryCiclo,null);

                if(cursor.moveToNext())
                {
                    Toast.makeText(getApplicationContext(), "Datos Almacenados", Toast.LENGTH_SHORT ).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Eror al guardar los datos", Toast.LENGTH_SHORT ).show();
                }
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

    DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, month);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput2();
        }
    };

    private void actualizarInput2() {
        String formatoDeFecha = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        edtFInicio.setText(sdf.format(calendario.getTime()));
    }
}
