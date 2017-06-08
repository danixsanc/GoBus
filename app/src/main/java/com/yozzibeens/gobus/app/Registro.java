package com.yozzibeens.gobus.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.yozzibeens.gobus.R;

/**
 * Created by Antonio on 30/05/2017.
 */

public class Registro extends Activity{

    private Button btn_crearCuenta;
    private MaterialAutoCompleteTextView txt_registroNombre,txt_registroCorreo,txt_registroPass,txt_registroRePass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        txt_registroNombre = (MaterialAutoCompleteTextView) findViewById(R.id.txt_registroNombre);
        txt_registroCorreo = (MaterialAutoCompleteTextView) findViewById(R.id.txt_registroCorreo);
        txt_registroPass = (MaterialAutoCompleteTextView) findViewById(R.id.txt_registroPass);
        txt_registroRePass = (MaterialAutoCompleteTextView) findViewById(R.id.txt_registroRePass);
        btn_crearCuenta = (Button) findViewById(R.id.btn_crearCuenta);
    }
}
