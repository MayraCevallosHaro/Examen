package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.examen.Models.Articulos;
import com.example.examen.Models.Ediciones;
import com.example.examen.WebServices.Asynchtask;
import com.example.examen.WebServices.WebService;
import com.example.examen.ui.main.ActArticuloFragment;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class actArticulo extends AppCompatActivity implements Asynchtask {
    PlaceHolderView phvEdiciones;
    List<Articulos> articulos = new ArrayList<Articulos>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_articulo_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ActArticuloFragment.newInstance())
                    .commitNow();
        }

        Map<String, String> datos = new HashMap<String, String>();

        phvEdiciones = (PlaceHolderView) findViewById(R.id.phv);

        //rclRevistas = findViewById(R.id.rclRevistas);
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php", datos, this, this);
        ws.execute("");


    }


    @Override
    public void processFinish(String result) throws JSONException {

    }
}