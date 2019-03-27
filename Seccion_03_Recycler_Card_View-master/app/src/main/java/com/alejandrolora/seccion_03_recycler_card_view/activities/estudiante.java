package com.alejandrolora.seccion_03_recycler_card_view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.alejandrolora.seccion_03_recycler_card_view.R;
import com.alejandrolora.seccion_03_recycler_card_view.adapters.pedidoAdapter;

import java.util.ArrayList;
import java.util.List;

public class estudiante extends AppCompatActivity {

    Button material;
    private ListView listViewMat;
    List<String> nombresPedido = new ArrayList<String>();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estudiante);

        material = findViewById(R.id.materialbtn);

        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(estudiante.this,MainActivity.class);
                startActivity(i);
            }
        });

        listViewMat = (ListView) findViewById(R.id.listPedido);


        pedidoAdapter pedidoAdapter = new pedidoAdapter(this,R.layout.item_pedido,nombresPedido);
        listViewMat.setAdapter(pedidoAdapter);

    }
}