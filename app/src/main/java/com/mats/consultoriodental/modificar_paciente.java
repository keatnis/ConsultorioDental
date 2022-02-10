package com.mats.consultoriodental;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;


public class modificar_paciente extends AppCompatActivity {

    Button btRetorna;
    FloatingActionButton btActualizar, btEliminar;
    EditText etCodigo, etNombres, etApellidos, etFono, etFecha, etHora, etHora2;
    DAOPaciente objDAO;
    private int dia, mes, ano, hora, minutos;

    int cod;
    String nom, ape, tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_paciente);

        btRetorna = (Button) findViewById(R.id.btRetorna);
        btEliminar = (FloatingActionButton) findViewById(R.id.btEliminar);
        btRetorna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(modificar_paciente.this, MainActivity.class));
            }
        });

        Bundle b = getIntent().getExtras();
        if (b != null) {
            cod = b.getInt("ID");
            nom = b.getString("NOM_CLI");
            ape = b.getString("APE_CLI");
            tel = b.getString("FON_CLI");

        }
        etCodigo = (EditText) findViewById(R.id.etCod);
        etNombres = (EditText) findViewById(R.id.etNombre);
        etApellidos = (EditText) findViewById(R.id.etApellido);
        etFono = (EditText) findViewById(R.id.etTelefono);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etHora = (EditText) findViewById(R.id.etHora);
        etHora2 = (EditText) findViewById(R.id.etHora2);

        etCodigo.setText("" + cod);
        etNombres.setText(nom);
        etApellidos.setText(ape);
        etFono.setText(tel);

  btEliminar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          AlertDialog.Builder builder = new AlertDialog.Builder(modificar_paciente.this);
          builder.setMessage("¿Desea eliminar esta cita del paciente?")
                  .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {
                          eliminar(cod);
                          Intent intent = new Intent(modificar_paciente.this, listado_paciente.class);
                          startActivity(intent);

                      }
                  })
                  .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                      }
                  }).show();
      }
  });
        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                dia = c.get(Calendar.DAY_OF_MONTH);
                mes = c.get(Calendar.MONTH);
                ano = c.get(Calendar.YEAR);


                DatePickerDialog datePickerDialog = new DatePickerDialog(modificar_paciente.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                        etFecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }
                        , 2022, mes, dia);
                datePickerDialog.show();
            }
        });
        etHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(modificar_paciente.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etHora.setText(hourOfDay + ":" + minute + " Hrs.");

                    }
                }, hora, minutos, false);
                timePickerDialog.show();
            }
        });
        etHora2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(modificar_paciente.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etHora2.setText(hourOfDay + ":" + minute + " Hrs");
                    }
                }, hora, minutos, false);
                timePickerDialog.show();
            }
        });


        //invocacion del metodo de actualizacion
        btActualizar = (FloatingActionButton) findViewById(R.id.btActualizar);
        btActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificar(Integer.parseInt(etCodigo.getText().toString()), etNombres.getText().toString(), etApellidos.getText().toString(), 11, etFono.getText().toString(), etFecha.getText().toString(), etHora.getText().toString(), etHora2.getText().toString());
            }
        });

        btEliminar = findViewById(R.id.btEliminar);
        btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar(cod);
            }
        });


    }

    private void modificar(int id, String nombres, String apellidos, int edad, String telefono, String fecha, String hora1, String hora2) {

        //enviar los datos del cliente a un objeto
        Paciente objC = new Paciente();
        objC.setId(id);
        objC.setNombres(nombres);
        objC.setApellidos(apellidos);
        objC.setEdad(edad);
        objC.setTelefono(telefono);
        objC.setFecha(fecha);
        objC.setHoraInicio(hora1);
        objC.setHoraFinalizacion(hora2);


        //invocar al metodo actualiza cliente de DAOcliente
        new DAOPaciente(this).nuevoCliente(objC);
        Toast.makeText(this, "Cita guardada correctamente", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(modificar_paciente.this, listado_paciente.class));

    }


    //metodo para eliminar un cliente
    public void eliminar(int codigo) {
        //evnviar el codigo del cliente a un objeto
        Paciente objC = new Paciente();
        objC.setId(codigo);

        //invocar metodo elimiar cliente de DAOCliente
        new DAOPaciente(this).eliminarCliente(objC);
        Toast.makeText(this, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(modificar_paciente.this, listado_paciente.class));

    }




}