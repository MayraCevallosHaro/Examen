package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.examen.ui.main.ActArticuloFragment;

public class actArticulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_articulo_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ActArticuloFragment.newInstance())
                    .commitNow();
        }
    }
}