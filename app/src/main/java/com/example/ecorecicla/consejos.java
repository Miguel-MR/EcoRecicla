package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;

public class consejos extends AppCompatActivity {
    private int[] imageIds = {R.drawable.dividir,R.drawable.bolsas,R.drawable.contenedores_aceite};
    private String[] cardTiles = {"Depósito","Bolsas plásticas", "Deposito de aceite"};
    private String[] cardDescriptions = {"¿Para qué nos sirven los contenedores de basura?\n" +
            "\n" +
            "Tener un bote de basura tiene muchas ventajas y beneficios, tanto para la salud como para la higiene, algunos de los beneficios son:\n" +
            "Se mantiene un espacio limpio.\n" +
            "Nos mantenemos saludables.\n" +
            "Crea conciencia ambiental.\n" +
            "Debido a los colores de los botes, nos permite clasificar la basura.\n" +
            "Crea una imagen de nuestra persona, ya que denota nuestra educación.",
            "El principal motivo para reciclar el plástico es porque sus residuos tardan entre 100 y 1.000 años en degradarse. El carbón y el plástico del que esté fabricado no se disuelve. Además, si reciclamos el plástico, estaremos consumiendo menos cantidades de materias primas y de recursos naturales y energéticos no renovables. Así evitamos que estos se agoten.",
            "Reciclar el aceite de cocina reduce la contaminación, conserva los recursos y reduce los residuos. Cuando el aceite de cocina se vierte en el medio ambiente, puede contaminar los cursos de agua y dañar la fauna. Al reciclar el aceite de cocina, podemos ayudar a reducir esta contaminación.",};
    private int currentIndex = 0;
    private ImageView imageView;
    private MaterialTextView cardTitle;
    private MaterialTextView cardDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consejos);

        imageView = findViewById(R.id.image_card);
        cardTitle = findViewById(R.id.card_title);
        cardDescription = findViewById(R.id.card_SUBtitle);
        Button buttonSiguiente = findViewById(R.id.button2);
        Button buttonRegresar = findViewById(R.id.buttonRegreso);

        Intent regresarInten = new Intent(this,categorias.class);

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(regresarInten);
            }
        });

        setterInitialValues();
        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accionesBotonSiguiente();
            }
        });
    }
    private void accionesBotonSiguiente() {
        currentIndex--;
        if(currentIndex < 0)
        {
            currentIndex = imageIds.length - 1;
        }
        setterInitialValues();
    }
    protected void setterInitialValues() {
        imageView.setImageResource(imageIds[currentIndex]);
        cardTitle.setText(cardTiles[currentIndex]);
        cardDescription.setText(cardDescriptions[currentIndex]);
    }
}