package com.yozzibeens.gobus.actividades;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.adaptadores.AdaptadorAutobuses;

import java.util.ArrayList;

/**
 * Created by Antonio on 23/11/2016.
 */

public class Resultados extends AppCompatActivity {

    private AutobusesAdapter autobusesAdapter;
    private ListView autobusesList;
    ArrayList<AdaptadorAutobuses> autobusesArray = new ArrayList<AdaptadorAutobuses>();
    Typeface RobotoCondensed_Bold, RobotoCondensed_Regular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultados);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RobotoCondensed_Bold = Typeface.createFromAsset(getAssets(), "RobotoCondensed-Bold.ttf");
        RobotoCondensed_Regular = Typeface.createFromAsset(getAssets(), "RobotoCondensed-Regular.ttf");

        autobusesArray.add(new AdaptadorAutobuses("TAP", "3", "Terminal Culiacán","Terminal Mazatlán","08:00 am","4:00 Hrs","$110", getResources().getDrawable(R.drawable.tap)));
        autobusesArray.add(new AdaptadorAutobuses("Tufesa", "6", "Terminal Tijuana","Terminal Mochis", "08:00 am","15:30 Hrs","$740",getResources().getDrawable(R.drawable.tufesa)));
        autobusesArray.add(new AdaptadorAutobuses("AUS", "2", "Terminal Mochis","Terminal Culiacan", "08:00 am","3:10 Hrs","$140",getResources().getDrawable(R.drawable.aus)));
        autobusesArray.add(new AdaptadorAutobuses("TAP", "5", "Terminal Obregón","Terminal Mazatlán","08:00 am","8:00 Hrs","$650",getResources().getDrawable(R.drawable.tap)));
        autobusesArray.add(new AdaptadorAutobuses("AUS", "3", "Terminal Guasave","Terminal Culiacán","08:00 am","2:00 Hrs","$115",getResources().getDrawable(R.drawable.aus)));
        autobusesArray.add(new AdaptadorAutobuses("Tufesa", "7", "Terminal Mochis","Terminal Mazatlán","08:00 am","6:15 Hrs","$200",getResources().getDrawable(R.drawable.tufesa)));

        autobusesAdapter = new AutobusesAdapter(getApplicationContext(), R.layout.row_resultados, autobusesArray);
        autobusesList = (ListView) findViewById(R.id.listView);
        autobusesList.setItemsCanFocus(false);
        autobusesList.setAdapter(autobusesAdapter);
    }

    public class AutobusesAdapter extends ArrayAdapter<AdaptadorAutobuses> {
        Context context;
        int layoutResourceId;
        ArrayList<AdaptadorAutobuses> data = new ArrayList<AdaptadorAutobuses>();

        public AutobusesAdapter(Context context, int layoutResourceId,
                                    ArrayList<AdaptadorAutobuses> data) {
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View row = convertView;
            UserHolder holder = null;


            if (row == null) {

                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);
                holder = new UserHolder();
                holder.txtLinea = (TextView) row.findViewById(R.id.txtLinea);
                holder.txtLinea.setTypeface(RobotoCondensed_Regular);
                holder.txtDisponibilidad = (TextView) row.findViewById(R.id.txtDisponibilidad);
                holder.txtDisponibilidad.setTypeface(RobotoCondensed_Regular);
                holder.txtAsientos = (TextView) row.findViewById(R.id.txtAsientos);
                holder.txtAsientos.setTypeface(RobotoCondensed_Regular);
                holder.txtSalida = (TextView) row.findViewById(R.id.txtSalida);
                holder.txtSalida.setTypeface(RobotoCondensed_Regular);
                holder.txtDestino = (TextView) row.findViewById(R.id.txtDestino);
                holder.txtDestino.setTypeface(RobotoCondensed_Regular);
                holder.txtHora = (TextView) row.findViewById(R.id.txtHora);
                holder.txtHora.setTypeface(RobotoCondensed_Bold);
                holder.txtPrecio = (TextView) row.findViewById(R.id.txtPrecio);
                holder.txtPrecio.setTypeface(RobotoCondensed_Bold);
                holder.txtTiempo = (TextView) row.findViewById(R.id.txtTiempo);
                holder.txtTiempo.setTypeface(RobotoCondensed_Regular);

                holder.Fondo = (ImageView) row.findViewById(R.id.list_row_image);
                holder.Fondo.setAlpha(25);
                //holder.btnDelete = (ImageButton) row.findViewById(R.id.button2);
                row.setTag(holder);

                final UserHolder finalHolder = holder;
                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Intent login = new Intent(Nav_Historial.this, Historial_Detalle.class);
                        //String request_id=finalHolder.txtIdHistorial.getText().toString();
                        //login.putExtra("request_id", request_id);
                        //startActivity(login);
                    }
                });

            } else {
                holder = (UserHolder) row.getTag();
            }


            if (holder != null)
            {
                AdaptadorAutobuses autobus = data.get(position);
                holder.txtLinea.setText(autobus.getNombreLinea());
                holder.txtDisponibilidad.setText(autobus.getDisponibilidad());
                holder.txtSalida.setText(autobus.getSalida());
                holder.txtDestino.setText(autobus.getDestino());
                holder.txtHora.setText(autobus.getHora());
                holder.txtPrecio.setText(autobus.getPrecio());
                holder.txtTiempo.setText(autobus.getTiempo());
                holder.Fondo.setImageDrawable(autobus.getLogo());
            }


            return row;

        }

        class UserHolder {
            TextView txtLinea;
            TextView txtDisponibilidad, txtAsientos;
            TextView txtSalida;
            ImageView Fondo;
            TextView txtDestino;
            TextView txtHora;
            TextView txtPrecio;
            TextView txtTiempo;
        }
    }
}
