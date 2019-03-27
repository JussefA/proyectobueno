package com.alejandrolora.seccion_03_recycler_card_view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alejandrolora.seccion_03_recycler_card_view.R;
import com.alejandrolora.seccion_03_recycler_card_view.activities.cautin;
import com.alejandrolora.seccion_03_recycler_card_view.activities.fotometro;
import com.alejandrolora.seccion_03_recycler_card_view.activities.fuentePoder;
import com.alejandrolora.seccion_03_recycler_card_view.activities.fuenteVoltaje;
import com.alejandrolora.seccion_03_recycler_card_view.activities.generadorSenales;
import com.alejandrolora.seccion_03_recycler_card_view.activities.multimetro;
import com.alejandrolora.seccion_03_recycler_card_view.activities.osciloscopio;
import com.alejandrolora.seccion_03_recycler_card_view.activities.puntas;
import com.alejandrolora.seccion_03_recycler_card_view.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Alejandro on 3/9/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Movie> movies;
    private int layout;
    private OnItemClickListener itemClickListener;

    private Context context;


    public MyAdapter(List<Movie> movies, int layout, OnItemClickListener listener) {
        this.movies = movies;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout y se lo pasamos al constructor del ViewHolder, donde manejaremos
        // toda la lógica como extraer los datos, referencias...
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Llamamos al método Bind del ViewHolder pasándole objeto y listener
        holder.bind(movies.get(position), itemClickListener);

        switch (position){

            case 0:
                holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context,multimetro.class);
                        context.startActivity(i);
                    }
                });
                break;
            case 1:
                holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context,osciloscopio.class);
                        context.startActivity(i);
                    }
                });
                break;

            case 2:
                holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context,generadorSenales.class);
                        context.startActivity(i);
                    }
                });
                break;
            case 3:
                holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context,puntas.class);
                        context.startActivity(i);
                    }
                });
                break;
            case 4:
                holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context,fotometro.class);
                        context.startActivity(i);
                    }
                });
                break;

            case 5:
                holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context,fuentePoder.class);
                        context.startActivity(i);
                    }
                });
                break;
            case 6:
                holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context,cautin.class);
                        context.startActivity(i);
                    }
                });
                break;
            case 7:
                holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context,fuenteVoltaje.class);
                        context.startActivity(i);
                    }
                });
                break;

        }

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Elementos UI a rellenar
        public TextView textViewName;
        public ImageView imageViewPoster;
        public RelativeLayout parentLayout;
        public ViewHolder(View itemView) {
            // Recibe la View completa. La pasa al constructor padre y enlazamos referencias UI
            // con nuestras propiedades ViewHolder declaradas justo arriba.
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewTitle);
            imageViewPoster = (ImageView) itemView.findViewById(R.id.imageViewPoster);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }

        public void bind(final Movie movie, final OnItemClickListener listener) {
            // Procesamos los datos a renderizar
            textViewName.setText(movie.getName());
            Picasso.with(context).load(movie.getPoster()).fit().into(imageViewPoster);
            // imageViewPoster.setImageResource(movie.getPoster());
            // Definimos que por cada elemento de nuestro recycler view, tenemos un click listener
            // que se comporta de la siguiente manera...
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(movie, getAdapterPosition());
                }
            });
        }
    }

    // Declaramos nuestra interfaz con el/los método/s a implementar
    public interface OnItemClickListener {
        void onItemClick(Movie movie, int position);
    }


}

