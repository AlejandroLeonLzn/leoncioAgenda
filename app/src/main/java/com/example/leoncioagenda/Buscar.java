package com.example.leoncioagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Buscar extends AppCompatActivity {
    private EditText edtNomBus, edtEmaBus, edtTelBus, edtDirBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        edtNomBus=findViewById(R.id.edtNomBus);
        edtEmaBus=findViewById(R.id.edtEmaBus);
        edtTelBus=findViewById(R.id.edtTelBus);
        edtDirBus=findViewById(R.id.edtDirBus);
    }
    public void consultaporNom(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nom = edtNomBus.getText().toString();
        Cursor fila = bd.rawQuery(
                "select nombre, email, telefono, direccion from agendaContactos where nombre='" +
                        nom +"'", null);
        if (fila.moveToFirst()) {
            edtNomBus.setText(fila.getString(0));
            edtEmaBus.setText(fila.getString(1));
            edtTelBus.setText(fila.getString(2));
            edtDirBus.setText(fila.getString(3));
        } else
            Toast.makeText(this, "No existe",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
}