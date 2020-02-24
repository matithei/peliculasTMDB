package com.theiler.tmdbpeliculas.ui.estrenos;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.theiler.tmdbpeliculas.R;
import com.theiler.tmdbpeliculas.controlador.ControladorPeliculas;
import com.theiler.tmdbpeliculas.dominio.Pelicula;
import com.theiler.tmdbpeliculas.ui.dialog.Dialogo;
import com.theiler.tmdbpeliculas.ui.generico.Generico;
import com.theiler.tmdbpeliculas.ui.generico.GenericoViewModel;
import com.theiler.tmdbpeliculas.ui.lista.ListaCatalogo;

public class EstrenosViewModel extends GenericoViewModel {
    @Override
    public void cargarListaInicial(final Generico generico) {
        ControladorPeliculas controladorPeliculas = ControladorPeliculas.getInstanciaUnica();
        controladorPeliculas.cargarListaInicialEstrenos(generico);
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

    @Override
    protected void actualizar(Generico generico) {
        ControladorPeliculas.getInstanciaUnica().actualizar((ListaCatalogo) generico.getLista().getAdapter());
    }
    @Override
    protected void buscar(Integer pagina, String newText) {
        if(newText.length()>1){
            ControladorPeliculas.getInstanciaUnica().buscar(pagina,newText);
        }
    }
}
