package com.alejandrolora.seccion_03_recycler_card_view.models;

public class materialDataModel {


    private String titulo;
    private String etiqueta;

    public materialDataModel(String titulo, String etiqueta) {
        this.titulo = titulo;
        this.etiqueta = etiqueta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}