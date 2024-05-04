package com.madev.parcial2.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.madev.parcial2.R;
import com.madev.parcial2.clases.Usuario;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private List<Usuario> datos;
    private OnItemClickListener listener;

    public void setOnClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Usuario usuario);
    }

    public Adaptador(List<Usuario> datos, OnItemClickListener listener) {
        this.datos = datos;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Usuario dato = datos.get(position);
        holder.bind(dato);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(dato);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_usuario;
        TextView txt_nombre, txt_estado, txt_especie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nombre = itemView.findViewById(R.id.txt_nombre);
            txt_estado = itemView.findViewById(R.id.txt_estado);
            txt_especie = itemView.findViewById(R.id.txt_especie);
            img_usuario = itemView.findViewById(R.id.img_usuario);
        }

        public void bind(Usuario dato) {
            txt_nombre.setText(dato.getNombre());
            txt_estado.setText(dato.getEstado());
            txt_especie.setText(dato.getEspecie());
            Picasso.get().load(dato.getImagen()).into(img_usuario);
        }

    }
}
