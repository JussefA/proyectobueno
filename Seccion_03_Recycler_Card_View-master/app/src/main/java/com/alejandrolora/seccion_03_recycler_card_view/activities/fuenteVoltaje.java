package com.alejandrolora.seccion_03_recycler_card_view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.alejandrolora.seccion_03_recycler_card_view.R;
import com.alejandrolora.seccion_03_recycler_card_view.adapters.materialCustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class fuenteVoltaje extends AppCompatActivity {
    ImageView perfil;

    private ListView listViewMat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuente_voltaje);


        listViewMat = (ListView) findViewById(R.id.listFuenteVoltaje);
        List<String> names = new ArrayList<String>();

        names.add("FV1");
        names.add("FV2");
        names.add("FV3");
        names.add("FV4");

        materialCustomAdapter materialCustomAdapter = new materialCustomAdapter(this, R.layout.item_mult, names);
        listViewMat.setAdapter(materialCustomAdapter);
    }
}