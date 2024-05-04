package com.madev.parcial2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.madev.parcial2.R;

public class detalle extends AppCompatActivity {
    Button btn_cerrar;
    String dato;
    public static final String dtUser = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        btn_cerrar = findViewById(R.id.btn_cerrar);
        dato = getApplicationContext().getSharedPreferences(dtUser,modo_private).getString("user", "");

        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        String especie = i.getStringExtra("especie");
        String estado = i.getStringExtra("estado");

        TextView txtNombre = findViewById(R.id.txt_nombre);
        TextView txtEspecie = findViewById(R.id.txt_especie);
        TextView txtEstado = findViewById(R.id.txt_estado);

        txtNombre.setText(nombre);
        txtEspecie.setText(especie);
        txtEstado.setText(estado);

        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences configuration = getApplicationContext().getSharedPreferences(dtUser,modo_private);
                configuration.edit().clear().commit();
                Intent i = new Intent(detalle.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }


}