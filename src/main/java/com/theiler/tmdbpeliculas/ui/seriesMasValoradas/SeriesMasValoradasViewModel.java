package com.theiler.tmdbpeliculas.ui.seriesMasValoradas;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.theiler.tmdbpeliculas.R;
import com.theiler.tmdbpeliculas.controlador.ControladorSeries;
import com.theiler.tmdbpeliculas.dominio.Serie;
import com.theiler.tmdbpeliculas.ui.dialog.Dialogo;
import com.theiler.tmdbpeliculas.ui.generico.Generico;
import com.theiler.tmdbpeliculas.ui.generico.GenericoViewModel;
import com.theiler.tmdbpeliculas.ui.lista.ListaCatalogo;

public class SeriesMasValoradasViewModel extends GenericoViewModel {
    @Override
    public void cargarListaInicial(final Generico generico) {
        ControladorSeries controladorSeries = ControladorSeries.getInstanciaUnica();
        controladorSeries.cargarListaInicialMasValoradas(generico);
        generico.getLista().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Serie item=(Serie) adapterView.getItemAtPosition(position);
                item.setImagen(((ImageView)view.findViewById(R.id.lista_imagen)).getDrawable());
                Dialogo dialogo = new Dialogo(item);
                dialogo.show(generico.getFragmentManager(), "dialogo");
            }
        });
    }

    @Override
    protected void actualizar(Generico generico) {
        ControladorSeries.getInstanciaUnica().actualizar((ListaCatalogo) generico.getLista().getAdapter());
    }

    @Override
    protected void buscar(Integer pagina, String newText) {
        ControladorSeries.getInstanciaUnica().buscar(pagina,newText);
    }
}
