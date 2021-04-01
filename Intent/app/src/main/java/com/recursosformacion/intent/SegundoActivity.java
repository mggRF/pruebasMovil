package com.recursosformacion.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        tv2=(TextView) findViewById(R.id.tv2);
       String dato = getIntent().getStringExtra("nombre");
        tv2.setText("Hola " + dato);
    }

    public void anterior(View view)
    {
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}