package com.theiler.tmdbpeliculas.ui.dialog;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.theiler.tmdbpeliculas.R;
import com.theiler.tmdbpeliculas.controlador.ControladorPeliculas;
import com.theiler.tmdbpeliculas.controlador.ControladorSeries;
import com.theiler.tmdbpeliculas.dominio.ItemCatalogo;
import com.theiler.tmdbpeliculas.dominio.Pelicula;
import com.theiler.tmdbpeliculas.dominio.Serie;
import com.theiler.tmdbpeliculas.ui.generico.Generico;
import com.theiler.tmdbpeliculas.ui.lista.ListaDetalles;

/**
 * A simple {@link Fragment} subclass.
 */


public class Dialogo extends DialogFragment {
    private TextView titulo;
    private ImageView imagen;
    private ItemCatalogo itemCatalogo;
    private ListView listaDetalles;
    private Button btnSalir;
    private Button btnVideo;
    private Generico generico;
    public Dialogo() {
        // Required empty public constructor
    }

    public Dialogo(ItemCatalogo itemCatalogo) {

        this.itemCatalogo = itemCatalogo;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_dialogo, container, false);
        this.imagen=v.findViewById(R.id.dialogo_imagen);
        this.titulo=v.findViewById(R.id.dialogo_titulo);
        this.listaDetalles=v.findViewById(R.id.dialogo_lista);
        this.btnSalir=v.findViewById(R.id.dialogo_btn_salir);
        this.btnVideo=v.findViewById(R.id.dialogo_btn_video);
        this.titulo.setText(itemCatalogo.getTituloLista());
        this.imagen.setImageDrawable(itemCatalogo.getImagenDrawable());
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListaDetalles().setAdapter(new ListaDetalles(getActivity(),getItemCatalogo().getPropiedadesLista()));
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogo.this.dismiss();
            }
        });
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemCatalogo instanceof Serie){
                    ControladorSeries.getInstanciaUnica().verTrailer(itemCatalogo);
                }
                else
                if(itemCatalogo instanceof Pelicula){
                    ControladorPeliculas.getInstanciaUnica().verTrailer(itemCatalogo);}

            }
        });
    }

    public TextView getTitulo() {
        return titulo;
    }

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public ItemCatalogo getItemCatalogo() {
        return itemCatalogo;
    }

    public void setItemCatalogo(ItemCatalogo itemCatalogo) {
        this.itemCatalogo = itemCatalogo;
    }

    public ListView getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(ListView listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public Button getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(Button btnSalir) {
        this.btnSalir = btnSalir;
    }







}
