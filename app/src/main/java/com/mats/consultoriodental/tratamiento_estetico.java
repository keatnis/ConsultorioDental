package com.mats.consultoriodental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class tratamiento_estetico extends AppCompatActivity {


    ListView lvEstetico;
    String[][] estetico = {{"Brackets tradicionales ","$6,710.00"},
            {"Brackets estéticos", "$13,460", ""},
            {"Brackets autoligados","$11,500"},
            {"Invisalign ","$25,000"},
            {"Blanqueamiento Dental", "$4,000"},
             {"Carillas Denta", "$5,910",}};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamiento_estetico);
        lvEstetico=(ListView)findViewById(R.id.lvAdulto);
        lvEstetico.setAdapter(new Adatratamientoo(this,estetico));

    }
}