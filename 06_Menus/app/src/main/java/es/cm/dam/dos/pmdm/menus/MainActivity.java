package es.cm.dam.dos.pmdm.menus;

import static es.cm.dam.dos.pmdm.menus.R.id.nav_inicio;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private TextView textoPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración de la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);

        // Configurar el botón hamburguesa
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Referencia al texto principal
        textoPrincipal = findViewById(R.id.textoPrincipal);

        // Registrar el menú contextual
        registerForContextMenu(textoPrincipal);

        // Manejo del panel de navegación
        navView.setNavigationItemSelectedListener(item -> {
            final int id = item.getItemId();
            if(id == nav_inicio) {
                textoPrincipal.setText("Has seleccionado: Inicio");
            }else if(id == R.id.nav_ayuda){
                textoPrincipal.setText("Has seleccionado: Ayuda");
            }else if(id == R.id.nav_acerca){
                textoPrincipal.setText("Has seleccionado: Acerca de");
            }
            drawerLayout.closeDrawers();
            return true;
        });
    }

    // -------- MENÚ DE OPCIONES --------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu){
        menu.findItem(R.id.opcion_configuracion).setEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opcion_configuracion) {
            Toast.makeText(this, "Configuración seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id== R.id.opcion_salir) {
            Toast.makeText(this, "Saliendo de la aplicación", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }

    // -------- MENÚ CONTEXTUAL --------
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final int id = item.getItemId();
        if(id == R.id.context_editar) {
            Toast.makeText(this, "Opción Editar seleccionada", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.context_eliminar) {
            Toast.makeText(this, "Opción Eliminar seleccionada", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}