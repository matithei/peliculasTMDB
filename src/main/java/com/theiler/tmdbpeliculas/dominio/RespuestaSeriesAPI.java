package com.theiler.tmdbpeliculas.dominio;



import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class RespuestaSeriesAPI {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Serie> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
}
