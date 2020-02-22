package com.theiler.tmdbpeliculas.ui.generico;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.theiler.tmdbpeliculas.dominio.ItemCatalogo;
import com.theiler.tmdbpeliculas.ui.lista.ListaCatalogo;

import java.util.ArrayList;

public class GenericoViewModel extends ViewModel {

    public void cargarListaInicial(final Generico generico) {
        ArrayList<ItemCatalogo> items=new ArrayList<>();
        items.add(new ItemCatalogo());
        items.add(new ItemCatalogo());
        items.add(new ItemCatalogo());
        items.add(new ItemCatalogo());
        items.add(new ItemCatalogo());
        items.add(new ItemCatalogo());
        items.add(new ItemCatalogo());
        ListaCatalogo adaptador=new ListaCatalogo(generico.getActivity(),items);
        generico.getLista().setAdapter(adaptador);
        generico.getLista().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(generico.getContext(),
                        String.valueOf(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
