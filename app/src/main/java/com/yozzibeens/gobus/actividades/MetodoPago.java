package com.yozzibeens.gobus.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metodo_pago);

        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MetodoPago.this, MainActivity.class));
            }
        });
    }


}
