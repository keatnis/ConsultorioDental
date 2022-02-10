package com.mats.consultoriodental;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.mats.consultoriodental.servicios.Servicios;

public class Principal extends AppCompatActivity {

    CardView cvagendar;
    CardView cvVer;
    String esto[] = {"Paciente Existente", "Paciente Nuevo"};
    ImageButton ibServicios;
    ImageButton ibHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cvagendar = findViewById(R.id.cvAgendar);
        ibServicios = findViewById(R.id.ibServicios);
        ibHome = findViewById(R.id.ibHome);

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor = new Intent(getApplicationContext(), Principal.class);
                startActivity(visor);
            }
        });


        cvagendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Principal.this);
                builder.setTitle("Elige una opcion")
                        .setItems(esto, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item

                                if (which == 1) {
                                    Intent visor = new Intent(getApplicationContext(), RegistrarPaciente.class);
                                    startActivity(visor);
                                }
                                if(which==0){
                                    Intent visor = new Intent(getApplicationContext(), listado_paciente.class);
                                    startActivity(visor);
                                }

                            }
                        }).create().show();

            }
        });

        ibServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor = new Intent(getApplicationContext(), Servicios.class);
                startActivity(visor);
            }
        });


        cvVer = findViewById(R.id.cvVer);

        cvVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor = new Intent(getApplicationContext(), lista_citas.class);
                startActivity(visor);
            }
        });



    }

}

