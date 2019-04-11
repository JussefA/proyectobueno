package com.alejandrolora.seccion_03_recycler_card_view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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

    Button fin;
    private ListView listViewMat;
    public multimetro multi = new multimetro();
    public osciloscopio osciloscopio = new osciloscopio();
    public fotometro fotom = new fotometro();
    public fuentePoder fPoder = new fuentePoder();
    public fuenteVoltaje fVolt = new fuenteVoltaje();
    public generadorSenales generador = new generadorSenales();
    public puntas puntas = new puntas();
    public static ArrayList<String> pedidoTotal = new ArrayList<>();
    public static ArrayList<String> pedidoEstudiante = new ArrayList<>();

    private BottomNavigationView mMainNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);


        fin = findViewById(R.id.btnFinPedido);

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pedido.this, estudiante.class);
                startActivity(i);


                pedidoEstudiante.clear();
                pedidoEstudiante.addAll(pedidoTotal);

            }
        });

        listViewMat =  findViewById(R.id.listPedido);


        pedidoTotal.clear();

        pedidoTotal.addAll(multi.getMultimetros());
        pedidoTotal.addAll(osciloscopio.getOsciloscopios());
        pedidoTotal.addAll(fotom.getFotometros());
        pedidoTotal.addAll(fPoder.getFuentePoder());
        pedidoTotal.addAll(fVolt.getFuenteVoltaje());
        pedidoTotal.addAll(generador.getGeneradorSenales());
        pedidoTotal.addAll(puntas.getPuntas());



        pedidoAdapter pedidoAdapter = new pedidoAdapter(this,R.layout.item_pedido,pedidoTotal);
        listViewMat.setAdapter(pedidoAdapter);


        mMainNav = findViewById(R.id.main_nav);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.nav_material :
                        mMainNav.setItemBackgroundResource(R.color.Morado);
                        Intent a = new Intent(pedido.this,MainActivity.class);
                        startActivity(a);
                        return true;

                    case R.id.nav_pedido :
                        mMainNav.setItemBackgroundResource(R.color.Azul);

                        return true;

                    case R.id.nav_persona:
                        mMainNav.setItemBackgroundResource(R.color.AzulClaro);
                        Intent i = new Intent(pedido.this,estudiante.class);
                        startActivity(i);
                        return true;

                    default :
                        return false;

                }
            }
        });

    }

    public ArrayList<String> getPedidoTotal (){
        return pedidoEstudiante;
    }
}