package es.cm.dam.dos.pmdm.vistaspersonalizadas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPeliculas;
    private ArrayList<Pelicula> peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPeliculas = findViewById(R.id.listViewPeliculas);

        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("Inception", "Ciencia ficción", R.mipmap.ic_launcher));
        peliculas.add(new Pelicula("Gladiator", "Acción / Drama", R.mipmap.ic_launcher));
        peliculas.add(new Pelicula("Titanic", "Romance", R.mipmap.ic_launcher));
        peliculas.add(new Pelicula("Matrix", "Acción / Ciencia ficción", R.mipmap.ic_launcher));

        AdaptadorPelicula adaptador = new AdaptadorPelicula(this, peliculas);
        listViewPeliculas.setAdapter(adaptador);

        listViewPeliculas.setOnItemClickListener((parent, view, position, id) -> {
            Pelicula seleccionada = peliculas.get(position);
            Toast.makeText(this, "Has elegido: " + seleccionada.getTitulo(), Toast.LENGTH_SHORT).show();
        });
    }
}