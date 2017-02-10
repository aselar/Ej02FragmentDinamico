package com.android.asel.ej01listfragmentweb;

/**
 * Created by aselr on 02/02/2017.
 */

public class TutorialAndroid {

    private String titulo;
    private String enlaceContenido;

    public TutorialAndroid(String titulo, String enlaceContenido) {
        this.titulo = titulo;
        this.enlaceContenido = enlaceContenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEnlaceContenido() {
        return enlaceContenido;
    }

    public void setEnlaceContenido(String enlaceContenido) {
        this.enlaceContenido = enlaceContenido;
    }

}
