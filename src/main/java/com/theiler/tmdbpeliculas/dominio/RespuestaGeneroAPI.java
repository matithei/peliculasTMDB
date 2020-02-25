package com.theiler.tmdbpeliculas.dominio;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class RespuestaGeneroAPI {
    @SerializedName("genres")
    private List<Genero> generos;
}
