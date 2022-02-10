package com.mats.consultoriodental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;


import com.mats.consultoriodental.adaptador.ListaContactosAdapter;

import java.util.ArrayList;

public class lista_citas extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView txtBuscar;
    RecyclerView listaContactos;
    ArrayList<Paciente> listaArrayContactos;

    ListaContactosAdapter adapter;
    Button btRetornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_citas);
        txtBuscar = findViewById(R.id.txtBuscar);
        listaContactos = findViewById(R.id.listadoPacientes);
        listaContactos.setLayoutManager(new LinearLayoutManager(this));
        btRetornar =findViewById(R.id.btReturn);

        DAOPaciente dbContactos = new DAOPaciente(lista_citas.this);

        listaArrayContactos = new ArrayList<>();
        adapter = new ListaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);
        txtBuscar.setOnQueryTextListener(this);

        btRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor=new Intent(lista_citas.this, Principal.class);
                startActivity(visor);
            }
        });

    }
    public void clicRetorno(){

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filtrado(newText);
        return false;
    }
}