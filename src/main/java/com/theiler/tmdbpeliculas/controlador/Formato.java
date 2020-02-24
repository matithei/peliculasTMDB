package com.theiler.tmdbpeliculas.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formato {

    public static String formatearFecha(Date fecha){
        return new SimpleDateFormat("dd/MM/yyyy").format(fecha);
    }

    public static String formatearFecha(String fecha){
        return new SimpleDateFormat("yyyy").format(Formato.fechaToDate(fecha));
    }

    public static Date fechaToDate(String fecha) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
