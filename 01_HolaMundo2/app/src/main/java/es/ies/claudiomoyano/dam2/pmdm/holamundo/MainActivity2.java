package es.ies.claudiomoyano.dam2.pmdm.holamundo;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Opción 1
public class MainActivity2 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d(this.getLocalClassName(), "Estamos en OnCreate");
        //Button miBoton = findViewById(R.id.button);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(this.getLocalClassName(), "Estamos en OnStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(this.getLocalClassName(), "Estamos en OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(this.getLocalClassName(), "Estamos en OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(this.getLocalClassName(), "Estamos en Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(this.getLocalClassName(), "Estamos en Stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(this.getLocalClassName(), "Estamos en OnResume");
    }
}