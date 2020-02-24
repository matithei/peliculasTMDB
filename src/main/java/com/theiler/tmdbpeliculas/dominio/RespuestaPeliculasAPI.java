package com.theiler.tmdbpeliculas.dominio;



import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class RespuestaPeliculasAPI {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Pelicula> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
}
