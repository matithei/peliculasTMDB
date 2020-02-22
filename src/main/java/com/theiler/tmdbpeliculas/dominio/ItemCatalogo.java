package com.theiler.tmdbpeliculas.dominio;

import java.util.List;

public class ItemCatalogo {
    private Integer id;
    private List<Genero> generos; //genre_ids
    private Long popularity;
    private Long voteCount;
    private String backdropPath;
    private String originalLanguage;
    private Double voteAverage;
    private String oreview;
    private String posterPath;


    public String getTituloLista() {
        return "Titulo 1";
    }

    public Float getRatingLista() {
        return new Float(3.5);
    }

    public String getFechaLista() {
        return "12/07/1994";
    }
}
