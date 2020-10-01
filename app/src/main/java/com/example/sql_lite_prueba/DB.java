package com.example.sql_lite_prueba;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {
    private static final String NOMBRE_BD = "BD_prueba";
    private static  final int VERSION_BD=1;
    private static final String TABLA_ALUMNO ="CREATE TABLE ALUMNO ( ID_ALUMNO INTEGER PRIMARY KEY AUTOINCREMENT  , NOMBRE STRING , CODIGO STRING, CELULAR STRING , EMAIL STRING)";

    public DB (Context context){

        super(context, NOMBRE_BD,null, VERSION_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_ALUMNO);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS ALUMNO ");
    onCreate(db);
    }
    public void addAlumnos(String NOMBRE, String CODIGO, String CELULAR, String EMAIL){
        SQLiteDatabase bd = getWritableDatabase();
        if (bd!=null){
          bd.execSQL("insert into ALUMNO values ( null,'"+NOMBRE+"', '"+CODIGO+"', '"+CELULAR+"', '"+EMAIL+"')");
          bd.close();
        }
        
    }
    public List<Alumno> mostrarAlumnos(){
        SQLiteDatabase bd = getWritableDatabase();

        Cursor c = bd.rawQuery("SELECT * from ALUMNO", null);
        List <Alumno> alumnos = new ArrayList<>();
        if  (c.moveToFirst()){

            do {

                alumnos.add( new Alumno(c.getInt(c.getColumnIndex("ID_ALUMNO")),
                                        c.getString(c.getColumnIndex("NOMBRE")),
                                        c.getString(c.getColumnIndex("CODIGO")),
                                        c.getString(c.getColumnIndex("CELULAR")),
                                        c.getString(c.getColumnIndex("EMAIL"))));

            }while (c.moveToNext());
        }c.close();
        bd.close();
       return alumnos;
    }


}
