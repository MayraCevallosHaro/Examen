package com.example.examen.Adapters;

import com.example.examen.R;
import com.example.examen.Models.Revistas;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class adtRevistas extends RecyclerView.Adapter<adtRevistas.ViewHolder> implements View.OnClickListener{
    private List<Revistas> datos;
    // Constructor de la clase
    public adtRevistas(List<Revistas> info) {this.datos = info;}

    private View.OnClickListener listener;

    @NonNull
    @Override
    public adtRevistas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lyt_tarjetarevista,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adtRevistas.ViewHolder holder, int position) {
        holder.asignar_datos(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTituloRevista, txtDescripcionRevista;
        ImageView imgRevista;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTituloRevista = (TextView) itemView.findViewById(R.id.txtTituloRevista);
            txtDescripcionRevista = (TextView) itemView.findViewById(R.id.txtDescripcionRevista);
            imgRevista = (ImageView) itemView.findViewById(R.id.imgRevista);
        }

        public void asignar_datos(Revistas valor) {
            txtTituloRevista.setText(valor.getName());
            txtDescripcionRevista.setText(valor.getDescription());
            Glide.with(itemView).load(valor.getPortada()).centerCrop().into(imgRevista);
        }
}
}
