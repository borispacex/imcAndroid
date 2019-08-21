package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_imc extends AppCompatActivity {

    private String nombre;
    private int peso;
    private double altura;
    private double calculo;

    private EditText ecalculado;
    private String estado;
    private TextView testado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        ecalculado = (EditText) findViewById(R.id.calculado);
        testado = (TextView) findViewById(R.id.estado);

        Bundle b = getIntent().getExtras();
        nombre = b.getString("nombre");
        peso = b.getInt("peso");
        altura = b.getDouble("altura");

        Toast toast = Toast.makeText(this, "LLego: "+nombre+" - "+peso+" - "+altura, Toast.LENGTH_SHORT);
        toast.show();

        calculo = peso / (altura * altura);
        ecalculado.setText(round(calculo, 2) + "");

        if (calculo < 18.5) {
            estado = "Bajo Peso";
        }else if (18.5 < calculo && calculo < 24.9) {
            estado = "Normal";
        } else if (25 < calculo && calculo < 29.9) {
            estado = "Sobrepeso";
        } else if (30 < calculo && calculo < 34.9) {
            estado = "Obesidad I";
        } else if (35 < calculo && calculo < 39.9) {
            estado = "Obrsidad II";
        } else if (40 < calculo && calculo < 49.9) {
            estado = "Obesidad III";
        } else if (calculo > 50) {
            estado = "Obesidad IV";
        }
        testado.setText(estado);
    }

    public void retornar(View view) {
        finish();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
