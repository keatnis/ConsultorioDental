package com.mats.consultoriodental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class tratamiento_nino extends AppCompatActivity {

    ListView lvNino;
    String[][] nino = {{"Limpiezas Dentales", "$935"},
            {"Resina Dental infantiles", "$890", ""},
            {"Coronas Dentales infantiles", "$1,440"},
            {"Sellador","$490"},
            {"Extracciones infantiles", "$740",}};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamiento_nino);
        lvNino=(ListView)findViewById(R.id.lvAdulto);
        lvNino.setAdapter(new Adatratamientoo(this,nino));

    }
}