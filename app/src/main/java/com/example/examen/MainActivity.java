package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.examen.WebServices.Asynchtask;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> data = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php", data, this, this);
        ws.execute("");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        jsonObject =  new JSONObject(result);
        jsonObject = jsonObject.getJSONObject("Results");
        try {
            String m = "";
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}