package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String nombre;
    private int peso;
    private double altura;

    private EditText enombre;
    private EditText epeso;
    private EditText ealtura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enombre = (EditText) findViewById(R.id.innombre);
        epeso = (EditText) findViewById(R.id.inpeso);
        ealtura = (EditText) findViewById(R.id.inaltura);

    }

    public void calcular(View view) {
        nombre = enombre.getText().toString();
        peso = Integer.parseInt(epeso.getText().toString());
        altura = Double.parseDouble(ealtura.getText().toString());


        Intent vd = new Intent(this, activity_imc.class);
        vd.putExtra("peso", peso);
        vd.putExtra("altura", altura);
        vd.putExtra("nombre", nombre);
        startActivity(vd);
    }
}
