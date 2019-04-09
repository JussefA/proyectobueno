package com.alejandrolora.seccion_03_recycler_card_view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import com.alejandrolora.seccion_03_recycler_card_view.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;

public class entrar extends AppCompatActivity {

    Button entrar;
    private KenBurnsView kbv;
    private boolean moving = true;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrar);

        kbv = findViewById(R.id.kvb);

        AccelerateDecelerateInterpolator adi = new AccelerateDecelerateInterpolator();
        RandomTransitionGenerator generator = new RandomTransitionGenerator(2000,adi);
        kbv.setTransitionGenerator(generator);
        kbv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moving){
                    kbv.pause();
                    moving = false;
                } else{
                   kbv.resume();
                   moving = true;
                }
            }
        });

        entrar = findViewById(R.id.entrarbtn);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(entrar.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
