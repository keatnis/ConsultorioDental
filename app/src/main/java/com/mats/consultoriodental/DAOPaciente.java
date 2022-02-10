package com.mats.consultoriodental;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


    public class DAOPaciente extends SQLiteOpenHelper {
        //definicion de la base de datos Ventas y la tabla cliente
        private static final String base = "CLINICA";
        private static final int version = 2;
        private static final String tabla = "PACIENTE";



        private static final String nom_cli = "NOM_CLI";
        private static final String ape_cli = "APE_CLI";
        private static final String fon_cli = "FON_CLI";
        private static final String fecha ="FECHA_CITA";
        private static final String hora1 ="HORA_INICIO";
        private static final String hora2 ="HORA_FINAL";
        private static final String edad ="EDAD_CLI";



        public DAOPaciente( Context context) {
            super(context, base, null, version);
        }
//METODO PARA CREAR la tabla cliente


        @Override
        public void onCreate(SQLiteDatabase db) {

            String SQL = "CREATE TABLE " + tabla + "( id INTEGER  PRIMARY KEY  AUTOINCREMENT, NOM_CLI TEXT , APE_CLI TEXT,EDAD_CLI INTEGER,FON_CLI TEXT,FECHA_CITA TEXT,HORA_INICIO TEXT,HORA_FINAL TEXT )";
            db.execSQL(SQL);
        }
        //metodo que valida la existencia de la tabla clinte

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists "+ tabla);

            onCreate(db);
        }

        //metodo para agregar un cliente
        public long nuevoCliente(Paciente objC) {
            long id = 0;
            try {
            //obtener los valores a registrar
            ContentValues values = new ContentValues();

            values.put(nom_cli, objC.getNombres());
            values.put(ape_cli, objC.getApellidos());
            values.put(edad, objC.getEdad());
            values.put(fon_cli, objC.getTelefono());
            values.put(fecha, objC.getFecha());
            values.put(hora1, objC.getHoraInicio());
            values.put(hora2, objC.getHoraFinalizacion());

            //ejecutar el metodo insert
            SQLiteDatabase db = this.getWritableDatabase();
            id = db.insert(tabla,null,values);
            //cerrar la conexion
                db.close();
            } catch (Exception ex) {
                ex.toString();

            }

            return id;
        }

        //metodo para listar los clientes
        public ArrayList listaClientes() {
            ArrayList listaClientes = new ArrayList();
            SQLiteDatabase db = getWritableDatabase();

            //aplicar la sentencia de seleccion de registros de clientes
            String SQL = " SELECT * FROM  " + tabla;
            Cursor c = db.rawQuery(SQL, null);

            //concatenar la informacion obtenida de la DB
            if (c.moveToFirst()) {
                do {
                    listaClientes.add(c.getInt(0) + " " + c.getString(1) + " "
                            + c.getString(2) + " " + c.getString(3)+" "+c.getString(4)+" "+c.getString(5)+" "+c.getString(6)+"");
                } while (c.moveToNext());
            }
            return listaClientes;
        }

        //metodo para actualizar un ciente
        public void actualizaCliente(Paciente objC) {
            //obtener informacion del cliente a modificar
            int cod = objC.getEdad();
            String nom = objC.getNombres();
            String ape = objC.getApellidos();
            String tel = objC.getTelefono();

            //ejecutando la sentencia UPDATE
            SQLiteDatabase db =getWritableDatabase();
            db.execSQL("UPDATE CLIENTE SET FECHA_CITA='"+nom+"', APE_CLI='"+ape+"', FON_CLI='"+tel+"' where id='"+cod+"'");

            db.close();
        }
        //metodo para eliminar un registro del cliente
        public boolean eliminarCliente(Paciente objC){
            //obtener el codigo del cliente a eliminar
            //(PAciente objC)
             int cod=objC.getId();

            //ejecutando la sentecnica DELETE
            SQLiteDatabase db =getWritableDatabase();
            db.execSQL("delete from cliente where id="+cod);
            db.close();
            return false;
        }


        public ArrayList<Paciente> mostrarContactos() {


            SQLiteDatabase db = getWritableDatabase();

            ArrayList<Paciente> listaContactos = new ArrayList<>();
            Paciente contacto;
            Cursor cursorContactos;

            cursorContactos = db.rawQuery("SELECT * FROM " + tabla , null);

            if (cursorContactos.moveToFirst()) {
                do {
                    contacto = new Paciente();
                    contacto.setId(cursorContactos.getInt(0));
                    contacto.setNombres(cursorContactos.getString(1));
                    contacto.setApellidos(cursorContactos.getString(2));
                    contacto.setEdad(cursorContactos.getInt(3));
                    contacto.setTelefono(cursorContactos.getString(4));
                    contacto.setFecha(cursorContactos.getString(5));
                    contacto.setHoraInicio(cursorContactos.getString(6));
                    contacto.setHoraFinalizacion(cursorContactos.getString(7));

                    listaContactos.add(contacto);
                } while (cursorContactos.moveToNext());
            }

            cursorContactos.close();

            return listaContactos;
        }
        public Paciente verContacto(int id) {


            SQLiteDatabase db = getWritableDatabase();

            Paciente contacto = null;
            Cursor cursorContactos;

            cursorContactos = db.rawQuery("SELECT NOM_CLI,APE_CLI,FECHA_CITA  FROM " +tabla+ " WHERE id = " + id + " LIMIT 1", null);

            if (cursorContactos.moveToFirst()) {


                contacto.setNombres(cursorContactos.getString(0));
                contacto.setApellidos(cursorContactos.getString(1));
                contacto.setFecha(cursorContactos.getString(2));


            }

            cursorContactos.close();

            return contacto;
        }

    }


