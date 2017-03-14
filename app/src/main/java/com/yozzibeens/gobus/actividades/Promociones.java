package com.yozzibeens.gobus.actividades;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.yozzibeens.gobus.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Antonio on 27/12/2016.
 */

public class Promociones extends AppCompatActivity {

    MaterialEditText txtIngCodigo;
    Button btnAplicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promociones_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtIngCodigo = (MaterialEditText) findViewById(R.id.txtIngCodigo);
        btnAplicar = (Button) findViewById(R.id.btnAplicar);

        btnAplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txtIngCodigo.getText().toString().equals("")){
                    SweetAlertDialog a = new SweetAlertDialog(Promociones.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Ingrese código");
                    a.show();
                }
                else
                {
                    if(txtIngCodigo.getText().toString().equals("yb123"))
                    {
                        SweetAlertDialog a = new SweetAlertDialog(Promociones.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Código aplicado");
                        a.show();
                    }
                    else
                    {
                        SweetAlertDialog a = new SweetAlertDialog(Promociones.this, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("Código incorrecto");
                        a.show();
                    }
                }
            }
        });

    }
}
