package com.theiler.tmdbpeliculas.ui.seriesEstrenos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.theiler.tmdbpeliculas.ui.generico.Generico;

public class SeriesEstrenos extends Generico {



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setTitulo("Actualmente en el Aire");
        return super.onCreateView(inflater,container,savedInstanceState);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(SeriesEstrenosViewModel.class);
        super.onActivityCreated(savedInstanceState);
    }


}
