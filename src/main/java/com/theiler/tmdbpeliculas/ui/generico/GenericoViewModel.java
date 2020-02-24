package com.theiler.tmdbpeliculas.ui.generico;

import android.widget.SearchView;

import androidx.lifecycle.ViewModel;

import com.theiler.tmdbpeliculas.ui.lista.ListaCatalogo;

public abstract class GenericoViewModel extends ViewModel {


    public abstract void cargarListaInicial(final Generico generico);


    public void setearBuscador(final Generico generico ) {
        final SearchView search=generico.getSearch();

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length()>1){
                    buscar( ((ListaCatalogo)generico.getLista().getAdapter()).getPagina(),newText);
                    ((ListaCatalogo)generico.getLista().getAdapter()).setPagina(1);
                    ((ListaCatalogo)generico.getLista().getAdapter()).setTextoBuscar(newText);
                }else{
                    ((ListaCatalogo)generico.getLista().getAdapter()).clear();
                    actualizar(generico);
                }
                ((ListaCatalogo)generico.getLista().getAdapter()).setBuscar(newText.length()>1);
                return true;
            }
        });
    }

    protected abstract void actualizar(Generico generico);

    protected abstract void buscar(Integer pagina,String newText);
}
