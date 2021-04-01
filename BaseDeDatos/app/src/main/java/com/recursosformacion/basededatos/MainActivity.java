package com.recursosformacion.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCod,etDescri,etPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCod = (EditText) findViewById(R.id.etCod);
        etDescri = (EditText) findViewById(R.id.etDescri);
        etPrecio = (EditText) findViewById(R.id.etPrecio);
    }

    //Alta producto
    public void grabar(View view){
        AdminSQLite admin = new AdminSQLite(this,"Administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = etCod.getText().toString();
        String descri = etDescri.getText().toString();
        String precio = etPrecio.getText().toString();

        if (!codigo.isEmpty() && !descri.isEmpty() && !precio.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descri);
            registro.put("precio", precio);

            db.insert("articulos", null, registro);

            Toast.makeText(this, "Registro grabado correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Se han de completar todos los campos",Toast.LENGTH_SHORT).show();
        }
        db.close();
        etCod.setText("");
        etDescri.setText("");
        etPrecio.setText("");

    }

    //consultar producto
    public void buscar(View view){
        AdminSQLite admin = new AdminSQLite(this,"Administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = etCod.getText().toString();
        if (!codigo.isEmpty() ) {
             Cursor fila = db.rawQuery("SELECT * FROM articulos WHERE codigo = " + codigo,null);
             if (fila.moveToFirst()){
                 etDescri.setText(fila.getString(1));
                 etPrecio.setText(fila.getString(2));
             } else {
                 Toast.makeText(this, "Registro no encontrado", Toast.LENGTH_SHORT).show();
             }
        } else {
            Toast.makeText(this,"Indicar el código",Toast.LENGTH_SHORT).show();
        }
        db.close();
        
    }

    //borrar producto
    public void borrar(View view){
        AdminSQLite admin = new AdminSQLite(this,"Administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = etCod.getText().toString();
        if (!codigo.isEmpty() ) {
            int cant = db.delete("articulos", "codigo=" + codigo,null);
            if (cant != 0){
                Toast.makeText(this, "Registro borrado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Registro no encontrado", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this,"Indicar el código",Toast.LENGTH_SHORT).show();
        }
        db.close();
        etCod.setText("");
        etDescri.setText("");
        etPrecio.setText("");
    }

    //modificar producto
    public void modificar(View view){
        AdminSQLite admin = new AdminSQLite(this,"Administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = etCod.getText().toString();
        String descri = etDescri.getText().toString();
        String precio = etPrecio.getText().toString();

        if (!codigo.isEmpty() && !descri.isEmpty() && !precio.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descri);
            registro.put("precio", precio);

            int cant=db.update("articulos", registro, "codigo=" + codigo, null);

            if (cant != 0){
                Toast.makeText(this, "Registro modificado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Registro no encontrado", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this,"Se han de completar todos los campos",Toast.LENGTH_SHORT).show();
        }
        db.close();
        etCod.setText("");
        etDescri.setText("");
        etPrecio.setText("");
    }
}