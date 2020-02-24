package com.theiler.tmdbpeliculas.controlador;

import com.theiler.tmdbpeliculas.dominio.RespuestaPeliculasAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServicioAPI {

    @GET("movie/popular")
    Call<RespuestaPeliculasAPI> getTopRatedMovies
            (@Query("api_key") String apiKey,
             @Query("language")String language,
             @Query("page") Integer pagina);
}
