package com.example.clase1_listview.models;

import java.io.Serializable;

public class NoteMd implements Serializable {

    private int id;
    private String titulo;
    private String contenido;

    public NoteMd() {
    }

    public NoteMd(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public NoteMd(int id, String titulo, String contenido) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "NoteMd{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }

    public int get_id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
