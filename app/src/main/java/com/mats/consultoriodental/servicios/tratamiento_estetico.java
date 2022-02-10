package com.mats.consultoriodental.servicios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.mats.consultoriodental.Principal;
import com.mats.consultoriodental.R;
import com.mats.consultoriodental.adaptador.Adatratamientoo;
import com.mats.consultoriodental.servicios.Servicios;

public class tratamiento_estetico extends Activity {
    ImageButton ibHome;
    ImageButton ibServicios;

    ListView lvEstetico;
    String[][] estetico = {{"Brackets tradicionales ","$6,710.00"},
            {"Brackets estéticos", "$13,460"},
            {"Brackets autoligados","$11,500"},
            {"Invisalign ","$25,000"},
            {"Blanqueamiento Dental", "$4,000"},
             {"Carillas Denta", "$5,910"}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamiento_estetico);
        lvEstetico=(ListView)findViewById(R.id.lvEstetico);
        lvEstetico.setAdapter(new Adatratamientoo(this,estetico));

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