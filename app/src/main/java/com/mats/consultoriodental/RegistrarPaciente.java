package com.mats.consultoriodental;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class RegistrarPaciente extends AppCompatActivity {
    Button btGuardar,btRetorno;
    EditText etCodigo,etNombres,etApellidos,etFono,etEdad;
    DAOPaciente objDAO = new DAOPaciente(this);

    EditText efecha,ehora,ehora2;
    private  int dia,mes,ano,hora,minutos;
    CalendarView calendario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_paciente);
        etCodigo = (EditText)findViewById(R.id.etCodigo);
        etNombres = (EditText) findViewById(R.id.etNombres);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etFono = (EditText) findViewById(R.id.etFono);


        efecha=(EditText)findViewById(R.id.etFecha);
        ehora=(EditText)findViewById(R.id.etHora);
        ehora2 =findViewById(R.id.etHora2);

        efecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c= Calendar.getInstance();
                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                ano=c.get(Calendar.YEAR);



                DatePickerDialog datePickerDialog = new DatePickerDialog(RegistrarPaciente.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year ) {
                        efecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                }
                        ,2022,mes,dia);
                datePickerDialog.show();
            }
        });
        ehora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(RegistrarPaciente.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ehora.setText(hourOfDay + ":" + minute);

                    }
                }, hora, minutos, false);
                timePickerDialog.show();
            }
        });
        ehora2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(RegistrarPaciente.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ehora2.setText(hourOfDay + ":" + minute);
                    }
                }, hora, minutos, false);
                timePickerDialog.show();
            }
        });





        btGuardar = (Button) findViewById(R.id.btGuardar);
        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grabar(etNombres.getText().toString(),etApellidos.getText().toString(),Integer.parseInt(etCodigo.getText().toString()),etFono.getText().toString(),efecha.getText().toString(),ehora.getText().toString(),ehora2.getText().toString());
                startActivity(new Intent(RegistrarPaciente.this, Principal.class));


            }
        });

        btRetorno = (Button) findViewById(R.id.btRetorno);
        btRetorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrarPaciente.this, MainActivity.class));
            }
        });

    }

    private void grabar( String nombres, String apellidos,int edad,String telefono,String fecha,String hora1,String hora2) {
        Paciente  objC = new Paciente();

        objC.setNombres(nombres);
        objC.setApellidos(apellidos);
        objC.setEdad(edad);
        objC.setTelefono(telefono);
        objC.setFecha(fecha);
        objC.setHoraInicio(hora1);
        objC.setHoraFinalizacion(hora2);
        objDAO.nuevoCliente(objC);

        Toast.makeText(this, "Cita registrada...!!!",Toast.LENGTH_LONG).show();

    }


}


