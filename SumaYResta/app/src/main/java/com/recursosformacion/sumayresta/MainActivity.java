package com.recursosformacion.sumayresta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero1;
    private EditText etNumero2;
    private TextView tvRespuesta;
    private RadioButton rbSuma, rbResta, rbMulti, rbDivi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero1 = (EditText) findViewById(R.id.txtNum1);
        etNumero2 = (EditText) findViewById(R.id.txtNum2);
        tvRespuesta = (TextView) findViewById(R.id.txtResultado);
        rbSuma = (RadioButton) findViewById(R.id.rbSuma);
        rbResta = (RadioButton) findViewById(R.id.rbResta);
        rbMulti = (RadioButton) findViewById(R.id.rbMult);
        rbDivi = (RadioButton) findViewById(R.id.rbDivi);
    }

    //Calculo
    public void calcular(View view) {
        String valor1 = etNumero1.getText().toString();
        String valor2 = etNumero2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        int suma=0;
        if (rbSuma.isChecked()) {
            suma = num1 + num2;
        }
        if (rbResta.isChecked()) {
            suma = num1 - num2;
        }
        if (rbMulti.isChecked()) {
            suma = num1 * num2;
        }
        if (rbDivi.isChecked()) {
            if (num2 != 0) {
                suma = num1 / num2;
            } else {
                num2=1;
                Toast.makeText(this, "La division por cero no esta permitida", Toast.LENGTH_LONG).show();
            }
        }
        String result = String.valueOf(suma);
        tvRespuesta.setText(result);
    }


}