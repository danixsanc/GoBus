package com.yozzibeens.gobus.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.app.MainActivity;

/**
 * Created by Antonio on 14/03/2017.
 */

public class MetodoPago extends AppCompatActivity
{
    private Button btnFinalizar;
    private String origen, destino, hora, fecha, nombre, apellido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metodo_pago);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try
        {
            Bundle extras = getIntent().getExtras();
            origen= extras.getString("origen");
            destino = extras.getString("destino");
            hora = extras.getString("hora");
            fecha = extras.getString("fecha");
            nombre = extras.getString("nombre");
            apellido = extras.getString("apellido");
        }
        catch (Exception e){

        }

        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaDatos();
            }
        });
    }

    public void enviaDatos(){
        Intent intent=new Intent(MetodoPago.this, FinalTicket.class);
        intent.putExtra("origen",origen);
        intent.putExtra("destino",destino);
        intent.putExtra("hora",hora);
        intent.putExtra("fecha",fecha);
        intent.putExtra("nombre",nombre);
        intent.putExtra("apellido",apellido);
        startActivity(intent);
    }


}
