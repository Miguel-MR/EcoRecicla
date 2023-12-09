package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class categorias extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias);

        Button buttonRegreso = findViewById(R.id.buttonRegreso);

        Intent regresarInten = new Intent(this,activity.class);
        buttonRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(regresarInten);
            }
        });

        Button cat = findViewById(R.id.buttonCategorias);
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categ = new Intent(categorias.this, tipo.class);
                startActivity(categ);
            }
        });

        Button consjo = findViewById(R.id.buttonConsejos);
        consjo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consej = new Intent(categorias.this, consejos.class);
                startActivity(consej);
            }
        });

        Button estad = findViewById(R.id.buttonEstadisticas);
        estad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stadi = new Intent(categorias.this, estadisticas.class);
                startActivity(stadi);
            }
        });

        Button inf = findViewById(R.id.buttonMasinformacion);
        inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masinf = new Intent(categorias.this, masinformacion.class);
                startActivity(masinf);
            }

        });
    }
}

