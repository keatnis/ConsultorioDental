package com.mats.consultoriodental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mats.consultoriodental.adaptador.ListaContactosAdapter;

import java.util.ArrayList;

public class listado_paciente extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView txtBuscar;
    RecyclerView listaContactos;
    ArrayList<Paciente> listaArrayContactos;
    FloatingActionButton btRetornar;


    ListaContactosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_paciente);
        txtBuscar = findViewById(R.id.txtBuscar);
        listaContactos = findViewById(R.id.listadoPacientes);

        listaContactos.setLayoutManager(new LinearLayoutManager(this));


        DAOPaciente dbContactos = new DAOPaciente(listado_paciente.this);

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
        adapter.filtrado2(newText);
        return false;
    }
}