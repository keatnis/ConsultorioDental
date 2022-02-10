package com.mats.consultoriodental;

import java.sql.Time;
import java.util.Date;

public class Paciente {
   private  int id;
    private String nombres;
    private String apellidos;
    private String telefono;
    private int edad;
    private String fecha;
    private String horaInicio;
    private String horaFinalizacion;



    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public void setHoraFinalizacion(String horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}