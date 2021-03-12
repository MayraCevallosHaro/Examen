package com.example.examen;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examen.Models.Revistas;
import com.example.examen.R;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.List;
@NonReusable
@Layout(R.layout.lyt_tarjetarevista)
public class AdaptadorRevistas {
    @View(R.id.imgRevista)
    private ImageView imgRevista;

    @View(R.id.txtTituloRevista)
    private TextView txtnombre;

    @View(R.id.txtDescripcionRevista)
    private TextView txtdesc;



    private Revistas revistas;
    private Context context;
    private PlaceHolderView placeHolderView;

    public AdaptadorRevistas(Revistas revistas, Context context, PlaceHolderView placeHolderView) {
        this.revistas = revistas;
        this.context = context;
        this.placeHolderView = placeHolderView;
    }


    @Resolve
    private void onResolve(){
        txtnombre.setText(revistas.getName());
        txtdesc.setText(revistas.getDescription());
        Glide.with(context).load(revistas.getPortada()).centerCrop().into(imgRevista);
    }
}
