package com.theiler.tmdbpeliculas.controlador;

import com.theiler.tmdbpeliculas.dominio.RespuestaPeliculasAPI;

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

    public void getTodas(Integer pagina,Callback<RespuestaPeliculasAPI> callback){
        if(pagina==null){pagina=1;}
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ServicioAPI peliculaApiService = retrofit.create(ServicioAPI.class);
        Call<RespuestaPeliculasAPI> call = peliculaApiService.getTopRatedMovies(API_KEY,LENGUAJE,pagina);
        call.enqueue(callback);/*new Callback<RespuestaPeliculasAPI>() {
            @Override
            public void onResponse(Call<RespuestaPeliculasAPI> call, Response<RespuestaPeliculasAPI> response) {
                List<Pelicula> peliculas = response.body().getResults();
                listView.setAdapter(new ListaCatalogo(activity,peliculas));
            }
            @Override
            public void onFailure(Call<RespuestaPeliculasAPI> call, Throwable throwable) {
                Log.e("Error metodo obtenerDatos ControladorAPI", throwable.toString());
            }
        });*/
    }
}


