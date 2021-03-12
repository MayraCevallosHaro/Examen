package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.examen.Adapters.AdaptadorArticulos;
import com.example.examen.Adapters.AdaptadorEdiciones;
import com.example.examen.Models.Articulos;
import com.example.examen.Models.Ediciones;
import com.example.examen.WebServices.Asynchtask;
import com.example.examen.WebServices.WebService;
import com.example.examen.ui.main.ActArticuloFragment;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class actArticulo extends AppCompatActivity implements Asynchtask {
    PlaceHolderView phvArticulos;
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

        phvArticulos = (PlaceHolderView) findViewById(R.id.phvArticulos);

        //rclRevistas = findViewById(R.id.rclRevistas);
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php", datos, this, this);
        ws.execute("");
    }


    @Override
    public void processFinish(String result) throws JSONException {
        phvArticulos.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        JSONArray jArray = new JSONArray(result);
        for(int i=0; i<jArray.length(); i++){
            JSONObject json_data = jArray.getJSONObject(i);
            Articulos.Galeys gals = (Articulos.Galeys) json_data.get("galeys");
            Articulos.Authors auth = (Articulos.Authors) json_data.get("authors");
            Articulos articulo = new Articulos(
                    json_data.getString("section"),
                    json_data.getString("publication_id"),
                    json_data.getString("title"),
                    json_data.getString("date_published"),
                    gals, auth
            );
            articulos.add(articulo);
            phvArticulos.addView(new AdaptadorArticulos(articulo,getApplicationContext(), phvArticulos));
        
    }
}
}