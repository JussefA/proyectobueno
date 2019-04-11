package com.alejandrolora.seccion_03_recycler_card_view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.alejandrolora.seccion_03_recycler_card_view.R;
import com.alejandrolora.seccion_03_recycler_card_view.adapters.pedidoAdapter;

import java.util.ArrayList;
import java.util.List;

public class estudiante extends AppCompatActivity {

    Button material;
    private ListView listViewMat;
    List<String> nombresPedido = new ArrayList<>();

    private BottomNavigationView mMainNav;


    public pedido pedido = new pedido();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estudiante);


        listViewMat = findViewById(R.id.listPedidoFin);

        mMainNav = findViewById(R.id.main_nav);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.nav_material :
                        mMainNav.setItemBackgroundResource(R.color.Morado);
                        Intent a = new Intent(estudiante.this,MainActivity.class);
                        startActivity(a);
                        return true;

                    case R.id.nav_pedido :
                        mMainNav.setItemBackgroundResource(R.color.Azul);
                        Intent i = new Intent(estudiante.this,pedido.class);
                        startActivity(i);
                        return true;

                    case R.id.nav_persona:
                        mMainNav.setItemBackgroundResource(R.color.AzulClaro);
                        return true;

                    default :
                        return false;

                }
            }
        });

    }



    protected void onResume () {
        super.onResume();

        nombresPedido.clear();

        nombresPedido.addAll(pedido.getPedidoTotal());

        pedidoAdapter pedidoAdapter = new pedidoAdapter(this,R.layout.item_pedido,nombresPedido);
        listViewMat.setAdapter(pedidoAdapter);

    }



}