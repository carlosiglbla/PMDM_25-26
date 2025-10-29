package es.cm.dam2.pmdm.recyclerview;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.cm.dam2.pmdm.recyclerview.data.Pelicula;

public class MainActivity extends AppCompatActivity implements RecyclerPelisInterface{

    private final List<Pelicula> dataPelis = new ArrayList<>();

    private AdaptadorPelis miAdaptadorPelis;

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
        miAdaptadorPelis = new AdaptadorPelis(dataPelis, this);
        rvPelis.setAdapter(miAdaptadorPelis);

        //añadir escucha de eventos
        rvPelis.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            final GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(@NonNull MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View hijo = rv.findChildViewUnder(e.getX(), e.getY());
                if(hijo != null && gestureDetector.onTouchEvent(e)){
                    int position = rv.getChildAdapterPosition(hijo);
                    Toast.makeText(getApplicationContext(),
                            dataPelis.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
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

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(),
                dataPelis.get(position).getAnio()+"", Toast.LENGTH_LONG).show();
    }

    public void onItemLongClick(int position){
        final String nombrePeli = dataPelis.get(position).getNombre();
        dataPelis.remove(position);
        miAdaptadorPelis.notifyItemRemoved(position);
        Toast.makeText(getApplicationContext(), nombrePeli+" ha sido borrada.",
                Toast.LENGTH_SHORT).show();
    }
}