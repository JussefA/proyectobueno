package com.alejandrolora.seccion_03_recycler_card_view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.alejandrolora.seccion_03_recycler_card_view.adapters.MyAdapter;
import com.alejandrolora.seccion_03_recycler_card_view.R;
import com.alejandrolora.seccion_03_recycler_card_view.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView perfil;

    private List<Movie> movies;

    private RecyclerView mRecyclerView;
    // Puede ser declarado como 'RecyclerView.Adapter' o como nuetra clase adaptador 'MyAdapter'
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int counter = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perfil = findViewById(R.id.imgvw_perfil);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,estudiante.class);
                startActivity(i);
            }
        });

        movies = this.getAllMovies();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        // 1 linea de dif. acabo de build y error en interfaz xk pojo. esto y luego xml con card, textview image

        // Implementamos nuestro OnItemClickListener propio, sobreescribiendo el método que nosotros
        // definimos en el adaptador, y recibiendo los parámetros que necesitamos
        mAdapter = new MyAdapter(movies, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie, int position) {
                //Toast.makeText(MainActivity.this, name + " - " + position, Toast.LENGTH_LONG).show();
                //removeMovie(position);
            }
        });

        // Lo usamos en caso de que sepamos que el layout no va a cambiar de tamaño, mejorando la performance
        mRecyclerView.setHasFixedSize(true);
        // Añade un efecto por defecto, si le pasamos null lo desactivamos por completo
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // Enlazamos el layout manager y adaptor directamente al recycler view
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_name:
                //this.addMovie(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Movie> getAllMovies() {
        return new ArrayList<Movie>() {{
            add(new Movie("Multimetro", R.drawable.multimetro));
            add(new Movie("Osciloscopio", R.drawable.osciloscopio));
            add(new Movie("Generador de señales", R.drawable.generador));
            add(new Movie("Puntas de generador", R.drawable.puntas));
            add(new Movie("Fotometro",R.drawable.fotometro));
            add(new Movie("Fuente de poder", R.drawable.fuente));
            add(new Movie("Fuente de Voltaje",R.drawable.fuentevoltaje));
        }};
    }

//    private void addMovie(int position) {
//        movies.add(position, new Movie("New image " + (++counter), R.drawable.newmovie));
//        // Notificamos de un nuevo item insertado en nuestra colección
//        mAdapter.notifyItemInserted(position);
//        // Hacemos scroll hacia lo posición donde el nuevo elemento se aloja
//        mLayoutManager.scrollToPosition(position);
//    }
//
//    private void removeMovie(int position) {
//        movies.remove(position);
//        // Notificamos de un item borrado en nuestra colección
//        mAdapter.notifyItemRemoved(position);
//    }
}
