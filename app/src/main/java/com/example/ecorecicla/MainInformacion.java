package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainInformacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_informacion);

        File file1 = new File(getFilesDir(), "registroDeUsuarios.txt");
        try {
            FileWriter writer = new FileWriter(file1);
            writer.append("root,root@root.com,toor,TOOR\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file2 = new File(getFilesDir(), "liquidos.txt");
        try {
            FileWriter writer = new FileWriter(file2);
            writer.append("root,root@root.com,toor,TOOR\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file3 = new File(getFilesDir(), "papel.txt");
        try {
            FileWriter writer = new FileWriter(file3);
            writer.append("root,root@root.com,toor,TOOR\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file6 = new File(getFilesDir(), "desechos.txt");
        try {
            FileWriter writer = new FileWriter(file6);
            writer.append("root,root@root.com,toor,TOOR\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file5 = new File(getFilesDir(), "plastico.txt");
        try {
            FileWriter writer = new FileWriter(file5);
            writer.append("root,root@root.com,toor,TOOR\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, activity.class);
        startActivity(intent);
    }
}