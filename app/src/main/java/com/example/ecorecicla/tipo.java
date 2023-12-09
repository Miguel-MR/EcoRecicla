package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class tipo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tipo);

        Button buttonRegreso = findViewById(R.id.buttonRegreso);
        Intent regresarInten = new Intent(this,categorias.class);
        buttonRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(regresarInten);
            }
        });

        Button plast = findViewById(R.id.buttonPlastico);
        plast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plastic = new Intent(tipo.this,plastico.class);
                startActivity(plastic);
            }
        });

        Button pap = findViewById(R.id.buttonPapel);
        pap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pape = new Intent(tipo.this, papel.class);
                startActivity(pape);
            }
        });

        Button liq = findViewById(R.id.buttonLiquidos);
        liq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent liqui = new Intent(tipo.this, claseliquidos.class);
                startActivity(liqui);
            }
        });

        Button dext = findViewById(R.id.buttonDesechosToxicos);
        dext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent desetx = new Intent(tipo.this, desechost.class);
                startActivity(desetx);
            }
        });
    }
}
