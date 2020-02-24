package com.theiler.tmdbpeliculas.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.theiler.tmdbpeliculas.ui.generico.Generico;

public class Peliculas extends Generico {



    public static Peliculas newInstance() {
        Peliculas peliculas =new Peliculas();
        return peliculas;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setTitulo("Más Valoradas");
        return super.onCreateView(inflater,container,savedInstanceState);
       // return inflater.inflate(R.layout.todas_fragment, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(PeliculasViewModel.class);
        super.onActivityCreated(savedInstanceState);


    }

}
