package com.example.examen.Adapters;


import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.examen.Models.Ediciones;
import com.example.examen.R;
import com.example.examen.Valores;
import com.example.examen.actArticulo;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@NonReusable
@Layout(R.layout.lyt_ediciones)
public class AdaptadorEdiciones {

    @View(R.id.card_viewEdiciones)
    CardView cardView;

    @View(R.id.imgEdicion)
    private ImageView imgEdicion;

    @View(R.id.txtNomEdicion)
    private TextView txtNomEdicion;

    @View(R.id.txtVolEdi)
    private TextView txtVolEdi;

    @View(R.id.txtNumEdi)
    private TextView txtNumEdi;

    @View(R.id.txtAnioEdi)
    private TextView txtAnioEdi;


    private Ediciones ediciones;
    private Context context;
    private PlaceHolderView placeHolderView;

    public AdaptadorEdiciones(Ediciones ediciones, Context context, PlaceHolderView placeHolderView) {
        this.ediciones = ediciones;
        this.context = context;
        this.placeHolderView = placeHolderView;
    }


    @Resolve
    private void onResolved(){
        Glide.with(context).load(ediciones.getCover()).centerCrop().into(imgEdicion);
        txtNomEdicion.setText(ediciones.getTitle());
        txtVolEdi.setText(ediciones.getVolume());
        txtNumEdi.setText(ediciones.getNumber());
        txtAnioEdi.setText(ediciones.getYear());
    }

    @Click(R.id.card_viewEdiciones)
    public void onLongClick() {
        Intent intent = new Intent(context, actArticulo.class);
        Valores.EDICION_SELECCIONADA = ediciones.getIssue_id();
        context.getApplicationContext().startActivity(intent);
    }

}
