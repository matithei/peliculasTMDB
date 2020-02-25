package com.theiler.tmdbpeliculas.dominio;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.SerializedName;
import com.theiler.tmdbpeliculas.controlador.ControladorAPI;
import com.theiler.tmdbpeliculas.controlador.ControladorGeneros;
import com.theiler.tmdbpeliculas.controlador.Formato;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Serie implements ItemCatalogo{
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("overview")
    private String overview;
    @SerializedName("first_air_date")
    private String lastAirDate;
    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("id")
    private Integer id;
    @SerializedName("original_name")
    private String originalName;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("name")
    private String name;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("vote_count")
    private Integer voteCount;
    @SerializedName("vote_average")
    private Double voteAverage;
    //para pasar a la lista al hacer click
    private Drawable imagen = null;

    @Override
    public String getTituloLista() {
        return getName();
    }

    @Override
    public Float getRatingLista() {
        return getVoteAverage().floatValue() / 2;
    }

    @Override
    public String getFechaLista() {
        if(getLastAirDate()!=null){
            return Formato.formatearFecha(getLastAirDate());
        }
        return null;

    }

    @Override
    public List<PropiedadLista> getPropiedadesLista() {
        ArrayList<PropiedadLista> propiedades = new ArrayList<>();
        propiedades.add(new PropiedadLista("Lenguaje Original", Lenguajes.lenguajes.get(getOriginalLanguage())));
        propiedades.add(new PropiedadLista("Lanzamiento",getFechaLista()));
        propiedades.add(new PropiedadLista("Titulo Original", getOriginalName()));
        propiedades.add(new PropiedadLista("Sinopsis", getOverview()));
        propiedades.add(new PropiedadLista("Generos",getGenerosString()));
        return propiedades;
    }

    @Override
    public String getURLImagenLista() {
        return ControladorAPI.URL_IMAGENES + getPosterPath();
    }

    @Override
    public Drawable getImagenDrawable() {
        return getImagen();
    }

    @Override
    public String getGenerosLista() {
        return null;
    }

    @Override
    public boolean isVideo() {
        return false;
    }

    @Override
    public String getURLVideo() {
        return getId().toString();
    }

    @Override
    public List<Genero> getGeneros() {
        List<Genero> lista=new ArrayList<>();
        for (Integer i:getGenreIds()) {
            String genero=ControladorGeneros.getGeneroSerie(String.valueOf(i));
            if(genero!=null) {
                if(!genero.equals("null")) {
                    lista.add(new Genero(String.valueOf(i), genero));
                }
            }
        }
        return lista;
    }

    @Override
    public String getGenerosString() {
        String generos="";
        for (Genero g:getGeneros()) {
            generos=generos+g.getName()+"\n";
        }
        return generos;
    }

    @Override
    public String getGenerosStringComa() {
        String generos="";
        for (Genero g:getGeneros()) {

            if (generos.length() > 0) {
                generos = generos + ", " + g.getName();
            } else {
                generos = generos + g.getName();
            }
        }

        return generos;
    }



}
