package com.recursosformacion.creararchivo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private EditText mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        mt = (EditText) findViewById(R.id.mt);
    }

    public void guardar(View view){
        String nombre = et.getText().toString();
        String contenido = mt.getText().toString();

        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this,tarjetaSD.getPath(),Toast.LENGTH_SHORT).show();
            File ruta = new File(tarjetaSD.getPath(),nombre);
            OutputStreamWriter fiche = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE));
            fiche.write(contenido);
            fiche.flush();
            fiche.close();

            Toast.makeText(this,"Guardado ok", Toast.LENGTH_SHORT).show();
            et.setText("");
            mt.setText("");

        } catch (IOException e) {
            Toast.makeText(this, "No de pudo guardar",Toast.LENGTH_SHORT).show();
        }
    }

    public void consultar(View view){
        String nombre = et.getText().toString();


        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();
            File ruta = new File(tarjetaSD.getPath(),nombre);
            InputStreamReader fiche = new InputStreamReader(openFileInput(nombre));
            BufferedReader lectura = new BufferedReader(fiche);
            String linea = lectura.readLine();
            String contenido="";

            while (linea != null){
                contenido += linea + "\n";
                linea=lectura.readLine();
            }
            lectura.close();
            fiche.close();
            mt.setText(contenido);

            

        } catch (IOException e) {
            Toast.makeText(this, "El fichero no existe o es erroneo",Toast.LENGTH_LONG).show();
        }
    }
}