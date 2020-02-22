package com.theiler.tmdbpeliculas.ui.todas;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theiler.tmdbpeliculas.R;
import com.theiler.tmdbpeliculas.ui.generico.Generico;

public class Todas extends Generico {

    private TodasViewModel mViewModel;

    public static Todas newInstance() {
        Todas todas=new Todas();
        return todas;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setTitulo("Series y Peliculas");
        return super.onCreateView(inflater,container,savedInstanceState);
       // return inflater.inflate(R.layout.todas_fragment, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TodasViewModel.class);
        // TODO: Use the ViewModel
    }

}
