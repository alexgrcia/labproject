package com.example.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class dbContext extends SQLiteOpenHelper {

    public dbContext(@Nullable Context context) {
        super(context, DbDatos.dbName, null, DbDatos.dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //creacion de tabla accesos
        sqLiteDatabase.execSQL("create table accesos(acc_id integer primary key autoincrement, acc_usuario text, acc_clave text, acc_tipo_usuario integer)");
        Log.i("TABLA_CREADA","Tabla accesos credada");

        sqLiteDatabase.execSQL("insert into accesos(acc_usuario,acc_clave,acc_tipo_usuario) values('administrador','admin123',1)");
        sqLiteDatabase.execSQL("insert into accesos(acc_usuario,acc_clave,acc_tipo_usuario) values('encargado','en123',2)");
        sqLiteDatabase.execSQL("insert into accesos(acc_usuario,acc_clave,acc_tipo_usuario) values('instructor','in123',3)");
        Log.i("DATOS_INGRESADOS","Datos ingresados en accesos");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
