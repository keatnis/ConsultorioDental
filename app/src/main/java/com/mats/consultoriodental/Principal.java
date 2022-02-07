package com.mats.consultoriodental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {

    CardView cvagendar;
    CardView cvVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


         cvagendar =findViewById(R.id.cvAgendar);

         cvagendar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent visor=new Intent(getApplicationContext(), RegistrarCita.class);
                 startActivity(visor);
             }
         });

        cvVer =findViewById(R.id.cvVer);

        cvVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor=new Intent(getApplicationContext(), lista_citas.class);
                startActivity(visor);
            }
        });



    }
}