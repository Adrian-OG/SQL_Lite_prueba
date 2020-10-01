package com.example.sql_lite_prueba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class list_alumnos extends AppCompatActivity {
    private alumnoAdaptador alumnoAdaptador;
        private RecyclerView recyclerViewAlumno;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_alumnos);
    recyclerViewAlumno=(RecyclerView)findViewById(R.id.recycler_list);
    recyclerViewAlumno.setLayoutManager(new LinearLayoutManager(this));
    DB db= new DB(getApplicationContext());
    alumnoAdaptador = new alumnoAdaptador(db.mostrarAlumnos());
    recyclerViewAlumno.setAdapter(alumnoAdaptador);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_alumno,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.item1){
            Intent in= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(in);
        }

        return super.onOptionsItemSelected(item)    ;
    }
}