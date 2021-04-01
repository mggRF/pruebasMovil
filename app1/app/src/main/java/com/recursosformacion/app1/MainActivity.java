package com.recursosformacion.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText etNumero1;
    private EditText etNumero2;
    private TextView tvRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero1 = (EditText) findViewById(R.id.txtNum1);
        etNumero2 = (EditText) findViewById(R.id.txtNum2);
        tvRespuesta = (TextView) findViewById((R.id.txtResultado));
    }

    //suma
    public void sumar(View view) {
        String valor1 = etNumero1.getText().toString();
        String valor2 = etNumero2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        int suma = num1 + num2;
        String result = String.valueOf(suma);
        tvRespuesta.setText(result);
    }
}
