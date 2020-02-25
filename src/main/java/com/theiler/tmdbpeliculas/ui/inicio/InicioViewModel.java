package com.theiler.tmdbpeliculas.ui.inicio;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.theiler.tmdbpeliculas.MainActivity;
import com.theiler.tmdbpeliculas.R;

public class InicioViewModel extends ViewModel {

    public void iniciar(Inicio inicio){
        setOnClickPeliculasEstrenos(inicio);
        setOnClickPeliculasMasValoradas(inicio);
        setOnClickPeliculasPopulares(inicio);
        setOnClickSeriesActuales(inicio);
        setOnClickSeriesMasValoradas(inicio);
        setOnClickSeriesPopulares(inicio);
    }

   public void setOnClickPeliculasEstrenos(final Inicio inicio){
       inicio.getPeliculasEstrenos().setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ((MainActivity)inicio.getActivity()).cambiarFragment(R.id.nav_estrenos);
           }
       });
   }

    public void setOnClickPeliculasMasValoradas(final Inicio inicio){
        inicio.getPeliculasMasValoradas().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)inicio.getActivity()).cambiarFragment(R.id.nav_todas);
            }
        });
    }

    public void setOnClickPeliculasPopulares(final Inicio inicio){
        inicio.getPeliculasPopulares().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)inicio.getActivity()).cambiarFragment(R.id.nav_populares);
            }
        });
    }

    public void setOnClickSeriesMasValoradas(final Inicio inicio){
        inicio.getSeriesMasValoradas().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)inicio.getActivity()).cambiarFragment(R.id.nav_series_mas_valoradas);
            }
        });
    }

    public void setOnClickSeriesPopulares(final Inicio inicio){
        inicio.getSeriesPopulares().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)inicio.getActivity()).cambiarFragment(R.id.nav_series_populares);
            }
        });
    }

    public void setOnClickSeriesActuales(final Inicio inicio){
        inicio.getSeriesActuales().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)inicio.getActivity()).cambiarFragment(R.id.nav_series_estrenos);
            }
        });
    }
}
