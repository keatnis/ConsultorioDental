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

public class tratamiento_adulto extends AppCompatActivity {

    ImageButton ibHome;
    ImageButton ibServicios;
    ListView lvAdulto;
    String[][] adulto = {{"Limpiezas Dentales", "$770"},
            {"Resina Dental", "$880"},
            {"Coronas Dentales", "$6,200"},
            {"Endodoncias","$3,900"},
            {"Implantes Dentales","$11,880"},
            {"Extracciones", "$1,070"},
            {"Guarda Oclusal ", "$1,500"},
            {"Puentes Dentales  ", "$17,095"},
            {"Periodoncia", "$2,475"}};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamiento_adulto);
        lvAdulto=(ListView)findViewById(R.id.lvAdulto);
        lvAdulto.setAdapter(new Adatratamientoo(this,adulto));
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

