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
import com.theiler.tmdbpeliculas.controlador.ControladorPeliculas;
import com.theiler.tmdbpeliculas.controlador.ControladorSeries;
import com.theiler.tmdbpeliculas.dominio.ItemCatalogo;
import com.theiler.tmdbpeliculas.dominio.Pelicula;
import com.theiler.tmdbpeliculas.dominio.Serie;

import java.util.List;

public class ListaCatalogo extends BaseAdapter{

    protected Activity activity;
    protected List items;
    protected Integer pagina=1;
    protected Integer ultimaPagina;
    protected boolean buscar=false;
    protected String textoBuscar;



    public ListaCatalogo(Activity actividad, List items, Integer ultimaPagina) {
        this.activity = actividad;
        this.items = items;
        this.ultimaPagina=ultimaPagina;
    }

    public String getTextoBuscar() {
        return textoBuscar;
    }

    public void setTextoBuscar(String textoBuscar) {
        this.textoBuscar = textoBuscar;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
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
        final ItemCatalogo item = (ItemCatalogo) items.get(position);
        TextView titulo = (TextView) v.findViewById(R.id.lista_titulo);
        RatingBar ratingBar= v.findViewById(R.id.lista_ratingBar);
        TextView fecha=v.findViewById(R.id.lista_fecha);
        TextView generos=v.findViewById(R.id.lista_generos);
        ImageView imagen=v.findViewById(R.id.lista_imagen);
        titulo.setText(item.getTituloLista());
        if(item.getTituloLista().length()>35){
            titulo.setTextSize(15);
        }
        ratingBar.setRating(item.getRatingLista());
        if(item.getFechaLista()!=null){fecha.setText(item.getFechaLista());}else{
            fecha.setVisibility(View.INVISIBLE);
        }
       Picasso.with(v.getContext())
               .load(item.getURLImagenLista())
                .placeholder(R.drawable.tmdb)
                .error(R.drawable.tmdb)
                .into(imagen);
       if(esFinaldeLaLista(position) && !esUltimaPagina()){
            actualizarPagina(pagina,item);
       }
       generos.setText(item.getGenerosStringComa());

        return v;
    }

    private boolean esUltimaPagina() {
        System.out.println("Ultima pagina "+getUltimaPagina());
        return getUltimaPagina()==pagina;
    }

    private void actualizarPagina(int pagina,ItemCatalogo itemCatalogo) {
        this.pagina=pagina+1;

        if(itemCatalogo instanceof Pelicula){
            ControladorPeliculas.getInstanciaUnica().actualizar(this);
        }else
        if(itemCatalogo instanceof Serie){
            ControladorSeries.getInstanciaUnica().actualizar(this);
        }
    }

    private boolean esFinaldeLaLista(int position) {
        return (position+1)==items.size();
    }

    public void addAll(List items){
        for (int i= 0; i<items.size(); i++) {
            this.items.add(items.get(i));
        }
    }

    public Integer getUltimaPagina() {
        return ultimaPagina;
    }

    public void setUltimaPagina(Integer ultimaPagina) {
        this.ultimaPagina = ultimaPagina;
    }

    public void clear(){
        if(getItems()!=null){
            getItems().clear();
        }
    }

    public boolean isBuscar() {
        return buscar;
    }

    public void setBuscar(boolean buscar) {
        this.buscar = buscar;
    }


    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }



}
