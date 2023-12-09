package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.modelo.Desechos;
import com.example.ecorecicla.modelo.Liquidos;
import com.example.ecorecicla.modelo.Papel;
import com.example.ecorecicla.modelo.Plastico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class estadisticas extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas);

        Button botonRegresar = findViewById(R.id.buttonRegreso);
        tableLayout = findViewById(R.id.myTableLayout);
        Intent intent = new Intent(this, categorias.class);

        File liquidosFile = new File(getFilesDir(), "liquidos.txt");
        File plasticosFile = new File(getFilesDir(), "plastico.txt");
        File desechosFile = new File(getFilesDir(), "desechos.txt");
        File papelFile = new File(getFilesDir(), "papel.txt");

        List<Liquidos> listaLiquidos = leerArchivoliquidos(liquidosFile);
        List<Plastico> listaPlastico = leerArchivoPlastico(plasticosFile);
        List<Desechos> listaDesechos = leerArchivoDesechos(desechosFile);
        List<Papel> listaPapel = leerArchivoPapel(papelFile);

        addElementLiquidos(listaLiquidos);
        addElementPlastico(listaPlastico);
        addElementDesechos(listaDesechos);
        addElementPapel(listaPapel);
        //calcularPromedioPrecioLiquidos(listaLiquidos);
        /*addPromedioLiquidos(listaLiquidos);
        addPromedioPlastico(listaPlastico);
        addPromedioPapel(listaPapel);
        addPromedioDesechos(listaDesechos);

        addPromedioPapel(listaPapel); */

        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    private void addElementDesechos(List<Desechos> desechosList) {

        for (Desechos item : desechosList) {

            TableRow row = new TableRow(this);

            TextView cell1 = new TextView(this);
            cell1.setText(item.getMes());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white);

            TextView cell2 = new TextView(this);
            cell2.setText("Desechos Tox");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white);

            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getCantidad())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white);

            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getCantidad())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white);

            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            tableLayout.addView(row);
        }
    }
    private void addElementPapel(List<Papel> papelsList) {

        for (Papel item : papelsList) {
            TableRow row = new TableRow(this);
            TextView cell1 = new TextView(this);
            cell1.setText(String.valueOf((item.getMes())));
            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white);

            TextView cell2 = new TextView(this);
            cell2.setText("Papel");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white);

            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getCantidad())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white);

            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getCantidad())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white);

            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);

            tableLayout.addView(row);
        }
    }
    private void addElementLiquidos(List<Liquidos> liquidosList) {

        for (Liquidos item : liquidosList) {
            TableRow row = new TableRow(this);
            TextView cell1 = new TextView(this);
            cell1.setText(String.valueOf((item.getMes())));

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white);

            TextView cell2 = new TextView(this);
            cell2.setText("Liquidos");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white);

            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getCantidad())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white);

            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getCantidad())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white);

            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            tableLayout.addView(row);
        }
    }

    private void addElementPlastico(List<Plastico> plasticoList) {

        for (Plastico item : plasticoList) {
            TableRow row = new TableRow(this);
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMes());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white);

            TextView cell2 = new TextView(this);
            cell2.setText("Plastico");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white);

            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getCantidad())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white);

            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getCantidad())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white);

            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            tableLayout.addView(row);
        }
    }
    private static List<Liquidos> leerArchivoliquidos(File archivo) {
        List<Liquidos> listaLiquidos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float cantidad = Float.parseFloat(datos[0]);
                String mes = datos[1];
                Liquidos liquidos = new Liquidos(cantidad, mes);
                listaLiquidos.add(liquidos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaLiquidos;
    }

    private static List<Plastico> leerArchivoPlastico(File archivo) {
        List<Plastico> listaPlastico = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float cantidad = Float.parseFloat(datos[0]);
                String mes = datos[1];

                Plastico plastico = new Plastico(cantidad, mes);
                listaPlastico.add(plastico);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPlastico;
    }

    private static List<Desechos> leerArchivoDesechos(File archivo) {
        List<Desechos> listaDesechos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float cantidad = Float.parseFloat(datos[0]);
                String mes = datos[1];

                Desechos desechost = new Desechos(cantidad, mes);
                listaDesechos.add(desechost);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDesechos;
    }

    private static List<Papel> leerArchivoPapel(File archivo) {
        List<Papel> listaPapel = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float cantidad = Float.parseFloat(datos[0]);
                String mes = datos[1];

                Papel papel = new Papel(cantidad, mes);
                listaPapel.add(papel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPapel;
    }
}