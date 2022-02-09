package com.mats.consultoriodental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class tratamiento_adulto extends AppCompatActivity {
    ListView lvAdulto;
    String[][] adulto = {{"Limpiezas Dentales", "$770"},
            {"Resina Dental", "$880", ""},
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

    }
}

