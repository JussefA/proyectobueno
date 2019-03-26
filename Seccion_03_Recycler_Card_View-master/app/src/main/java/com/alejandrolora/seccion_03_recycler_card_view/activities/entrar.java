package com.alejandrolora.seccion_03_recycler_card_view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alejandrolora.seccion_03_recycler_card_view.R;

public class entrar extends AppCompatActivity {

    Button entrar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrar);

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
