package es.cm.dam.dos.pmdm.vistaspersonalizadas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AdaptadorPelicula extends ArrayAdapter<Pelicula> {

    private final Context contexto;
    private final ArrayList<Pelicula> listaPeliculas;

    public AdaptadorPelicula(Context contexto, ArrayList<Pelicula> listaPeliculas) {
        super(contexto, R.layout.item_pelicula, listaPeliculas);
        this.contexto = contexto;
        this.listaPeliculas = listaPeliculas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View vista = inflater.inflate(R.layout.item_pelicula, null);

        ImageView imgPelicula = vista.findViewById(R.id.imgPelicula);
        TextView txtTitulo = vista.findViewById(R.id.txtTitulo);
        TextView txtGenero = vista.findViewById(R.id.txtGenero);

        Pelicula p = listaPeliculas.get(position);

        imgPelicula.setImageResource(p.getImagen());
        txtTitulo.setText(p.getTitulo());
        txtGenero.setText(p.getGenero());

        return vista;
    }
}