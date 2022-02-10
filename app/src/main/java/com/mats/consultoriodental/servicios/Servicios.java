package com.mats.consultoriodental.servicios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.mats.consultoriodental.Principal;
import com.mats.consultoriodental.R;

public class Servicios extends AppCompatActivity {
 CardView cvAdulto;
 CardView cvNinos;
 CardView cvEstetico;
 ImageButton ibHome;
 ImageButton ibServicios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);
        cvAdulto = findViewById(R.id.cvAdulto);
        cvNinos = findViewById(R.id.cvNinos);
        cvEstetico = findViewById(R.id.cvEstetico);
        ibHome =findViewById(R.id.ibHome);
        ibServicios=findViewById(R.id.ibServicios);

        cvAdulto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor=new Intent(getApplicationContext(), tratamiento_adulto.class);
                startActivity(visor);
            }
        });
        cvNinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor=new Intent(getApplicationContext(), tratamiento_nino.class);
                startActivity(visor);
            }
        });
        cvEstetico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor=new Intent(getApplicationContext(), tratamiento_estetico.class);
                startActivity(visor);
            }
        });
        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor=new Intent(getApplicationContext(), Principal.class);
                startActivity(visor);
            }
        });
        ibServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor=new Intent(getApplicationContext(), Servicios.class);
                startActivity(visor);
            }
        });


    }

}