package com.theiler.tmdbpeliculas.dominio;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Genero {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;





}
