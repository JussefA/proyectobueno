package com.alejandrolora.seccion_03_recycler_card_view.models;

public class materialDataModel {


    private String titulo;
    private int imagen;

    public materialDataModel(String titulo, int imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getImagen() { return imagen; }

    public void setImagen(int imagen) { this.imagen = imagen; }

}