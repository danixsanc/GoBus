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
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.adaptadores.AdaptadorAutobuses;
import com.yozzibeens.gobus.app.MainActivity;

import java.util.ArrayList;

/**
 * Created by Antonio on 23/11/2016.
 */

public class Resultados extends AppCompatActivity {

    private AutobusesAdapter autobusesAdapter;
    private ListView autobusesList;
    private Button btnContinuar;
    ArrayList<AdaptadorAutobuses> autobusesArray = new ArrayList<AdaptadorAutobuses>();
    Typeface RobotoCondensed_Bold, RobotoCondensed_Regular;

    String origen, destino, hora, fecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultados);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        RobotoCondensed_Bold = Typeface.createFromAsset(getAssets(), "RobotoCondensed-Bold.ttf");
        RobotoCondensed_Regular = Typeface.createFromAsset(getAssets(), "RobotoCondensed-Regular.ttf");

        autobusesAdapter = new AutobusesAdapter(getApplicationContext(), R.layout.row_resultados, autobusesArray);
        autobusesList = (ListView) findViewById(R.id.listView);
        autobusesList.setItemsCanFocus(false);
        autobusesList.setAdapter(autobusesAdapter);

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

        autobusesArray.add(new AdaptadorAutobuses("TAP", "3"    , origen, destino, hora,"4:00 Hrs","$110", getResources().getDrawable(R.drawable.tap)));
        autobusesArray.add(new AdaptadorAutobuses("Tufesa", "6" , origen, destino, hora,"15:30 Hrs","$740",getResources().getDrawable(R.drawable.tufesa)));
        autobusesArray.add(new AdaptadorAutobuses("AUS", "2"    , origen, destino, hora,"3:10 Hrs","$140",getResources().getDrawable(R.drawable.aus)));
        autobusesArray.add(new AdaptadorAutobuses("TAP", "5"    , origen, destino, hora,"8:00 Hrs","$650",getResources().getDrawable(R.drawable.tap)));
        autobusesArray.add(new AdaptadorAutobuses("AUS", "3"    , origen, destino, hora,"2:00 Hrs","$115",getResources().getDrawable(R.drawable.aus)));
        autobusesArray.add(new AdaptadorAutobuses("Tufesa", "7" , origen, destino, hora,"6:15 Hrs","$200",getResources().getDrawable(R.drawable.tufesa)));


    }

    public void enviaDatos(){
        Intent intent=new Intent(this, Selecciona_Asiento.class);
        intent.putExtra("origen",origen);
        intent.putExtra("destino",destino);
        intent.putExtra("hora",hora);
        intent.putExtra("fecha",fecha);
        startActivity(intent);
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

                holder.btnShop = (ImageView) row.findViewById(R.id.btnShop);
                holder.btnShop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        enviaDatos();
                        Resultados.this.finish();
                    }
                });

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
            ImageView btnShop;
        }
    }
}
