package com.theiler.tmdbpeliculas.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.theiler.tmdbpeliculas.R;

public class Inicio extends Fragment {

    private InicioViewModel mViewModel;
    Button peliculasMasValoradas,peliculasPopulares,peliculasEstrenos,
            seriesMasValoradas,seriesPopulares,seriesActuales;

    public InicioViewModel getmViewModel() {
        return mViewModel;
    }

    public void setmViewModel(InicioViewModel mViewModel) {
        this.mViewModel = mViewModel;
    }

    public Button getPeliculasMasValoradas() {
        return peliculasMasValoradas;
    }

    public void setPeliculasMasValoradas(Button peliculasMasValoradas) {
        this.peliculasMasValoradas = peliculasMasValoradas;
    }

    public Button getPeliculasPopulares() {
        return peliculasPopulares;
    }

    public void setPeliculasPopulares(Button peliculasPopulares) {
        this.peliculasPopulares = peliculasPopulares;
    }

    public Button getPeliculasEstrenos() {
        return peliculasEstrenos;
    }

    public void setPeliculasEstrenos(Button peliculasEstrenos) {
        this.peliculasEstrenos = peliculasEstrenos;
    }

    public Button getSeriesMasValoradas() {
        return seriesMasValoradas;
    }

    public void setSeriesMasValoradas(Button seriesMasValoradas) {
        this.seriesMasValoradas = seriesMasValoradas;
    }

    public Button getSeriesPopulares() {
        return seriesPopulares;
    }

    public void setSeriesPopulares(Button seriesPopulares) {
        this.seriesPopulares = seriesPopulares;
    }

    public Button getSeriesActuales() {
        return seriesActuales;
    }

    public void setSeriesActuales(Button seriesActuales) {
        this.seriesActuales = seriesActuales;
    }

    public static Inicio newInstance() {
        return new Inicio();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.inicio_fragment, container, false);
        peliculasMasValoradas=v.findViewById(R.id.inicio_btn_peliculas_mas_valoradas);
        peliculasPopulares=v.findViewById(R.id.inicio_btn_peliculas_populares);
        peliculasEstrenos=v.findViewById(R.id.inicio_btn_peliculas_estrenos);
        seriesMasValoradas=v.findViewById(R.id.inicio_btn_series_mas_valoradas);
        seriesPopulares=v.findViewById(R.id.inicio_btn_series_populares);
        seriesActuales=v.findViewById(R.id.inicio_btn_series_estrenos);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(InicioViewModel.class);
        mViewModel.iniciar(this);
    }

}
