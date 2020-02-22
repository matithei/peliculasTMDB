package com.theiler.tmdbpeliculas.ui.lista;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.theiler.tmdbpeliculas.R;
import com.theiler.tmdbpeliculas.dominio.ItemCatalogo;

import java.util.ArrayList;

public class ListaCatalogo extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<ItemCatalogo> items;

    //costructor en el cual enviaremos informacion
    public ListaCatalogo(Activity actividad, ArrayList<ItemCatalogo> items) {
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
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.lista_item_catalogo, null);
        }

        //creamos un objeto de la clase WebsEsTl
        ItemCatalogo item = items.get(position);

        //Asignamos los recursos a las variable
        TextView titulo = (TextView) v.findViewById(R.id.lista_titulo);
        RatingBar ratingBar= v.findViewById(R.id.lista_ratingBar);
        TextView fecha=v.findViewById(R.id.lista_fecha);

        //Enviamos informacion a la vista apartir de la informacion que contenga la clase:
        titulo.setText(item.getTituloLista());
        ratingBar.setRating(item.getRatingLista());
        fecha.setText(item.getFechaLista());

        return v;
    }

    public void addAll(ArrayList<ItemCatalogo> items){
        for (int i= 0; i<items.size(); i++) {
            this.items.add(items.get(i));
        }
    }



}
