package com.example.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    //se define a base de datos
    SQLiteDatabase database;


    Button btnLogin;
    EditText edtUser;
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //se crea la base de datos
        dbContext db = new dbContext(getApplicationContext());
        database = db.getWritableDatabase();

        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnGuardar );
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validate(edtUser)) {
                   if(validate(edtPass)) {
                       logearse(edtUser.getText().toString(), edtPass.getText().toString());
                   }
                }

            }
        });
    }

    void logearse(String user, String pass){

        // se verifica que exista el usuario

        String queryLogin = "select * from accesos where acc_usuario = '"+user+"' and acc_clave='"+pass+"'";
        Cursor result = database.rawQuery(queryLogin,null);

        if(result.moveToNext())
        {
            int tipoUsuario = Integer.parseInt(result.getString(3));

            Toast.makeText(getApplicationContext(),String.valueOf(tipoUsuario),Toast.LENGTH_SHORT).show();


            if(tipoUsuario == 2) {
                Intent intent = new Intent(getApplicationContext(), EncargadoMainActivity.class);
                startActivity(intent);
            }else if(tipoUsuario == 1){
                Intent intent = new Intent(getApplicationContext(), AdmiMainActivity.class);
                startActivity(intent);
            }else if(tipoUsuario == 3) {
                Intent intent = new Intent(getApplicationContext(), InstructorMainActivity.class);
                startActivity(intent);
            }
        }else{
            Toast.makeText(getApplicationContext(),"Usuario o clave incorrecta",Toast.LENGTH_SHORT).show();
        }
    }

    boolean validate(EditText edt){
        boolean result = true;
        if (TextUtils.isEmpty(edt.getText())){
            result = false;
            edt.setError("Campo Requerido");
            edt.requestFocus();
        }
        return result;
    }
}
