package es.cm.dam2.pmdm.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.cm.dam2.pmdm.recyclerview.data.Pelicula;

public class MainActivity extends AppCompatActivity {

    private final List<Pelicula> dataPelis = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initData();
        RecyclerView rvPelis = findViewById(R.id.rvPeliculas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvPelis.setLayoutManager(linearLayoutManager);
        AdaptadorPelis miAdaptadorPelis = new AdaptadorPelis(dataPelis);
        rvPelis.setAdapter(miAdaptadorPelis);
    }

    private void initData() {
        dataPelis.add(new Pelicula("Cadena perpetua", 2001, R.drawable.cadena_perpetua));
        dataPelis.add(new Pelicula("Shrek 2", 2005, R.drawable.shrek2));
        dataPelis.add(new Pelicula("Aladdin", 2003, R.drawable.aladdin));
        dataPelis.add(new Pelicula("El amor en su lugar", 2002, R.drawable.love_gets_a_room));
        dataPelis.add(new Pelicula("Escape", 2021, R.drawable.escape));
        dataPelis.add(new Pelicula("Buried", 2024, R.drawable.buried));
        dataPelis.add(new Pelicula("Hable con ella", 2000, R.drawable.hable_con_ella));
        dataPelis.add(new Pelicula("Piratas del caribe", 1999, R.drawable.pirates_of_the_caribbean));
        dataPelis.add(new Pelicula("Kill Bill Vol.1", 2000, R.drawable.kill_bill_volume_1));
        dataPelis.add(new Pelicula("Kill Bill Vol.2", 2006,R.drawable.kill_bill_volume_2));
        dataPelis.add(new Pelicula("Pulp Fiction", 2007, R.drawable.pulp_fiction));
    }
}