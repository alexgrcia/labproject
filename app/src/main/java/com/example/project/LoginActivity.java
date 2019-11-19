package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtUser;
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        if(user.contains("encargado")) {
            Intent intent = new Intent(getApplicationContext(), EncargadoMainActivity.class);
            startActivity(intent);
        }else if(user.contains("administrador")){
            Intent intent = new Intent(getApplicationContext(), AdmiMainActivity.class);
            startActivity(intent);
        }else if(user.contains("instructor")) {
            Intent intent = new Intent(getApplicationContext(), InstructorMainActivity.class);
            startActivity(intent);
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
