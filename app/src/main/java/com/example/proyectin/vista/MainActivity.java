package com.example.proyectin.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.proyectin.R;
import com.example.proyectin.controlador.swvolly.ServicioWeb;

public class MainActivity extends AppCompatActivity {
    EditText cajaUsername, cajaPassword;
    Button botonAcceder;
    ServicioWeb ServicioWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaUsername = findViewById(R.id.textlogin);
        cajaPassword = findViewById(R.id.textpassword);
        botonAcceder = findViewById(R.id.btnlogin);

        botonAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServicioWeb.login(cajaUsername.getText().toString(), cajaPassword.getText().toString());
            }
        });

    }
}
