package es.cm.dam2.pmdm.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.cm.dam2.pmdm.recyclerview.data.Pelicula;

public class AdaptadorPelis extends RecyclerView.Adapter<AdaptadorPelis.PelisViewHolder> {
    private List<Pelicula> dataPelis;

    public static class PelisViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombrePelicula;
        public TextView anioPelicula;
        public PelisViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.caratula);
            nombrePelicula = itemView.findViewById(R.id.nombrePeli);
            anioPelicula = itemView.findViewById(R.id.anioPeli);
        }
    }

    public AdaptadorPelis(List<Pelicula> pelis){
        this.dataPelis = pelis;
    }

    @NonNull
    @Override
    public PelisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        View inflate = from.inflate(R.layout.item_peli, parent, false);
        return new PelisViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PelisViewHolder holder, int position) {
        Pelicula peli = this.dataPelis.get(position);
        holder.nombrePelicula.setText(peli.getNombre());
        holder.anioPelicula.setText(peli.getAnio().toString());
        holder.imagen.setImageDrawable(
                holder.imagen.getContext().getDrawable(peli.getRecursoImagen()));
    }

    @Override
    public int getItemCount() {
        return this.dataPelis.size();
    }
}
