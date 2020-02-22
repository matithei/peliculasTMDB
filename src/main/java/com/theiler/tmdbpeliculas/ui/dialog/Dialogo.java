package com.theiler.tmdbpeliculas.ui.dialog;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.theiler.tmdbpeliculas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dialogo extends DialogFragment {


    public Dialogo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialogo, container, false);
    }

}
