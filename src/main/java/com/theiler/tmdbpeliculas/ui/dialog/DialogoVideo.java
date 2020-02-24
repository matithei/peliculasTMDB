package com.theiler.tmdbpeliculas.ui.dialog;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.theiler.tmdbpeliculas.R;
import com.theiler.tmdbpeliculas.dominio.Video;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogoVideo extends DialogFragment {
    String URL_VIDEO;

    public DialogoVideo() {
        // Required empty public constructor
    }

    public DialogoVideo(Video video){
       this.URL_VIDEO=video.getKey();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_dialogo_video, container, false);
        WebView webView=v.findViewById(R.id.dialogo_video);
        webView.loadUrl("https://www.youtube.com/watch?v="+URL_VIDEO);
        return v;
    }

}
