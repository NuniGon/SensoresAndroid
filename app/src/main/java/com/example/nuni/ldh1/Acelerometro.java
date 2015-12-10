package com.example.nuni.ldh1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public  class Acelerometro extends AppCompatActivity implements SensorEventListener {
    /** The texto. */
    TextView texto;

    /** The sensor manager. */
    SensorManager sensorManager;

    /** The accelerometer. */
    private Sensor accelerometer;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
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

        texto = (TextView)findViewById(R.id.texto);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            /*List<Sensor> mList = sensorManager.getSensorList(Sensor.TYPE_ALL);

            for (int i=1 ; i<mList.size() ; i++)
                texto.append("\n" +mList.get(i).getName()+ "\n" +mList.get(i).getVendor()+ "\n" +mList.get(i).getVersion());
            */

    }

    /**
     * On create options menu.
     *
     * @param menu the menu
     * @return true, if successful
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * On options item selected.
     *
     * @param item the item
     * @return true, if successful
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * On sensor changed.
     *
     * @param event the event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x,y,z, m,n,o;
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];

        texto.setText(" Acelerometro");
        texto.append("\n" + " Valor de X: " + x +" m/s "+ "\n" + " Valor de Y: " + y +" m/s "+  "\n" + " Valor de Z: " + z + " m/s ");


    }

    /**
     * On accuracy changed.
     *
     * @param sensor the sensor
     * @param accuracy the accuracy
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
     * On resume.
     */
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**
     * On pause.
     */
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}