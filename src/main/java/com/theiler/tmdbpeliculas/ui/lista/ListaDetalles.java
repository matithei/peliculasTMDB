package com.theiler.tmdbpeliculas.ui.lista;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.theiler.tmdbpeliculas.R;
import com.theiler.tmdbpeliculas.dominio.PropiedadLista;

import java.util.ArrayList;
import java.util.List;

public class ListaDetalles extends BaseAdapter {
    protected Activity activity;
    protected List<PropiedadLista> items;

    //costructor en el cual enviaremos informacion
    public ListaDetalles(Activity actividad, List<PropiedadLista> items) {
        this.activity = actividad;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.lista_detalles, null);
        }
        PropiedadLista item = items.get(position);

        TextView titulo = (TextView) v.findViewById(R.id.lista_detalle_titulo);
        TextView texto = (TextView) v.findViewById(R.id.lista_detalle_texto);

        titulo.setText(item.getTitulo());
        texto.setText(item.getTexto());

        return v;
    }

    public void addAll(ArrayList<PropiedadLista> items) {
        for (int i = 0; i < items.size(); i++) {
            this.items.add(items.get(i));
        }
    }
}
