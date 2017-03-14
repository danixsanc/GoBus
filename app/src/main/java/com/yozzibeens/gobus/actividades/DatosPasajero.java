package com.yozzibeens.gobus.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yozzibeens.gobus.R;

/**
 * Created by Antonio on 14/03/2017.
 */

public class DatosPasajero  extends AppCompatActivity
{

    private Button btnPagar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_pasajero);

        btnPagar = (Button) findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DatosPasajero.this, MetodoPago.class));
            }
        });
    }
}
