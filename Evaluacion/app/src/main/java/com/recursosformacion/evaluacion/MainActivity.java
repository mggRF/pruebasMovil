package com.recursosformacion.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etMates;
    private EditText etFisi;
    private EditText etQuim;
    private TextView tvRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMates = (EditText) findViewById(R.id.txtMat);
        etFisi = (EditText) findViewById(R.id.txtFis);
        etQuim = (EditText) findViewById(R.id.txtQui);
        tvRespuesta = (TextView) findViewById((R.id.txtResultado));
    }

    public void evaluar(View view) {
        String vMates = etMates.getText().toString();
        String vFisi = etFisi.getText().toString();
        String vQuim = etQuim.getText().toString();

        int mates = Integer.parseInt(vMates);
        int fisi = Integer.parseInt(vFisi);
        int quimi = Integer.parseInt(vQuim);

        int respuesta = (mates + fisi + quimi)/3;
        if (respuesta >=5) {
            tvRespuesta.setText("Aprobado con " + respuesta);
        } else {
            tvRespuesta.setText("Suspendido con " + respuesta);
        }



    }
}