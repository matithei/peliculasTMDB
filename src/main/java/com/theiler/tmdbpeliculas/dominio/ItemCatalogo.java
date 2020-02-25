package com.theiler.tmdbpeliculas.dominio;

import android.graphics.drawable.Drawable;

import java.util.List;

public interface ItemCatalogo {


    public String getTituloLista();

    public Float getRatingLista();

    public String getFechaLista();

    public List<PropiedadLista> getPropiedadesLista();

    public String getURLImagenLista();

    public Drawable getImagenDrawable();

    public String getGenerosLista();

    public boolean isVideo();

    public String getURLVideo();

    public List<Genero> getGeneros();

    public String getGenerosString();

    public String getGenerosStringComa();
}
