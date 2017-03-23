package com.yozzibeens.gobus.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.app.MainActivity;

import java.util.Random;

/**
 * Created by Antonio on 20/03/2017.
 */

public class FinalTicket extends AppCompatActivity
{
    private Button btnOkFinal;
    private String hora, fecha, nombre, apellido, origen, destino;
    private TextView txtNumOrden,txtFechaTicket,txtHoraTicket,txtNombreTicket,origenTicket,destinoTicket;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_ticket);

        try
        {
            Bundle extras = getIntent().getExtras();
            hora = extras.getString("hora");
            fecha = extras.getString("fecha");
            nombre = extras.getString("nombre");
            apellido = extras.getString("apellido");
            origen = extras.getString("origen");
            destino = extras.getString("destino");
        }
        catch (Exception e){

        }

        int orden = (int) (Math.random()*2345+1);

        txtNumOrden = (TextView) findViewById(R.id.txtNumOrden);
        txtNumOrden.setText(Integer.toString(orden));
        txtFechaTicket = (TextView) findViewById(R.id.txtFechaTicket);
        txtFechaTicket.setText(fecha);
        txtHoraTicket = (TextView) findViewById(R.id.txtHoraTicket);
        txtHoraTicket.setText(hora);
        origenTicket = (TextView) findViewById(R.id.origenTicket);
        origenTicket.setText(origen);
        destinoTicket = (TextView) findViewById(R.id.destinoTicket);
        destinoTicket.setText(destino);
        txtNombreTicket = (TextView) findViewById(R.id.txtNombreTicket);
        txtNombreTicket.setText(nombre+" "+apellido);


        btnOkFinal = (Button) findViewById(R.id.btnOkFinal);
        btnOkFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enviaDatos();
                //startActivity(new Intent(FinalTicket.this,MainActivity.class));
                FinalTicket.this.finish();
            }
        });
    }

    public void enviaDatos(){
        Intent intent=new Intent(this, MainActivity.class);
        intent.putExtra("origen",origen);
        intent.putExtra("destino",destino);
        intent.putExtra("hora",hora);
        intent.putExtra("fecha",fecha);
    }
}
