package com.theiler.tmdbpeliculas.ui.lista;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.theiler.tmdbpeliculas.R;
import com.theiler.tmdbpeliculas.controlador.ControladorTodas;
import com.theiler.tmdbpeliculas.dominio.ItemCatalogo;

import java.util.List;

public class ListaCatalogo extends BaseAdapter{

    protected Activity activity;
    protected List items;
    protected Integer pagina=1;

    //costructor en el cual enviaremos informacion
    public ListaCatalogo(Activity actividad, List items) {
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
        ItemCatalogo item = (ItemCatalogo) items.get(position);
        TextView titulo = (TextView) v.findViewById(R.id.lista_titulo);
        RatingBar ratingBar= v.findViewById(R.id.lista_ratingBar);
        TextView fecha=v.findViewById(R.id.lista_fecha);
        ImageView imagen=v.findViewById(R.id.lista_imagen);
        titulo.setText(item.getTituloLista());
        if(item.getTituloLista().length()>35){
            titulo.setTextSize(15);
        }
        ratingBar.setRating(item.getRatingLista());
        fecha.setText(item.getFechaLista());
       Picasso.with(v.getContext())
               .load(item.getURLImagenLista())
                .placeholder(R.drawable.tmdb)
                .error(R.drawable.tmdb)
                .into(imagen);
       if(esFinaldeLaLista(position)){
            actualizarPagina(pagina);
       }

        return v;
    }

    private void actualizarPagina(int pagina) {
        pagina=pagina+1;
        ControladorTodas.getInstanciaUnica().actualizar(pagina);
    }

    private boolean esFinaldeLaLista(int position) {
        return (position+1)==items.size();
    }

    public void addAll(List items){
        for (int i= 0; i<items.size(); i++) {
            this.items.add(items.get(i));
        }
    }



}
