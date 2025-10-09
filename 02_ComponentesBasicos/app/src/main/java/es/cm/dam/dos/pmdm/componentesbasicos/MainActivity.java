package es.cm.dam.dos.pmdm.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private TextView textoResultado;
    private EditText campoTexto;
    private ProgressBar barraProgreso;
    private SeekBar seekBar;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los componentes
        TextView textoTitulo = findViewById(R.id.textoTitulo);
        textoResultado = findViewById(R.id.textoResultado);
        campoTexto = findViewById(R.id.campoTexto);
        Button boton = findViewById(R.id.boton);
        ImageView imagen = findViewById(R.id.imagen);
        ImageButton botonImagen = findViewById(R.id.botonImagen);
        CheckBox checkBox = findViewById(R.id.checkBox);
        RadioButton radio1 = findViewById(R.id.radio1);
        RadioButton radio2 = findViewById(R.id.radio2);
        ToggleButton toggle = findViewById(R.id.toggle);
        SwitchCompat interruptor = findViewById(R.id.interruptor);
        barraProgreso = findViewById(R.id.barraProgreso);
        seekBar = findViewById(R.id.seekBar);
        ratingBar = findViewById(R.id.ratingBar);

        // Button
        boton.setOnClickListener(v -> textoResultado.setText("Has escrito: " + campoTexto.getText()));

        // ImageButton
        botonImagen.setOnClickListener(v -> textoResultado.setText("¡Has pulsado el botón de imagen!"));

        // CheckBox
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) textoResultado.setText("CheckBox activado");
            else textoResultado.setText("CheckBox desactivado");
        });

        // RadioButtons
        radio1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) textoResultado.setText("Opción 1 seleccionada");
        });
        radio2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) textoResultado.setText("Opción 2 seleccionada");
        });

        // ToggleButton
        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            textoResultado.setText(isChecked ? "Toggle: ACTIVADO" : "Toggle: DESACTIVADO");
        });

        // Switch
        interruptor.setOnCheckedChangeListener((buttonView, isChecked) -> {
            textoResultado.setText(isChecked ? "Interruptor activado" : "Interruptor desactivado");
        });

        // SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                barraProgreso.setProgress(progress);
                textoResultado.setText("Progreso: " + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // RatingBar
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                textoResultado.setText("Valoración: " + rating + " estrellas"));
    }
}
