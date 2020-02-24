package com.theiler.tmdbpeliculas.controlador;

import android.util.Log;
import android.widget.ListView;

import androidx.fragment.app.FragmentActivity;

import com.theiler.tmdbpeliculas.dominio.Pelicula;
import com.theiler.tmdbpeliculas.dominio.RespuestaPeliculasAPI;
import com.theiler.tmdbpeliculas.ui.lista.ListaCatalogo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ControladorTodas{
    private ControladorAPI controladorAPI=new ControladorAPI();
    private ListView lista;
    private FragmentActivity activity;
    public static ControladorTodas instanciaUnica;

    public static ControladorTodas getInstanciaUnica(){
        if(instanciaUnica==null){
            instanciaUnica=new ControladorTodas();
        }
        return instanciaUnica;
    }

    private ControladorTodas(){}

    public void actualizar(int pagina) {
        if(lista.getAdapter()==null){return;}
        controladorAPI.getTodas(pagina, new Callback<RespuestaPeliculasAPI>() {
            @Override
            public void onResponse(Call<RespuestaPeliculasAPI> call, Response<RespuestaPeliculasAPI> response) {
                ((ListaCatalogo)lista.getAdapter()).addAll(response.body().getResults());
            }

            @Override
            public void onFailure(Call<RespuestaPeliculasAPI> call, Throwable t) {
                Log.e("Error al actualizar ControladorTodas", t.toString());
            }
        });
    }

    public void cargarListaInicial(final FragmentActivity activity, final ListView lista) {
        this.lista=lista;
        this.activity=activity;
        controladorAPI.getTodas(1, new Callback<RespuestaPeliculasAPI>() {
            @Override
            public void onResponse(Call<RespuestaPeliculasAPI> call, Response<RespuestaPeliculasAPI> response) {
                List<Pelicula> peliculas = response.body().getResults();
                lista.setAdapter(new ListaCatalogo(activity,peliculas));
            }

            @Override
            public void onFailure(Call<RespuestaPeliculasAPI> call, Throwable t) {
                Log.e("Error al cargarListaInicial ControladorTodas", t.toString());
            }
        });

    }
}
