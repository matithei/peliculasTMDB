package com.theiler.tmdbpeliculas.controlador;

import android.util.Log;
import android.widget.ListView;

import androidx.fragment.app.FragmentActivity;

import com.theiler.tmdbpeliculas.dominio.ItemCatalogo;
import com.theiler.tmdbpeliculas.dominio.RespuestaSeriesAPI;
import com.theiler.tmdbpeliculas.dominio.RespuestaVideoAPI;
import com.theiler.tmdbpeliculas.dominio.Serie;
import com.theiler.tmdbpeliculas.dominio.Video;
import com.theiler.tmdbpeliculas.ui.dialog.DialogoVideo;
import com.theiler.tmdbpeliculas.ui.generico.Generico;
import com.theiler.tmdbpeliculas.ui.lista.ListaCatalogo;
import com.theiler.tmdbpeliculas.ui.seriesEstrenos.SeriesEstrenos;
import com.theiler.tmdbpeliculas.ui.seriesMasValoradas.SeriesMasValoradas;
import com.theiler.tmdbpeliculas.ui.seriesPopulares.SeriesPopulares;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ControladorSeries {
    private ControladorAPI controladorAPI=new ControladorAPI();
    private ListView lista;
    private FragmentActivity activity;
    private Generico generico;
    public static ControladorSeries instanciaUnica;


    public static ControladorSeries getInstanciaUnica(){
        if(instanciaUnica==null){
            instanciaUnica=new ControladorSeries();
        }
        return instanciaUnica;
    }

    private ControladorSeries(){}

    public void actualizar(ListaCatalogo listaCatalogo) {
        if(lista.getAdapter()==null){return;}
        if(listaCatalogo.isBuscar()){
            buscar(listaCatalogo.getPagina(),listaCatalogo.getTextoBuscar());
        }else{

            if(generico instanceof SeriesPopulares){
                controladorAPI.getSeriesPopulares(listaCatalogo.getPagina(), callbackSeries());
            }
            if(generico instanceof SeriesMasValoradas){
                controladorAPI.getSeriesMasValoradas(listaCatalogo.getPagina(), callbackSeries());
            }
            if(generico instanceof SeriesEstrenos){
                controladorAPI.getSeriesEstrenos(listaCatalogo.getPagina(), callbackSeries());
            }
        }


    }

    private Callback<RespuestaSeriesAPI> callbackSeries() {
        return new Callback<RespuestaSeriesAPI>() {
            @Override
            public void onResponse(Call<RespuestaSeriesAPI> call, Response<RespuestaSeriesAPI> response) {
                ((ListaCatalogo) lista.getAdapter()).addAll(response.body().getResults());
                ((ListaCatalogo) lista.getAdapter()).notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<RespuestaSeriesAPI> call, Throwable t) {
                Log.e("Error al actualizar ControladorPeliculas", t.toString());
            }
        };
    }


    public void cargarListaInicialMasValoradas(final Generico generico) {
        iniciarGenerico(generico);
        controladorAPI.getSeriesMasValoradas(1, callbackListaInicial());

    }

    private Callback<RespuestaSeriesAPI> callbackListaInicial() {
        return new Callback<RespuestaSeriesAPI>() {
            @Override
            public void onResponse(Call<RespuestaSeriesAPI> call, Response<RespuestaSeriesAPI> response) {
                List<Serie> series = response.body().getResults();
                Integer ultimaPagina = response.body().getTotalPages();
                ListaCatalogo listaCatalogo = new ListaCatalogo(activity, series, ultimaPagina);
                lista.setAdapter(listaCatalogo);
            }

            @Override
            public void onFailure(Call<RespuestaSeriesAPI> call, Throwable t) {
                Log.e("Error al cargarListaInicial ControladorSeries", t.toString());
            }
        };
    }

    public void cargarListaInicialPopulares(final Generico generico) {
        iniciarGenerico(generico);
        controladorAPI.getSeriesPopulares(1, callbackListaInicial());
    }

    public void cargarListaInicialEstrenos(final Generico generico) {
        iniciarGenerico(generico);
        controladorAPI.getSeriesEstrenos(1, callbackListaInicial());
    }

    private void iniciarGenerico(Generico generico) {
        this.lista = generico.getLista();
        this.activity = generico.getActivity();
        this.generico = generico;
    }

    public void verTrailer(final ItemCatalogo item){
        controladorAPI.getURLSerieVideo(item.getURLVideo(), new Callback<RespuestaVideoAPI>() {
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
        controladorAPI.getSeriesBuscar(pagina, newText, new Callback<RespuestaSeriesAPI>() {
            @Override
            public void onResponse(Call<RespuestaSeriesAPI> call, Response<RespuestaSeriesAPI> response) {
                List list=response.body().getResults();
                if(pagina==1){((ListaCatalogo)lista.getAdapter()).clear();}
                ((ListaCatalogo)lista.getAdapter()).addAll(response.body().getResults());
                ((ListaCatalogo) lista.getAdapter()).setUltimaPagina(response.body().getTotalPages());
                ((ListaCatalogo) lista.getAdapter()).notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<RespuestaSeriesAPI> call, Throwable t) {
                Log.e("Error al buscar ControladorPeliculas", t.toString());
            }
        });
    }
}
