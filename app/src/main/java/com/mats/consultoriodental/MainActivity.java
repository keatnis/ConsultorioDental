package com.mats.consultoriodental;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText usuario, password;
    Button entrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_ConsultorioDental);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario =  findViewById(R.id.txtUsuario);
        password = findViewById(R.id.txtPwd);
        entrar = findViewById(R.id.btnEntrar);


        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visor=new Intent(getApplicationContext(), Principal.class);
                startActivity(visor);
            }
        });


    }

    public void Login (View view) {
        String usr = usuario.getText().toString();
        String pwd = password.getText().toString();
        if (usr.isEmpty() || pwd.isEmpty()) {
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("Autenticacion");
            msg.setTitle("Faltan Datos");
            msg.setPositiveButton("Ok", null);
            msg.create();
            msg.show();
        } else {
            if (usr.equals("Admi") && pwd.equals("12345")) {
                Intent i = new Intent(this, Principal.class);
                i.putExtra("usuario", usr);
                startActivity(i);
            } else {
                AlertDialog.Builder msg = new AlertDialog.Builder(this);
                msg.setTitle("Autenticacion");
                msg.setMessage("Usuario/contraseña invalidos");
                msg.setPositiveButton("Ok", null);
                msg.create();
                msg.show();
            }

        }
    }
}

