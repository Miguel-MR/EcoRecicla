package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.modelo.Liquidos;
import com.example.ecorecicla.modelo.Papel;
import com.example.ecorecicla.modelo.Plastico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class plastico extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plastico);

        Button botonRegresar = findViewById(R.id.buttonRegreso);
        Button botonGuardar = findViewById(R.id.buttonGuar5);
        EditText cantidad = findViewById(R.id.editTextNumber);
        EditText mes = findViewById(R.id.editTextMes);

        Intent intent1 = new Intent(plastico.this, tipo.class);
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cantidad.getText().toString().isEmpty() && !mes.getText().toString().isEmpty()) {
                    String mesBuscado = mes.getText().toString();
                    boolean mesExiste = verificarMes(mesBuscado);
                    if (mesExiste) {
                        Toast.makeText(plastico.this, "El mes ya existe", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean datosGuardados = guardarDatos(cantidad.getText().toString(), mes.getText().toString());
                        if (datosGuardados) {
                            Toast.makeText(plastico.this, "Datos guardados correctamente",
                                    Toast.LENGTH_SHORT).show();
                            Intent punt = new Intent(plastico.this, splashpuntos.class);
                            startActivity(punt);
                        } else {
                            Toast.makeText(plastico.this, "Error al guardar el archivo",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(plastico.this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean verificarMes(String mesBuscado) {
        File file = new File(getFilesDir(), "plastico.txt");
        mesBuscado = mesBuscado.toLowerCase();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String mes = linea.split(",")[2];
                if (mes.equalsIgnoreCase(mesBuscado)) {
                    bufferedReader.close();
                    return true;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean guardarDatos(String cantidad, String mes) {
        File file = new File(getFilesDir(), "plastico.txt"  );
        mes = mes.toLowerCase();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            Plastico plastico = new Plastico(Float.parseFloat(cantidad), mes);
            String linea = plastico.getCantidad() + "," + plastico.getMes();
            bufferedWriter.write(linea);
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
