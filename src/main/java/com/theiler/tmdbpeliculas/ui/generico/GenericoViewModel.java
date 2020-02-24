package com.theiler.tmdbpeliculas.ui.generico;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.lifecycle.ViewModel;

import com.theiler.tmdbpeliculas.R;
import com.theiler.tmdbpeliculas.controlador.ControladorTodas;
import com.theiler.tmdbpeliculas.dominio.Pelicula;
import com.theiler.tmdbpeliculas.ui.dialog.Dialogo;

public class GenericoViewModel extends ViewModel {


    public void cargarListaInicial(final Generico generico) {
        ControladorTodas controladorTodas=ControladorTodas.getInstanciaUnica();
        controladorTodas.cargarListaInicial(generico.getActivity(),generico.getLista());
        generico.getLista().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Pelicula item=(Pelicula) adapterView.getItemAtPosition(position);
                item.setImagen(((ImageView)view.findViewById(R.id.lista_imagen)).getDrawable());
                Dialogo dialogo = new Dialogo(item);
                dialogo.show(generico.getFragmentManager(), "dialogo");
            }
        });
    }



}
