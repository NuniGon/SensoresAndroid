package com.example.nuni.ldh1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button botonAcelerometro;
    Button botonGiroscopio;
    Button botonPodometro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /**
         * Se declara boton para el sensor ACELEROMETRO
         */
        botonAcelerometro = (Button) findViewById(R.id.button);
        botonAcelerometro.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                acelometer(v);
            }
        });

        /**
         * Se declara el boton para el sensor GIROSCOPIO
         */

        botonGiroscopio = (Button) findViewById(R.id.button2);
        botonGiroscopio.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                giroscopio(v);
            }
        });

        /**
         * Se declara boton para el sensor PODOMETRO
         */
        botonPodometro = (Button) findViewById(R.id.button3);
        botonPodometro.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                podometro(v);
            }
        });

    }

    /**
     * Añade elementos a la barra de acción si está presente
     * @param menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Coge el id , comprueba si está en los ajustes, si está return true, si no, retorna el item seleccionado en las opciones
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Función que crea el intent con la actividad del sensor proximidad y la inicia.
     * Se espera modificar cambios (Probando commits con jira...)
     * @param view
     */
    public void acelometer(View view) {
        Intent i = new Intent(this, Acelerometro.class);
        startActivity(i);
    }

    /**
     * Función que crea el intent con la actividad del sensor magnometro y la inicia.
     * @param view
     */
    public void giroscopio(View view) {
        Intent i = new Intent(this, Giroscopio.class);
        startActivity(i);
    }

    public void podometro(View view) {
        Intent i = new Intent(this, Podometro.class);
        startActivity(i);
    }
}
