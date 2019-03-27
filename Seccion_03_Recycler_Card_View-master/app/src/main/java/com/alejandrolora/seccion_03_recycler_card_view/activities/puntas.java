package com.alejandrolora.seccion_03_recycler_card_view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.alejandrolora.seccion_03_recycler_card_view.R;
import com.alejandrolora.seccion_03_recycler_card_view.adapters.materialCustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class puntas extends AppCompatActivity {
    ImageView perfil;
    Button material;

    private ListView listViewMat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntas);

        material = findViewById(R.id.materialbtn);

        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(puntas.this,MainActivity.class);
                startActivity(i);
            }
        });

        perfil = findViewById(R.id.imgvw_perfil);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(puntas.this,estudiante.class);
                startActivity(i);
            }
        });


        listViewMat = (ListView) findViewById(R.id.listPuntas);
        List<String> names = new ArrayList<String>();

        names.add("Pn1");
        names.add("Pn2");
        names.add("Pn3");
        names.add("Pn4");

        materialCustomAdapter materialCustomAdapter = new materialCustomAdapter(this, R.layout.item_mult, names);
        listViewMat.setAdapter(materialCustomAdapter);
    }
}