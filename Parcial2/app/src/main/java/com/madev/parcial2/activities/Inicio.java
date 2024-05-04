package com.madev.parcial2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.madev.parcial2.R;
import com.madev.parcial2.adaptador.Adaptador;
import com.madev.parcial2.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends AppCompatActivity implements Adaptador.OnItemClickListener{
    RecyclerView rcv_usuarios;
    List<Usuario> listaUsuarios = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        rcv_usuarios = findViewById(R.id.rcv_usuarios);
        Usuario user1 = new Usuario("Rick Sanchez", "https://rickandmortyapi.com/api/character/avatar/172.jpeg", "Human", "Alive");
        Usuario user2 = new Usuario("Morty Smith", "https://rickandmortyapi.com/api/character/avatar/121.jpeg", "Human", "Alive");
        Usuario user3 = new Usuario("Summer Smith", "https://rickandmortyapi.com/api/character/avatar/120.jpeg", "Human", "Alive");
        Usuario user4 = new Usuario("beth Smith", "https://rickandmortyapi.com/api/character/avatar/123.jpeg", "Human", "Alive");
        Usuario user5 = new Usuario("Jerry Smith", "https://rickandmortyapi.com/api/character/avatar/124.jpeg", "Human", "Alive");

        listaUsuarios.add(user1);
        listaUsuarios.add(user2);
        listaUsuarios.add(user3);
        listaUsuarios.add(user4);
        listaUsuarios.add(user5);

        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));
        Adaptador adaptador = new Adaptador(listaUsuarios, this);
        rcv_usuarios.setAdapter(adaptador);
    }
            public void onItemClick(Usuario usuario) {
                Intent i = new Intent(Inicio.this, detalle.class);
                i.putExtra("nombre", usuario.getNombre());
                i.putExtra("especie", usuario.getEspecie());
                i.putExtra("estado", usuario.getEstado());
                startActivity(i);
            }
    }
