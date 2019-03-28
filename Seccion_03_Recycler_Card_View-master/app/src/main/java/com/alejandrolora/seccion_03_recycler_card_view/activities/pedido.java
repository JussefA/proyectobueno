package com.alejandrolora.seccion_03_recycler_card_view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.alejandrolora.seccion_03_recycler_card_view.R;
import com.alejandrolora.seccion_03_recycler_card_view.adapters.MyAdapter;
import com.alejandrolora.seccion_03_recycler_card_view.adapters.materialCustomAdapter;
import com.alejandrolora.seccion_03_recycler_card_view.adapters.pedidoAdapter;

import java.util.ArrayList;
import java.util.List;

public class pedido extends AppCompatActivity {
    ImageView perfil;
    Button material;
    Button fin;
    private ListView listViewMat;
    public multimetro multi = new multimetro();
    public osciloscopio osciloscopio = new osciloscopio();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        material = findViewById(R.id.materialbtn);

        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pedido.this,MainActivity.class);
                startActivity(i);
            }
        });

        perfil = findViewById(R.id.imgvw_perfil);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pedido.this,estudiante.class);
                startActivity(i);
            }
        });

        fin = findViewById(R.id.btnFinPedido);

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pedido.this, estudiante.class);
                startActivity(i);
            }
        });

        listViewMat = (ListView) findViewById(R.id.listPedido);






        pedidoAdapter pedidoAdapter = new pedidoAdapter(this,R.layout.item_pedido,multi.getMultimetros());
        listViewMat.setAdapter(pedidoAdapter);
        pedidoAdapter = new  pedidoAdapter(this,R.layout.item_pedido,osciloscopio.getOsciloscopios());
        listViewMat.setAdapter(pedidoAdapter);


    }
}