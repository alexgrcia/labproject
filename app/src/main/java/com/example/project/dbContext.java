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
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS accesos");
        sqLiteDatabase.execSQL("create table accesos(acc_id integer primary key autoincrement, acc_usuario text, acc_clave text, acc_tipo_usuario integer)");
        Log.i("TABLA_CREADA","Tabla accesos credada");

        sqLiteDatabase.execSQL("insert into accesos(acc_usuario,acc_clave,acc_tipo_usuario) values('administrador','admin123',1)");
        sqLiteDatabase.execSQL("insert into accesos(acc_usuario,acc_clave,acc_tipo_usuario) values('encargado','en123',2)");
        sqLiteDatabase.execSQL("insert into accesos(acc_usuario,acc_clave,acc_tipo_usuario) values('instructor','in123',3)");
        Log.i("DATOS_INGRESADOS","Datos ingresados en accesos");

        //creacion de tabla carreras
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS carreras");
        sqLiteDatabase.execSQL("create table carreras(ca_id integer primary key autoincrement, ca_nombre text)");
        sqLiteDatabase.execSQL("insert into carreras(ca_nombre) values('Ingenieria en siatemas y computacion')");

        // creacion de tabla instructores
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS instructores");
        sqLiteDatabase.execSQL("create table instructores(ins_id integer primary key autoincrement, ins_nombre text, ins_apellidos text, ins_email text, ins_carnet text, ins_id_carrera integer not null,ins_acc_id integer, foreign key(ins_id_carrera) references carreras(ca_id), foreign key(ins_acc_id) references accesos(acc_id))");
        sqLiteDatabase.execSQL("insert into instructores(ins_nombre, ins_apellidos,ins_email, ins_carnet, ins_id_carrera,ins_acc_id)"+
                                "values('karina','sura','kasura@yopmail.com','2527522015',1,3)");

        //creacion de la tabla edificios
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS edificios");
        sqLiteDatabase.execSQL("create table edificios(edi_id integer primary key autoincrement, edi_nombre text)");

        //creacion de la tabla laboratorios
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS laboratorios");
        sqLiteDatabase.execSQL("create table laboratorios(lab_id integer primary key autoincrement, lab_nombre text, lab_correlativo integer, lab_nivel integer, lab_id_edificio integer not null, foreign key(lab_id_edificio) references edificios(edi_id))");

        //creacion de la tabla ciclos
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ciclos");
        sqLiteDatabase.execSQL("create table ciclos(ci_id integer primary key autoincrement, ci_codigo text,ci_fecha_inicio text, ci_fecha_fin text, ci_estado)");

        // creacion de la tabla empleados
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS empleados");
        sqLiteDatabase.execSQL("create table empleados(emp_id integer primary key autoincrement, emp_nombre text,emp_apellido text, emp_email text, emp_tipo integer, emp_estado text)");

        //creacion de tabla empleado asignacion
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS empleado_asignacion");
        sqLiteDatabase.execSQL("create table empleado_asignacion(encasig_id integer primary key autoincrement, encasig_emp_id integer, encasig_lab_id integer, encasig_ci_id integer, foreign key(encasig_emp_id) references empleados(emp_id),foreign key(encasig_lab_id) references laboratorios(lab_id), foreign key(encasig_ci_id) references lciclos(ci_id) )");
        //creacion de tabla instructor asiganacion
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS instructor_asignacion");
        sqLiteDatabase.execSQL("create table instructor_asignacion(insasing_id integer primary key autoincrement,"+
                               "insasig_ins_id integer, insasig_ci_id integer,insasig_fecha_inicio text,insasig_fecha_fin text,"+
                               "foreign key(insasig_ins_id) references instructores(ins_id),"+
                               "foreign key(insasig_ci_id) references ciclos(ci_id))");
        //creacion de tabla det instructor asignacion
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS det_ins_asig");
        sqLiteDatabase.execSQL("create table det_ins_asig(insdet_id integer primary key autoincrement, insdet_dia text,insdet_hora_inicio," +
                               "insdet_hora_fin text, insdet_insasig_id integer, foreign key(insdet_insasig_id) references instructor_asignacion(insasing_id))");


        //creacion de la tabla actividades
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS actividades");
        sqLiteDatabase.execSQL("create table actividades(act_id integer primary key autoincrement, act_nombre text, act_descripcion text, act_estado text)");

        //creacion de actividad turno instructor
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS actividad_turno_instructor");
        sqLiteDatabase.execSQL("create table actividad_turno_instructor(turno_id integer primary key autoincrement, turno_hora_inicio text, turno_hora_fin text,"+
                "turno_insdet_id integer, turno_act_id integer, turno_revisado text, turno_aprobado,"+
                "foreign key(turno_insdet_id) references det_ins_asig(insdet_id), foreign key(turno_act_id) references actividades(act_id))");

        //creacion de tabla det enc asig

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
