package com.recursosformacion.imagenboton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mensa1(View view){
        Toast.makeText(this, "Un mensaje",Toast.LENGTH_SHORT).show();
    }
    public void mensa2(View view){
        Toast.makeText(this, "Otro mensaje",Toast.LENGTH_SHORT).show();
    }
}