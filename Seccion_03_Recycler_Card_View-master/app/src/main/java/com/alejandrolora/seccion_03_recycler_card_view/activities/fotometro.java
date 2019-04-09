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
import com.alejandrolora.seccion_03_recycler_card_view.adapters.materialCustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class fotometro extends AppCompatActivity {
    ImageView perfil;
    Button material;
    String pedido;
    static ArrayList  <String> pedidoFotometro = new ArrayList<String>();

    private ListView listViewMat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fotometro);

        material = findViewById(R.id.materialbtn);

        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(fotometro.this,MainActivity.class);
                startActivity(i);
            }
        });

        perfil = findViewById(R.id.imgvw_perfil);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(fotometro.this,estudiante.class);
                startActivity(i);
            }
        });


        listViewMat = (ListView) findViewById(R.id.listFotometro);
        final ArrayList<String> names = new ArrayList<String>();
        final ArrayList<String> etiqueta = new ArrayList<String>();


        names.add("F1");
        names.add("F2");
        names.add("F3");
        names.add("F4");

        etiqueta.add("Disponible");
        etiqueta.add("No disponble");
        etiqueta.add("Disponible");
        etiqueta.add("No Disponible");


        materialCustomAdapter materialCustomAdapter = new materialCustomAdapter(this, R.layout.item_mult, names, etiqueta);
        listViewMat.setAdapter(materialCustomAdapter);

        listViewMat.setClickable(true);

        listViewMat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        pedido = names.get(0);
                        Toast.makeText(fotometro.this,"Seleccionaste el " + pedido, Toast.LENGTH_LONG).show();
                        pedidoFotometro.add(pedido);
                        break;

                    case 1:
                        pedido = names.get(1);
                        Toast.makeText(fotometro.this,"Seleccionaste el " + pedido, Toast.LENGTH_LONG).show();
                        pedidoFotometro.add(pedido);
                        break;
                    case 2:
                        pedido = names.get(2);
                        Toast.makeText(fotometro.this,"Seleccionaste el " + pedido, Toast.LENGTH_LONG).show();
                        pedidoFotometro.add(pedido);
                        break;
                    case 3:
                        pedido = names.get(3);
                        Toast.makeText(fotometro.this,"Seleccionaste el  " + pedido, Toast.LENGTH_LONG).show();
                        pedidoFotometro.add(pedido);
                        break;
                }

            }
        });
    }

    public ArrayList<String> getFotometros (){
        return pedidoFotometro;

    }
}