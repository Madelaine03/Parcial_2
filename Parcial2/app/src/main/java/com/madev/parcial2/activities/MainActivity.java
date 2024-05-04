package com.madev.parcial2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.madev.parcial2.R;
import com.madev.parcial2.adaptador.Adaptador;
import com.madev.parcial2.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_ingresar;
    EditText edt_usuario, edt_contraseña;

    android.content.SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String dato;
    public static final String dtUser = "dtUser";
    private static final int modo_private = Context.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            edt_usuario = findViewById(R.id.edt_usuario);
            edt_contraseña = findViewById(R.id.edt_contraseña);
            btn_ingresar = findViewById(R.id.btn_ingresar);

            sharedPreferences = getSharedPreferences(dtUser,modo_private);
            editor = sharedPreferences.edit();
            dato = getApplicationContext().getSharedPreferences(dtUser,modo_private).getString("user", "");


            btn_ingresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String usuario = edt_usuario.getText().toString();
                    String contraseña = edt_contraseña.getText().toString();
                    editor.putString("user", edt_usuario.getText().toString());
                    editor.commit();

                    if (!usuario.equals("") && !contraseña.equals("")){
                        Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(MainActivity.this, Inicio.class );
                        startActivity(i);
                        finish();

                    }else {
                        Toast.makeText(MainActivity.this, "Campo vacio, por favor ingresar usuario y contraseña", Toast.LENGTH_LONG).show();

                    }

                }
            });
        }
    }
