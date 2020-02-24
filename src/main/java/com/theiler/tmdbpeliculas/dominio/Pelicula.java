package com.theiler.tmdbpeliculas.dominio;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.SerializedName;
import com.theiler.tmdbpeliculas.controlador.ControladorAPI;
import com.theiler.tmdbpeliculas.controlador.Formato;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pelicula implements ItemCatalogo {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("id")
    private Integer id;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("vote_count")
    private Integer voteCount;
    @SerializedName("video")
    private Boolean video;
    @SerializedName("vote_average")
    private Double voteAverage;
    //para pasar a la lista al hacer click
    private Drawable imagen = null;

    @Override
    public String getTituloLista() {
        return getTitle();
    }

    @Override
    public Float getRatingLista() {
        return getVoteAverage().floatValue() / 2;
    }

    @Override
    public String getFechaLista() {
        return Formato.formatearFecha(getReleaseDate());
    }

    @Override
    public List<PropiedadLista> getPropiedadesLista() {
        ArrayList<PropiedadLista> propiedades = new ArrayList<>();
        propiedades.add(new PropiedadLista("Lenguaje Original", getOriginalLanguage()));
        propiedades.add(new PropiedadLista("Lanzamiento",getFechaLista()));
        propiedades.add(new PropiedadLista("Titulo Original", getOriginalTitle()));
        propiedades.add(new PropiedadLista("Sinopsis", getOverview()));
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
}
