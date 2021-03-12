package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.examen.Adapters.AdaptadorEdiciones;
import com.example.examen.Adapters.AdaptadorRevistas;
import com.example.examen.Models.Ediciones;
import com.example.examen.Models.Revistas;
import com.example.examen.WebServices.Asynchtask;
import com.example.examen.WebServices.WebService;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class actEdiciones extends AppCompatActivity implements Asynchtask {
    PlaceHolderView phvEdiciones;
    List<Ediciones> ediciones = new ArrayList<Ediciones>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_ediciones);

        Map<String, String> datos = new HashMap<String, String>();

        phvEdiciones = (PlaceHolderView) findViewById(R.id.phvEdiciones);

        //rclRevistas = findViewById(R.id.rclRevistas);
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php", datos, this, this);
        ws.execute("");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        phvEdiciones.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        JSONArray jArray = new JSONArray(result);
        for(int i=0; i<jArray.length(); i++){
            JSONObject json_data = jArray.getJSONObject(i);
            Ediciones edicion = new Ediciones(
                    json_data.getString("issue_id"),
                    json_data.getString("volume"),
                    json_data.getString("number"),
                    json_data.getString("year"),
                    json_data.getString("date_published"),
                    json_data.getString("title"),
                    json_data.getString("doi"),
                    json_data.getString("cover")
            );
            ediciones.add(edicion);
            phvEdiciones.addView(new AdaptadorEdiciones(edicion,getApplicationContext(), phvEdiciones));
        }
    }
}