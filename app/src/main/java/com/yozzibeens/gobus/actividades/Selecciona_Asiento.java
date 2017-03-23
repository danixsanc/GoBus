package com.yozzibeens.gobus.actividades;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.app.MainActivity;

/**
 * Created by Antonio on 13/03/2017.
 */

public class Selecciona_Asiento extends AppCompatActivity
{

    private LinearLayout asiento1,asiento2,asiento3,asiento4,asiento5,asiento6;
    private LinearLayout asiento7,asiento8,asiento9,asiento10,asiento11,asiento12;
    private LinearLayout asiento13,asiento14,asiento15,asiento16,asiento17,asiento18;
    private LinearLayout asiento19,asiento20,asiento21,asiento22,asiento23,asiento24;
    private TextView txtNumAsientos;
    private LinearLayout btnMenos, btnMas;
    private int cont=0;
    private Button btnSig;
    private String origen, destino, hora, fecha;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecciona_asiento);

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
        }
        catch (Exception e){

        }

        txtNumAsientos = (TextView) findViewById(R.id.txtNumAsientos);
        txtNumAsientos.setText(Integer.toString(cont));

        btnSig = (Button) findViewById(R.id.btnSig);
        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaDatos();
                Selecciona_Asiento.this.finish();
            }
        });

        btnMenos = (LinearLayout) findViewById(R.id.btnMenos);
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cont>0)
                    cont--;
                txtNumAsientos.setText(Integer.toString(cont));
            }
        });

        btnMas = (LinearLayout) findViewById(R.id.btnMas);
        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                txtNumAsientos.setText(Integer.toString(cont));
            }
        });

        asiento1 = (LinearLayout) findViewById(R.id.asiento1);
        asiento1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorAsiento = ((ColorDrawable)asiento1.getBackground()).getColor();
                int color = getResources().getColor(R.color.colorIcon);

                if(colorAsiento == color)
                    asiento1.setBackgroundDrawable(getResources().getDrawable(R.color.colorAccent));
                else
                    asiento1.setBackgroundDrawable(getResources().getDrawable(R.color.colorIcon));
            }
        });

        asiento2 = (LinearLayout) findViewById(R.id.asiento2);
        asiento2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorAsiento = ((ColorDrawable)asiento2.getBackground()).getColor();
                int color = getResources().getColor(R.color.colorIcon);

                if(colorAsiento == color)
                    asiento2.setBackgroundDrawable(getResources().getDrawable(R.color.colorAccent));
                else
                    asiento2.setBackgroundDrawable(getResources().getDrawable(R.color.colorIcon));
            }
        });

        asiento3 = (LinearLayout) findViewById(R.id.asiento3);
        asiento3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorAsiento = ((ColorDrawable)asiento3.getBackground()).getColor();
                int color = getResources().getColor(R.color.colorIcon);

                if(colorAsiento == color)
                    asiento3.setBackgroundDrawable(getResources().getDrawable(R.color.colorAccent));
                else
                    asiento3.setBackgroundDrawable(getResources().getDrawable(R.color.colorIcon));
            }
        });

        asiento4 = (LinearLayout) findViewById(R.id.asiento4);
        asiento4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorAsiento = ((ColorDrawable)asiento4.getBackground()).getColor();
                int color = getResources().getColor(R.color.colorIcon);

                if(colorAsiento == color)
                    asiento4.setBackgroundDrawable(getResources().getDrawable(R.color.colorAccent));
                else
                    asiento4.setBackgroundDrawable(getResources().getDrawable(R.color.colorIcon));

            }
        });
        asiento5 = (LinearLayout) findViewById(R.id.asiento5);
        asiento5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorAsiento = ((ColorDrawable)asiento5.getBackground()).getColor();
                int color = getResources().getColor(R.color.colorIcon);

                if(colorAsiento == color)
                    asiento5.setBackgroundDrawable(getResources().getDrawable(R.color.colorAccent));
                else
                    asiento5.setBackgroundDrawable(getResources().getDrawable(R.color.colorIcon));

            }
        });
        asiento6 = (LinearLayout) findViewById(R.id.asiento6);
        asiento6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorAsiento = ((ColorDrawable)asiento6.getBackground()).getColor();
                int color = getResources().getColor(R.color.colorIcon);

                if(colorAsiento == color)
                    asiento6.setBackgroundDrawable(getResources().getDrawable(R.color.colorAccent));
                else
                    asiento6.setBackgroundDrawable(getResources().getDrawable(R.color.colorIcon));

            }
        });
        asiento7 = (LinearLayout) findViewById(R.id.asiento7);
        asiento7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorAsiento = ((ColorDrawable)asiento7.getBackground()).getColor();
                int color = getResources().getColor(R.color.colorIcon);

                if(colorAsiento == color)
                    asiento7.setBackgroundDrawable(getResources().getDrawable(R.color.colorAccent));
                else
                    asiento7.setBackgroundDrawable(getResources().getDrawable(R.color.colorIcon));

            }
        });
        asiento8 = (LinearLayout) findViewById(R.id.asiento8);
        asiento8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorAsiento = ((ColorDrawable)asiento8.getBackground()).getColor();
                int color = getResources().getColor(R.color.colorIcon);

                if(colorAsiento == color)
                    asiento8.setBackgroundDrawable(getResources().getDrawable(R.color.colorAccent));
                else
                    asiento8.setBackgroundDrawable(getResources().getDrawable(R.color.colorIcon));

            }
        });
        asiento9 = (LinearLayout) findViewById(R.id.asiento9);
        asiento9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorAsiento = ((ColorDrawable)asiento9.getBackground()).getColor();
                int color = getResources().getColor(R.color.colorIcon);

                if(colorAsiento == color)
                    asiento9.setBackgroundDrawable(getResources().getDrawable(R.color.colorAccent));
                else
                    asiento9.setBackgroundDrawable(getResources().getDrawable(R.color.colorIcon));

            }
        });
        asiento10 = (LinearLayout) findViewById(R.id.asiento10);
        asiento10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorAsiento = ((ColorDrawable)asiento10.getBackground()).getColor();
                int color = getResources().getColor(R.color.colorIcon);

                if(colorAsiento == color)
                    asiento10.setBackgroundDrawable(getResources().getDrawable(R.color.colorAccent));
                else
                    asiento10.setBackgroundDrawable(getResources().getDrawable(R.color.colorIcon));

            }
        });
        asiento11 = (LinearLayout) findViewById(R.id.asiento11);
        asiento11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento12 = (LinearLayout) findViewById(R.id.asiento12);
        asiento12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento13 = (LinearLayout) findViewById(R.id.asiento13);
        asiento13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento14 = (LinearLayout) findViewById(R.id.asiento14);
        asiento14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento15 = (LinearLayout) findViewById(R.id.asiento15);
        asiento15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento16 = (LinearLayout) findViewById(R.id.asiento16);
        asiento16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento17 = (LinearLayout) findViewById(R.id.asiento17);
        asiento17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento18 = (LinearLayout) findViewById(R.id.asiento18);
        asiento18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento19 = (LinearLayout) findViewById(R.id.asiento19);
        asiento19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento20 = (LinearLayout) findViewById(R.id.asiento20);
        asiento20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento21 = (LinearLayout) findViewById(R.id.asiento21);
        asiento21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento22 = (LinearLayout) findViewById(R.id.asiento22);
        asiento22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento23 = (LinearLayout) findViewById(R.id.asiento23);
        asiento23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        asiento24 = (LinearLayout) findViewById(R.id.asiento24);
        asiento24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    public void enviaDatos(){
        Intent intent=new Intent(this, DatosPasajero.class);
        intent.putExtra("origen",origen);
        intent.putExtra("destino",destino);
        intent.putExtra("hora",hora);
        intent.putExtra("fecha",fecha);
        startActivity(intent);
    }
}
