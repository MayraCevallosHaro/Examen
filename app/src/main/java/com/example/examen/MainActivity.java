package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.examen.WebServices.Asynchtask;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    List<Revistas> revistas = new ArrayList<Revistas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php", datos, this, this);
        ws.execute("");
    }

    @Override
    public void processFinish(String result) throws JSONException {

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
        }
        String a = "";
    }
}