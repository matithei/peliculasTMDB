package com.theiler.tmdbpeliculas.ui.generico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.theiler.tmdbpeliculas.R;


public class Generico extends Fragment {

    private GenericoViewModel mViewModel;

    private TextView lbl_titulo;
    private EditText txt_busqueda;
    private Button btn_buscar;
    private String titulo;
    private ListView lista;



    public static Generico newInstance() {
        Generico generico=new Generico();
        return generico;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.generico_fragment, container, false);
        this.btn_buscar=v.findViewById(R.id.generico_btn_buscar);
        this.lbl_titulo=v.findViewById(R.id.generico_lbl_titulo);
        this.txt_busqueda=v.findViewById(R.id.generico_txt_buscar);
        this.lista=v.findViewById(R.id.generico_lista);
        this.lbl_titulo.setText(getTitulo());
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GenericoViewModel.class);
        this.lbl_titulo.setText(getTitulo());
        mViewModel.cargarListaInicial(this);
        // TODO: Use the ViewModel

    }

    public ListView getLista() {
        return lista;
    }

    public void setLista(ListView lista) {
        this.lista = lista;
    }

    public TextView getLbl_titulo() {
        return lbl_titulo;
    }

    public void setLbl_titulo(TextView lbl_titulo) {
        this.lbl_titulo = lbl_titulo;
    }

    public EditText getTxt_busqueda() {
        return txt_busqueda;
    }

    public void setTxt_busqueda(EditText txt_busqueda) {
        this.txt_busqueda = txt_busqueda;
    }

    public Button getBtn_buscar() {
        return btn_buscar;
    }

    public void setBtn_buscar(Button btn_buscar) {
        this.btn_buscar = btn_buscar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



}
