package com.example.sql_lite_prueba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_codigo, et_celular, et_email;
    Button bt_save ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_codigo = (EditText) findViewById(R.id.et_codigo);
        et_celular = (EditText) findViewById(R.id.et_celular);
        et_email = (EditText) findViewById(R.id.et_email);

        final DB dbsqlite = new DB(getApplicationContext());

        bt_save = (Button) findViewById(R.id.bt_save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbsqlite.addAlumnos(et_nombre.getText().toString(), et_codigo.getText().toString(), et_celular.getText().toString(), et_email.getText().toString());
                et_nombre.setText("");
                et_codigo.setText("");
                et_celular.setText("");
                et_email.setText("");
                Toast.makeText(getApplicationContext(), "Se registro correctamente", Toast.LENGTH_SHORT).show();


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_alumno,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.item2){
            Intent i= new Intent(getApplicationContext()  , list_alumnos.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item)    ;
    }

}