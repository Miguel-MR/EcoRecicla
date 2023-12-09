package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.modelo.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class resgistro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        final EditText nombre = findViewById(R.id.editTextText);
        final EditText correo = findViewById(R.id.editTextTextEmailAddress);
        final EditText celular = findViewById(R.id.editTextPhone);
        final Intent intent1 = new Intent(this, activity.class);
        final EditText contraseña = findViewById(R.id.editTextNumberPassword);
        final EditText repContraseña = findViewById(R.id.editTextrepetPassword);
        RadioButton terminosCondiciones = findViewById(R.id.terminosYCondiciones);
        RadioButton tratamientoDatos = findViewById(R.id.tratamientoDatos);
        Button buttonRegreso = findViewById(R.id.buttonRegreso);

        Intent regresarInten = new Intent(this,activity.class);
        buttonRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(regresarInten);
            }
        });
        Button registrar = findViewById(R.id.button);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminosCondiciones.isChecked() && tratamientoDatos.isChecked()) {
                    if (!nombre.getText().toString().isEmpty() && !correo.getText().toString().isEmpty() &&
                            !celular.getText().toString().isEmpty() && !contraseña.getText().toString().isEmpty() &&
                            !repContraseña.getText().toString().isEmpty()) {
                        if (contraseña.getText().toString().equals(repContraseña.getText().toString())) {
                            if (valiarDatos(nombre.getText().toString(), correo.getText().toString(), celular.getText().toString())) {
                                Toast.makeText(getApplicationContext(), "El usuario ya se encuentra registrado", Toast.LENGTH_SHORT).show();
                            } else {
                                Usuario nuevoUsuario = new Usuario(nombre.getText().toString(),
                                        correo.getText().toString(), celular.getText().toString(),
                                        contraseña.getText().toString());
                                registrarUsuario(nuevoUsuario);
                                startActivity(intent1);
                                Toast.makeText(resgistro.this, "Datos guardados correctamente",
                                        Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Debe aceptar los términos y condiciones, " +
                            "tratamiento de datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Spinner spn1 = findViewById(R.id.spinner);
        ArrayList Lista = new ArrayList();
        Lista.add("Ciudad");
        Lista.add("Bogotá");
        Lista.add("Cali");
        Lista.add("Barranquilla");
        Lista.add("Medellín");
        Lista.add("Bucaramanga");

        ArrayAdapter adap = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Lista);
        spn1.setAdapter(adap);
    }

    private void registrarUsuario(Usuario nuevoUsuario) {
        File file = new File(getFilesDir(), "registroDeUsuarios.txt");

        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String nuevoRegistrs = nuevoUsuario.getNombre() + "," + nuevoUsuario.getCorreo() + "," +
                    nuevoUsuario.getCelular() + "," + nuevoUsuario.getContraseña() + "\n";
            bufferedWriter.write(nuevoRegistrs);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean valiarDatos(String nombre, String correo, String celular) {
        File file = new File(getFilesDir(), "registroDeUsuarios.txt");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            List<String> existingNombre = new ArrayList<>();
            List<String> existingCorreo = new ArrayList<>();
            List<String> existingCelular = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] Usuario = line.split(",");
                existingNombre.add(Usuario[1]);
                existingCorreo.add(Usuario[2]);
                existingCelular.add(Usuario[3]);
            }
            bufferedReader.close();

            return existingNombre.contains(nombre) || existingCelular.contains(celular) || existingCorreo.contains(correo);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
