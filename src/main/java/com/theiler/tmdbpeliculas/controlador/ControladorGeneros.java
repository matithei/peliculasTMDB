package com.theiler.tmdbpeliculas.controlador;

import android.util.Log;

import com.theiler.tmdbpeliculas.dominio.Genero;
import com.theiler.tmdbpeliculas.dominio.RespuestaGeneroAPI;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Data
public class ControladorGeneros {
    public static Map<String,String> generosSeries=new HashMap<>();
    public static Map<String,String> generosPeliculas=new HashMap<>();

    public static String getGeneroPelicula(String id){
        if(generosPeliculas.size()==0){
           obtenerGenerosPeliculas();
        }
        return generosPeliculas.get(id);
    }

    public static void obtenerGenerosPeliculas() {
        final Map<String,String> map=new HashMap<>();
        new ControladorAPI().getGenerosPeliculas(new Callback<RespuestaGeneroAPI>() {
            @Override
            public void onResponse(Call<RespuestaGeneroAPI> call, Response<RespuestaGeneroAPI> response) {
                for (Genero g:response.body().getGeneros()) {
                    map.put(g.getId(),g.getName());
                }
                generosPeliculas=map;
            }
            @Override
            public void onFailure(Call<RespuestaGeneroAPI> call, Throwable t) {
                Log.d("Error controlador generos",t.toString());
            }
        });
    }

    public static String getGeneroSerie(String id){
        if(generosSeries.size()==0){
            obtenerGenerosSeries();
        }
        return generosSeries.get(id);
    }

    public static void obtenerGenerosSeries() {
        final Map<String,String> map=new HashMap<>();
        new ControladorAPI().getGenerosSeries(new Callback<RespuestaGeneroAPI>() {
            @Override
            public void onResponse(Call<RespuestaGeneroAPI> call, Response<RespuestaGeneroAPI> response) {
                for (Genero g:response.body().getGeneros()) {
                    map.put(g.getId(),g.getName());
                }
                generosSeries=map;
            }
            @Override
            public void onFailure(Call<RespuestaGeneroAPI> call, Throwable t) {
                Log.d("Error controlador generos",t.toString());
            }
        });

    }



}
