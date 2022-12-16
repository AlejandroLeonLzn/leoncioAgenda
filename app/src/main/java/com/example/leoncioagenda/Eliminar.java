package com.example.leoncioagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {
    private EditText edtNomEli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        edtNomEli=findViewById(R.id.edtNomEli);
    }

    public void baja(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nom= edtNomEli.getText().toString();
        bd.execSQL("DELETE FROM agendaContactos WHERE nombre='"+nom+"'");
        bd.close();
        Toast.makeText(this, "Borrado", Toast.LENGTH_SHORT).show();
    }
}