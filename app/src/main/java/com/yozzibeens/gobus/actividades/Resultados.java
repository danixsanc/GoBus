package com.yozzibeens.gobus.actividades;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.adaptadores.AdaptadorAutobuses;

import java.util.ArrayList;

/**
 * Created by Antonio on 23/11/2016.
 */

public class Resultados extends Activity {

    private AutobusesAdapter autobusesAdapter;
    private ListView autobusesList;
    ArrayList<AdaptadorAutobuses> autobusesArray = new ArrayList<AdaptadorAutobuses>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultados);

        autobusesArray.add(new AdaptadorAutobuses("GoBus", "3", "08:00 am"));
        autobusesArray.add(new AdaptadorAutobuses("GoBus", "3", "08:00 am"));
        autobusesArray.add(new AdaptadorAutobuses("GoBus", "3", "08:00 am"));
        autobusesArray.add(new AdaptadorAutobuses("GoBus", "3", "08:00 am"));
        autobusesArray.add(new AdaptadorAutobuses("GoBus", "3", "08:00 am"));
        autobusesArray.add(new AdaptadorAutobuses("GoBus", "3", "08:00 am"));

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
                holder.txtDisponibilidad = (TextView) row.findViewById(R.id.txtDisponibilidad);
                holder.txtSalida = (TextView) row.findViewById(R.id.txtSalida);
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
            }


            return row;

        }

        class UserHolder {
            TextView txtLinea;
            TextView txtDisponibilidad;
            TextView txtSalida;
        }
    }
}
