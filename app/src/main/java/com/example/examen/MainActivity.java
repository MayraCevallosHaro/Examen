package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examen.Adapters.adtRevistas;
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

public class MainActivity extends AppCompatActivity implements Asynchtask {

    List<Revistas> revistas = new ArrayList<Revistas>();
    RecyclerView rclRevistas;
    PlaceHolderView phvRevistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> datos = new HashMap<String, String>();

        phvRevistas = (PlaceHolderView) findViewById(R.id.phvRevistas);

       //rclRevistas = findViewById(R.id.rclRevistas);
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php", datos, this, this);
        ws.execute("");


    }

    @Override
    public void processFinish(String result) throws JSONException {

        phvRevistas.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        JSONArray jArray = new JSONArray(result);
        for(int i=0; i<jArray.length(); i++){
            JSONObject json_data = jArray.getJSONObject(i);
            Revistas revista = new Revistas(
                    json_data.getString("journal_id"),
                    json_data.getString("portada"),
                    json_data.getString("abbreviation"),
                    json_data.getString("description"),
                    json_data.getString("journalThumbnail"),
                    json_data.getString("name")
            );
            revistas.add(revista);
            phvRevistas.addView(new AdaptadorRevistas(revista,getApplicationContext(),phvRevistas));
        }

        // Creando el adaptador de las revistas
        adtRevistas adtRevistas = new adtRevistas(revistas);
        // Colocandolo en la vista
        //rclRevistas.setAdapter(adtRevistas);
        //rclRevistas.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        //rclRevistas.hasFixedSize();


    }
}