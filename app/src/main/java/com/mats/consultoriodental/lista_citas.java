package com.mats.consultoriodental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;



import java.util.ArrayList;

public class lista_citas extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView txtBuscar;
    RecyclerView listaContactos;
    ArrayList<Paciente> listaArrayContactos;

    ListaContactosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_citas);
        txtBuscar = findViewById(R.id.txtBuscar);
        listaContactos = findViewById(R.id.listadoPacientes);
        listaContactos.setLayoutManager(new LinearLayoutManager(this));

        DAOPaciente dbContactos = new DAOPaciente(lista_citas.this);

        listaArrayContactos = new ArrayList<>();

        adapter = new ListaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);




        txtBuscar.setOnQueryTextListener(this);
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