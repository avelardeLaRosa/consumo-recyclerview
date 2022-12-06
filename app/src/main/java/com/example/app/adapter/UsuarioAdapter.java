package com.example.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.R;
import com.example.app.model.Usuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.ViewHolder> {


    private List<Usuario> usuarios;
    private Context context;

    public UsuarioAdapter(List<Usuario> usuarios, Context context) {
        this.usuarios = usuarios;
        this.context = context;
    }

    @NonNull
    @Override
    public UsuarioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuarios,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.ViewHolder holder, int position) {
        holder.tx_nombre_apellido.setText(usuarios.get(position).getNombre() + " " + usuarios.get(position).getApellido());
        holder.tx_edad.setText(usuarios.get(position).getEdad());
        holder.tx_email.setText(usuarios.get(position).getUsuario());
        Glide.with(context).load(usuarios.get(position).getImg_url()).into(holder.img_usuario);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_usuario;
        private TextView tx_nombre_apellido;
        private TextView tx_email;

        private TextView tx_edad;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            img_usuario = itemView.findViewById(R.id.img_usuario);
            tx_nombre_apellido = itemView.findViewById(R.id.tx_nombre_apellido);
            tx_edad = itemView.findViewById(R.id.tx_edad);
            tx_email = itemView.findViewById(R.id.tx_usuario);


        }

    }
}
