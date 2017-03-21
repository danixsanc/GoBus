package com.yozzibeens.gobus.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.app.MainActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Antonio on 14/03/2017.
 */

public class DatosPasajero  extends AppCompatActivity
{

    private Button btnPagar;
    private MaterialEditText edtNombrePas, edtApellidoPas;
    private String origen, destino, hora, fecha;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_pasajero);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtNombrePas = (MaterialEditText) findViewById(R.id.edtNombrePas);
        edtApellidoPas = (MaterialEditText) findViewById(R.id.edtApellidoPas);

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

        btnPagar = (Button) findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificaDatos();
            }
        });
    }

    public void verificaDatos(){
        if(edtNombrePas.getText().toString().isEmpty())
        {
            SweetAlertDialog dialog = new SweetAlertDialog(DatosPasajero.this, SweetAlertDialog.WARNING_TYPE);
            dialog.setTitleText("Ingrese el nombre!").show();
        }
        else
            if(edtApellidoPas.getText().toString().isEmpty())
            {
                SweetAlertDialog dialog = new SweetAlertDialog(DatosPasajero.this, SweetAlertDialog.WARNING_TYPE);
                dialog.setTitleText("Ingrese el apellido!").show();
            }
            else
            {
                String nombre = edtNombrePas.getText().toString();
                String apellido = edtApellidoPas.getText().toString();

                Intent intent=new Intent(this, MetodoPago.class);
                intent.putExtra("origen",origen);
                intent.putExtra("destino",destino);
                intent.putExtra("hora",hora);
                intent.putExtra("fecha",fecha);
                intent.putExtra("nombre",nombre);
                intent.putExtra("apellido",apellido);
                startActivity(intent);
            }

    }
}
