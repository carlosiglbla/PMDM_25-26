package es.ies.claudiomoyano.dam2.pmdm.componentesseleccion;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String[] peliculas = new String[]{"Cadena perpetua", "El padrino", "El caballero oscuro",
            "El padrino II", "12 hombres sin piedad"};
    private final String[] series =  new String[]{"Breaking Bad", "Planeta Tierra II", "Planeta Tierra",
            "Hermanos de sangre", "Chernobyl", "The Wire", "Avatar: La leyenda de Aang",
            "Los Soprano", "Killing Eve", "Bluey"};

    private Spinner spinnerCategorias;
    private ListView listViewItems;

    // Datos para el Spinner
    private final String[] categorias = {"Películas", "Series"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinnerCategorias = findViewById(R.id.spinnerCategorias);
        listViewItems = findViewById(R.id.listViewItems);

        // Adaptador para el Spinner
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categorias);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorias.setAdapter(adaptadorSpinner);

        // Al seleccionar categoría en el Spinner
        spinnerCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (categorias[position].equals("Películas")) {
                    cargarLista(peliculas);
                } else {
                    cargarLista(series);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se hace nada
            }
        });

        // Al pulsar un elemento del ListView
        listViewItems.setOnItemClickListener((parent, view, position, id) -> {
            String elemento = (String) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "Click en: " + elemento, Toast.LENGTH_SHORT).show();
        });
    }

    // Metodo auxiliar para cargar el ListView
    private void cargarLista(String[] datos) {
        ArrayAdapter<String> adaptadorLista = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);
        listViewItems.setAdapter(adaptadorLista);
    }
}