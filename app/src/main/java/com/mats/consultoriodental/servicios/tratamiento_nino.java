package com.mats.consultoriodental.servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.mats.consultoriodental.Principal;
import com.mats.consultoriodental.R;
import com.mats.consultoriodental.adaptador.Adatratamientoo;
import com.mats.consultoriodental.servicios.Servicios;

public class tratamiento_nino extends AppCompatActivity {
    ImageButton ibHome;
    ImageButton ibServicios;
    ListView lvNino;
    String[][] nino = {{"Limpiezas Dentales", "$935"},
            {"Resina Dental infantiles", "$890"},
            {"Coronas Dentales infantiles", "$1,440"},
            {"Sellador","$490"},
            {"Extracciones infantiles", "$740"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamiento_nino);
        lvNino=(ListView)findViewById(R.id.lvEstetico);
        lvNino.setAdapter(new Adatratamientoo(this,nino));

        ibHome =findViewById(R.id.ibHome);
        ibServicios=findViewById(R.id.ibServicios);

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