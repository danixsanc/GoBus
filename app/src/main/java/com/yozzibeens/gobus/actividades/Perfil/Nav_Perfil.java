package com.yozzibeens.gobus.actividades.Perfil;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.yozzibeens.gobus.R;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by danixsanc on 12/01/2016.
 */
public class Nav_Perfil extends AppCompatActivity {

    TextView txt_phone_user;
    TextView txt_email_user;
    TextView txt_nombre_user;
    CircleImageView imgPerfilTaxista;
    Button btn_modifydata;
    TextView txt_datos_personales,txt_nombre;
    TextView txt_email,txt_phone,txt_switch;


    //-------------------------------------------------------
    //================NO SE SI OCUPES ESTOS==================
    //-------------------------------------------------------
    TextView textView1s0,textViasdew1s0,textViasdsdfew1s0;
    //=======================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_perfil);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //toolbar.getBackground().setAlpha(0);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorIcon));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));

        Typeface RobotoCondensed_Regular = Typeface.createFromAsset(getAssets(), "RobotoCondensed-Regular.ttf");

        /*txt_phone_user = (TextView) findViewById(R.id.txt_phone_user);
        txt_phone_user.setTypeface(RobotoCondensed_Regular);
        txt_email_user = (TextView) findViewById(R.id.txt_email_user);
        txt_email_user.setTypeface(RobotoCondensed_Regular);
        txt_nombre_user = (TextView) findViewById(R.id.txt_nombre_user);
        txt_nombre_user.setTypeface(RobotoCondensed_Regular);

        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_email.setTypeface(RobotoCondensed_Regular);
        txt_phone = (TextView) findViewById(R.id.txt_phone);
        txt_phone.setTypeface(RobotoCondensed_Regular);*/

        imgPerfilTaxista = (CircleImageView) findViewById(R.id.imgPerfilTaxista);

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
