package com.theiler.tmdbpeliculas.controlador;

import com.theiler.tmdbpeliculas.MainActivity;
import com.theiler.tmdbpeliculas.dominio.RespuestaPeliculasAPI;
import com.theiler.tmdbpeliculas.dominio.RespuestaSeriesAPI;
import com.theiler.tmdbpeliculas.dominio.RespuestaVideoAPI;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControladorAPI {
    public static String URL_IMAGENES="https://image.tmdb.org/t/p/w300";
    public static final String URL_API = "https://api.themoviedb.org/3/";
    public static final String API_KEY="fcca2364057cc0261e027bd5f15fe5d2";
    public static final String LENGUAJE="es";
    private static Retrofit retrofit = null;

    public void getPeliculas(Integer pagina, Callback<RespuestaPeliculasAPI> callback){
        if(pagina==null){pagina=1;}
        ServicioAPI servicioAPI = iniciarRetrofit();
        Call<RespuestaPeliculasAPI> call = servicioAPI.getMasPuntuadas(API_KEY,LENGUAJE,String.valueOf(pagina));
        call.enqueue(callback);
    }

    public void getPeliculasPopulares(Integer pagina, Callback<RespuestaPeliculasAPI> callback){
        if(pagina==null){pagina=1;}
        ServicioAPI servicioAPI = iniciarRetrofit();
        Call<RespuestaPeliculasAPI> call = servicioAPI.getPopulares(API_KEY,LENGUAJE,String.valueOf(pagina));
        call.enqueue(callback);
    }
    public void getPeliculasEstrenos(Integer pagina, Callback<RespuestaPeliculasAPI> callback){
        if(pagina==null){pagina=1;}
        ServicioAPI servicioAPI = iniciarRetrofit();
        Call<RespuestaPeliculasAPI> call = servicioAPI.getEstrenos(API_KEY,LENGUAJE,String.valueOf(pagina));
        call.enqueue(callback);
    }

    public void getPeliculasBuscar(Integer pagina,String buscar,Callback<RespuestaPeliculasAPI> callback){
        if(pagina==null){pagina=1;}
        ServicioAPI servicioAPI = iniciarRetrofit();
        Call<RespuestaPeliculasAPI> call = servicioAPI.getPeliculasBuscar(API_KEY,LENGUAJE,String.valueOf(pagina),buscar);
        call.enqueue(callback);
    }

    public void getSeriesPopulares(Integer pagina, Callback<RespuestaSeriesAPI> callback){
        if(pagina==null){pagina=1;}
        ServicioAPI servicioAPI = iniciarRetrofit();
        Call<RespuestaSeriesAPI> call = servicioAPI.getSeriesPopulares(API_KEY,LENGUAJE,String.valueOf(pagina));
        call.enqueue(callback);
    }

    private ServicioAPI iniciarRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(MainActivity.cache)
                .build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_API)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ServicioAPI.class);
    }

    public void getURLVideo(String id,Callback<RespuestaVideoAPI> callback){
        iniciarRetrofit();
        ServicioAPI servicioAPI = retrofit.create(ServicioAPI.class);
        Call<RespuestaVideoAPI> call = servicioAPI.getVideoPelicula(id,API_KEY);
        call.enqueue(callback);
    }

    public void getURLSerieVideo(String id,Callback<RespuestaVideoAPI> callback) {
        iniciarRetrofit();
        ServicioAPI servicioAPI = retrofit.create(ServicioAPI.class);
        Call<RespuestaVideoAPI> call = servicioAPI.getVideoSerie(id,API_KEY);
        call.enqueue(callback);
    }
}


