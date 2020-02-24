package com.theiler.tmdbpeliculas.controlador;

import com.theiler.tmdbpeliculas.dominio.RespuestaPeliculasAPI;
import com.theiler.tmdbpeliculas.dominio.RespuestaSeriesAPI;
import com.theiler.tmdbpeliculas.dominio.RespuestaVideoAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicioAPI {

    @GET("movie/top_rated")
    Call<RespuestaPeliculasAPI> getMasPuntuadas
            (@Query("api_key") String apiKey,
             @Query("language")String language,
             @Query("page") String pagina);

    @GET("movie/popular")
    Call<RespuestaPeliculasAPI> getPopulares
            (@Query("api_key") String apiKey,
             @Query("language")String language,
             @Query("page") String pagina);

    @GET("movie/upcoming")
    Call<RespuestaPeliculasAPI> getEstrenos
            (@Query("api_key") String apiKey,
             @Query("language")String language,
             @Query("page") String pagina);

    @GET("movie/{id}/videos")
    Call<RespuestaVideoAPI> getVideoPelicula(@Path("id") String id,@Query("api_key") String apiKey);

    @GET("search/movie")
    Call<RespuestaPeliculasAPI> getPeliculasBuscar(
            @Query("api_key") String apiKey,
            @Query("language") String lenguaje,
            @Query("page")String pagina,
            @Query("query") String buscar);

    @GET("tv/popular")
    Call<RespuestaSeriesAPI> getSeriesPopulares
            (@Query("api_key") String apiKey,
             @Query("language")String language,
             @Query("page") String pagina);

    @GET("tv/{id}/videos")
    Call<RespuestaVideoAPI> getVideoSerie(@Path("id") String id,@Query("api_key") String apiKey);
}
