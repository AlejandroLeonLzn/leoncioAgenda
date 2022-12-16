package com.example.leoncioagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAgregar (View view){
        Intent i = new Intent(this,Agregar.class);
        startActivity(i);
    }
    public void irBuscar (View view){
        Intent i = new Intent(this,Buscar.class);
        startActivity(i);
    }
    public void irElimnar (View view){
        Intent i = new Intent(this,Eliminar.class);
        startActivity(i);
    }
    public void irActualizar (View view){
        Intent i = new Intent(this,Actualizar.class);
        startActivity(i);
    }
}