package es.ies.claudiomoyano.dam2.pmdm.seleccionasignaturas;

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

    private final String [] asignaturasJava = new String[]{"Programación", "BBDD", "PMDM", "Acceso a datos", "PSYP"};

    private Spinner spinnerArrayJava, spinnerArrayXML;
    private ListView listViewJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinnerArrayJava = findViewById(R.id.spinnerAsignaturasJava);
        spinnerArrayXML = findViewById(R.id.spinnerAsignaturasXML);

        listViewJava = findViewById(R.id.listViewAsignaturas);

        ArrayAdapter<String> adaptadorJavaSpinner = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                asignaturasJava);
        ArrayAdapter<CharSequence> adaptadorXMLSpinner = ArrayAdapter.createFromResource(
                this,
                R.array.asignaturasXML,
                android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adaptadorJavaListView = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_2,
                asignaturasJava);
        //asiganar adaptador al selector
        spinnerArrayJava.setAdapter(adaptadorJavaSpinner);
        spinnerArrayXML.setAdapter(adaptadorXMLSpinner);
        listViewJava.setAdapter(adaptadorJavaListView);
        //Listener
        spinnerArrayJava.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Seleccionado "+parent.getAdapter().getItem(position)
                        , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        listViewJava.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Seleccionado "+parent.getAdapter().getItem(position),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}