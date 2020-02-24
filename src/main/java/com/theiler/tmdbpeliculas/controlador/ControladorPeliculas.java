package com.theiler.tmdbpeliculas.controlador;

import android.util.Log;
import android.widget.ListView;

import androidx.fragment.app.FragmentActivity;

import com.theiler.tmdbpeliculas.dominio.ItemCatalogo;
import com.theiler.tmdbpeliculas.dominio.Pelicula;
import com.theiler.tmdbpeliculas.dominio.RespuestaPeliculasAPI;
import com.theiler.tmdbpeliculas.dominio.RespuestaVideoAPI;
import com.theiler.tmdbpeliculas.dominio.Video;
import com.theiler.tmdbpeliculas.ui.dialog.DialogoVideo;
import com.theiler.tmdbpeliculas.ui.estrenos.Estrenos;
import com.theiler.tmdbpeliculas.ui.generico.Generico;
import com.theiler.tmdbpeliculas.ui.lista.ListaCatalogo;
import com.theiler.tmdbpeliculas.ui.peliculas.Peliculas;
import com.theiler.tmdbpeliculas.ui.populares.Populares;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ControladorPeliculas {
    private ControladorAPI controladorAPI=new ControladorAPI();
    private ListView lista;
    private FragmentActivity activity;
    private Generico generico;
    public static ControladorPeliculas instanciaUnica;


    public static ControladorPeliculas getInstanciaUnica(){
        if(instanciaUnica==null){
            instanciaUnica=new ControladorPeliculas();
        }
        return instanciaUnica;
    }

    private ControladorPeliculas(){}

    public void actualizar(ListaCatalogo listaCatalogo) {
        if(lista.getAdapter()==null){return;}
        if(listaCatalogo.isBuscar()){
            buscar(listaCatalogo.getPagina(),listaCatalogo.getTextoBuscar());
        }else{

            if(generico instanceof Populares){
                controladorAPI.getPeliculasPopulares(listaCatalogo.getPagina(), callbackPeliculas());
            }
            }
        if(generico instanceof Peliculas){
            controladorAPI.getPeliculas(listaCatalogo.getPagina(), callbackPeliculas());
        }

        if(generico instanceof Estrenos){
            controladorAPI.getPeliculasEstrenos(listaCatalogo.getPagina(), callbackPeliculas());
        }

        }

    private Callback<RespuestaPeliculasAPI> callbackPeliculas() {
        return new Callback<RespuestaPeliculasAPI>() {
            @Override
            public void onResponse(Call<RespuestaPeliculasAPI> call, Response<RespuestaPeliculasAPI> response) {
                ((ListaCatalogo) lista.getAdapter()).addAll(response.body().getResults());
                ((ListaCatalogo) lista.getAdapter()).notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<RespuestaPeliculasAPI> call, Throwable t) {
                Log.e("Error al actualizar ControladorPeliculas", t.toString());
            }
        };
    }


    public void cargarListaInicial(final Generico generico) {
        iniciarGenerico(generico);
        controladorAPI.getPeliculas(1, new Callback<RespuestaPeliculasAPI>() {
            @Override
            public void onResponse(Call<RespuestaPeliculasAPI> call, Response<RespuestaPeliculasAPI> response) {
                List<Pelicula> peliculas = response.body().getResults();
                Integer ultimaPagina=response.body().getTotalPages();
                ListaCatalogo listaCatalogo=new ListaCatalogo(activity,peliculas,ultimaPagina);
                lista.setAdapter(listaCatalogo);
            }

            @Override
            public void onFailure(Call<RespuestaPeliculasAPI> call, Throwable t) {
                Log.e("Error al cargarListaInicial ControladorPeliculas", t.toString());
            }
        });

    }

    public void cargarListaInicialPopulares(final Generico generico) {
        iniciarGenerico(generico);
        controladorAPI.getPeliculasPopulares(1, new Callback<RespuestaPeliculasAPI>() {
            @Override
            public void onResponse(Call<RespuestaPeliculasAPI> call, Response<RespuestaPeliculasAPI> response) {
                List<Pelicula> peliculas = response.body().getResults();
                Integer ultimaPagina=response.body().getTotalPages();
                ListaCatalogo listaCatalogo=new ListaCatalogo(activity,peliculas,ultimaPagina);
                lista.setAdapter(listaCatalogo);
            }

            @Override
            public void onFailure(Call<RespuestaPeliculasAPI> call, Throwable t) {
                Log.e("Error al cargarListaInicial ControladorPeliculas", t.toString());
            }
        });

    }

    public void cargarListaInicialEstrenos(final Generico generico) {
        iniciarGenerico(generico);
        controladorAPI.getPeliculasEstrenos(1, new Callback<RespuestaPeliculasAPI>() {
            @Override
            public void onResponse(Call<RespuestaPeliculasAPI> call, Response<RespuestaPeliculasAPI> response) {
                List<Pelicula> peliculas = response.body().getResults();
                Integer ultimaPagina=response.body().getTotalPages();
                ListaCatalogo listaCatalogo=new ListaCatalogo(activity,peliculas,ultimaPagina);
                lista.setAdapter(listaCatalogo);
            }

            @Override
            public void onFailure(Call<RespuestaPeliculasAPI> call, Throwable t) {
                Log.e("Error al cargarListaInicial ControladorPeliculas", t.toString());
            }
        });

    }

    private void iniciarGenerico(Generico generico) {
        this.lista = generico.getLista();
        this.activity = generico.getActivity();
        this.generico = generico;
    }

    public void verTrailer(final ItemCatalogo item){
        controladorAPI.getURLVideo(item.getURLVideo(), new Callback<RespuestaVideoAPI>() {
            @Override
            public void onResponse(Call<RespuestaVideoAPI> call, Response<RespuestaVideoAPI> response) {
                List<Video> list=response.body().getResults();
                if(list.size()==0){return;}
                DialogoVideo dialogoVideo=new DialogoVideo(list.get(0));
                dialogoVideo.show(activity.getSupportFragmentManager(),"Video");
            }

            @Override
            public void onFailure(Call<RespuestaVideoAPI> call, Throwable t) {

            }
        });
    }

    public void buscar(final Integer pagina, String newText) {
        controladorAPI.getPeliculasBuscar(pagina, newText, new Callback<RespuestaPeliculasAPI>() {
            @Override
            public void onResponse(Call<RespuestaPeliculasAPI> call, Response<RespuestaPeliculasAPI> response) {
                List list=response.body().getResults();
                if(pagina==1){((ListaCatalogo)lista.getAdapter()).clear();}
                ((ListaCatalogo)lista.getAdapter()).addAll(response.body().getResults());
                ((ListaCatalogo) lista.getAdapter()).setUltimaPagina(response.body().getTotalPages());
                ((ListaCatalogo) lista.getAdapter()).notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<RespuestaPeliculasAPI> call, Throwable t) {
                Log.e("Error al buscar ControladorPeliculas", t.toString());
            }
        });
    }


}
