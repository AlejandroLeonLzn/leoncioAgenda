package com.example.leoncioagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Actualizar extends AppCompatActivity {
    private EditText edtNomAct, edtEmaAct, edtTelAct, edtDirAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        edtNomAct=findViewById(R.id.edtNomAct);
        edtEmaAct=findViewById(R.id.edtEmaAct);
        edtTelAct=findViewById(R.id.edtTelAct);
        edtDirAct=findViewById(R.id.edtDirAct);
    }
    public void modificacion(View v) {
        if (edtNomAct.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un Nombre",
                    Toast.LENGTH_SHORT).show();
        } else if (edtEmaAct.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un Email",
                    Toast.LENGTH_SHORT).show();
        } else if (edtTelAct.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un Telefono",
                    Toast.LENGTH_SHORT).show();
        } else if (edtDirAct.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese una Dirección",
                    Toast.LENGTH_SHORT).show();
        } else {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String noma = edtNomAct.getText().toString();
            String emaa = edtEmaAct.getText().toString();
            String tela = edtTelAct.getText().toString();
            String dira = edtDirAct.getText().toString();
            ContentValues registro = new ContentValues();
            registro.put("nombre", noma);
            registro.put("email", emaa);
            registro.put("telefono", tela);
            registro.put("direccion", dira);
            bd.execSQL("UPDATE agendaContactos SET email = '"+emaa+"', telefono = '"+tela+"', direccion='"+dira+"' WHERE nombre='"+noma+"'");
            bd.close();
            Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
        }
    }

    public void consultaporNom(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nom = edtNomAct.getText().toString();
        Cursor fila = bd.rawQuery(
                "select nombre, email, telefono, direccion from agendaContactos where nombre='" +
                        nom +"'", null);
        if (fila.moveToFirst()) {
            edtNomAct.setText(fila.getString(0));
            edtEmaAct.setText(fila.getString(1));
            edtTelAct.setText(fila.getString(2));
            edtDirAct.setText(fila.getString(3));
        } else
            Toast.makeText(this, "No existe",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
}