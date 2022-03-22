package com.example.gasolinaxalcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtGasolina;
    EditText edtAlcool;
    Button btnVerificar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configurarBotaoVerificar();
    }

    protected void carregaComponentes() {
        edtGasolina = findViewById(R.id.edtGasolina);
        edtAlcool = findViewById(R.id.edtAlcool);
        btnVerificar = findViewById(R.id.btnVerificar);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configurarBotaoVerificar() {
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = realizaCalculo();
                exibiResultado(resultado);
                limpaCampos();
            }
        });
    }

    protected String realizaCalculo() {
        double gasolina = Double.parseDouble(edtGasolina.getText().toString());
        double alcool = Double.parseDouble(edtAlcool.getText().toString());
        double res = alcool / gasolina;
        String resultado = "Abasteça com gasolina, esta compensando mais";
        if (res < 0.7){
            resultado = "Abasteça com álcool, a gasolina está cara";
        }
        return resultado;
    }
    protected void exibiResultado(String resultado) {
        txtResultado.setText(resultado);
    }

    protected void limpaCampos() {
        edtGasolina.setText("");
        edtAlcool.setText("");

        edtGasolina.requestFocus();
        edtAlcool.requestFocus();


    }
}
