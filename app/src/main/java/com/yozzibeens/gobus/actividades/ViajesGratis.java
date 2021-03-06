package com.yozzibeens.gobus.actividades;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.yozzibeens.gobus.R;

/**
 * Created by Antonio on 27/12/2016.
 */

public class ViajesGratis extends AppCompatActivity {

    TextView txtCodigo;
    TextView txtComparteCodigo;
    TextView txtMensaje;
    TextView txtDetalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viajes_gratis);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorIcon));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));

        Typeface RobotoCondensed_Regular = Typeface.createFromAsset(getAssets(), "RobotoCondensed-Regular.ttf");

        txtCodigo = (TextView) findViewById(R.id.txtCodigo);
        txtCodigo.setTypeface(RobotoCondensed_Regular);
        txtComparteCodigo = (TextView) findViewById(R.id.txtComparteCodigo);
        txtComparteCodigo.setTypeface(RobotoCondensed_Regular);
        txtMensaje = (TextView) findViewById(R.id.txtMensaje);
        txtMensaje.setTypeface(RobotoCondensed_Regular);
        txtDetalles = (TextView) findViewById(R.id.txtDetalles);
        txtDetalles.setTypeface(RobotoCondensed_Regular);

        txtCodigo.setText("yb123");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
