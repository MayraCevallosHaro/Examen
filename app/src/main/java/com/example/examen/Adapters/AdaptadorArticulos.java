package com.example.examen.Adapters;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.examen.Models.Articulos;
import com.example.examen.Models.Ediciones;
import com.example.examen.R;
import com.example.examen.Valores;
import com.example.examen.actArticulo;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.View;

@NonReusable
@Layout(R.layout.lyt_articulos)
public class AdaptadorArticulos {
    @View(R.id.crArticulos)
    CardView cardView;

    @View(R.id.txtTituloArticulo)
    private TextView txtTituloArticulo;

    @View(R.id.txtSeccionArticulo)
    private TextView txtSeccionArticulo;

    @View(R.id.txtFechaArticulo)
    private TextView txtFechaArticulo;

    @View(R.id.txtAutoresArticulos)
    private TextView txtAutoresArticulos;


    private Articulos articulos;
    private Context context;
    private PlaceHolderView placeHolderView;

    public AdaptadorArticulos(Articulos articulos, Context context, PlaceHolderView placeHolderView) {
        this.articulos = articulos;
        this.context = context;
        this.placeHolderView = placeHolderView;
    }


//    @Click(R.id.crArticulos)
//    public void onLongClick() {
//        Intent intent = new Intent(context, actArticulo.class);
//        context.getApplicationContext().startActivity(intent);
//    }
}
