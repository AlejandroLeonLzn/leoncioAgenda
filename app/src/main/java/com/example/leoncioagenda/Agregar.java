package com.example.leoncioagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Agregar extends AppCompatActivity {
    private EditText edtNomAgr, edtEmaAgr, edtTelAgr, edtDirAgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        edtNomAgr=findViewById(R.id.edtNomAgr);
        edtEmaAgr=findViewById(R.id.edtEmaAgr);
        edtTelAgr=findViewById(R.id.edtTelAgr);
        edtDirAgr=findViewById(R.id.edtDirAgr);
    }
    public void alta(View v) {
        if (edtNomAgr.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un Nombre",
                    Toast.LENGTH_SHORT).show();
        } else if(edtEmaAgr.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un Email",
                    Toast.LENGTH_SHORT).show();
        } else if(edtTelAgr.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un Telefono",
                    Toast.LENGTH_SHORT).show();
        } else if(edtDirAgr.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese una Dirección",
                    Toast.LENGTH_SHORT).show();
        }else{
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String nom = edtNomAgr.getText().toString();
            String ema = edtEmaAgr.getText().toString();
            String tel = edtTelAgr.getText().toString();
            String dir = edtDirAgr.getText().toString();
            ContentValues registro = new ContentValues();
            registro.put("nombre", nom);
            registro.put("email", ema);
            registro.put("telefono", tel);
            registro.put("direccion", dir);
            bd.insert("agendaContactos", null, registro);
            bd.close();
            Toast.makeText(this, "Se cargaron los datos del Contacto",
                    Toast.LENGTH_SHORT).show();
        }
    }
}