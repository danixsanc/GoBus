package com.yozzibeens.gobus.app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.rengwuxian.materialedittext.MaterialEditText;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;
import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.actividades.FinalTicket;
import com.yozzibeens.gobus.actividades.Resultados;
import com.yozzibeens.gobus.adaptadores.AdaptadorAutobuses;
import com.yozzibeens.gobus.fragmentos.DrawerMenu;

import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class MainActivity extends AppCompatActivity implements
        View.OnClickListener,
        TimePickerDialog.OnTimeSetListener,
        com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener{

    private DrawerMenu mDrawerMenu;

    private LinearLayout calendarButton, hourButton;
    private TextView txtDate, txtHour;
    private FloatingActionButton btnBuscar;
    private ImageView imgCity;
    MaterialEditText edtOrigen,edtDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mDrawerMenu = (DrawerMenu) getSupportFragmentManager().findFragmentById(R.id.left_drawer);
        mDrawerMenu.setUp(R.id.left_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar, getSupportActionBar(), this);

        txtDate = (TextView) findViewById(R.id.txtDate);
        txtHour = (TextView) findViewById(R.id.txtHour);

        edtDestino = (MaterialEditText) findViewById(R.id.edtDestino);
        edtOrigen = (MaterialEditText) findViewById(R.id.edtOrigen);

        btnBuscar = (FloatingActionButton) findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificaDatos();
            }
        });

        txtDate=(TextView) findViewById(R.id.txtDate);
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                com.wdullaer.materialdatetimepicker.date.DatePickerDialog dpd =
                        com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(
                                MainActivity.this,
                                now.get(Calendar.YEAR),
                                now.get(Calendar.MONTH),
                                now.get(Calendar.DAY_OF_MONTH)
                        );
                dpd.setAccentColor(Color.parseColor("#14a3ab"));
                dpd.show(getFragmentManager(), "Datepickerdialog");

            }
        });

        txtHour=(TextView) findViewById(R.id.txtHour);
        txtHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        MainActivity.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),false
                );
            tpd.setAccentColor(Color.parseColor("#14a3ab"));
            tpd.show(getFragmentManager(), "Timepickerdialog");

            }
        });

        imgCity = (ImageView) findViewById(R.id.imgCity);
        imgCity.setAlpha(35);

    }

    public void verificaDatos()
    {

        if(edtOrigen.getText().toString().isEmpty())
        {
            SweetAlertDialog dialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE);
            dialog.setTitleText("Escoja su origen!").show();
        }
        else
            if(edtDestino.getText().toString().isEmpty())
            {
                SweetAlertDialog dialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE);
                dialog.setTitleText("Escoja su destino!").show();
            }
            else
                if(txtDate.getText().equals(""))
                {
                    SweetAlertDialog dialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE);
                    dialog.setTitleText("Escoja la fecha!").show();
                }
                else
                    if(txtHour.getText().equals(""))
                    {
                        SweetAlertDialog dialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE);
                        dialog.setTitleText("Escoja la hora!").show();
                    }
                    else
                    {
                        String origen = edtOrigen.getText().toString();
                        String destino = edtDestino.getText().toString();
                        String hora = txtHour.getText().toString();
                        String fecha = txtDate.getText().toString();

                        Intent intent=new Intent(this, Resultados.class);
                        intent.putExtra("origen",origen);
                        intent.putExtra("destino",destino);
                        intent.putExtra("hora",hora);
                        intent.putExtra("fecha",fecha);
                        startActivity(intent);

                        //startActivity(new Intent(MainActivity.this, Resultados.class));
                    }

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Calendar now = Calendar.getInstance();
        String fechaDespues = monthOfYear+"/"+dayOfMonth+"/"+year;

        String fecha = now.get(Calendar.MONTH)+"/"+now.get(Calendar.DAY_OF_MONTH)+"/"+now.get(Calendar.YEAR);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date converterDate = new Date();
        Date converterDate2 = new Date();

        try{
            converterDate = dateFormat.parse(fecha);
            converterDate2 = dateFormat.parse(fechaDespues);



            if(converterDate2.equals(converterDate) || converterDate2.after(converterDate))
            {
                String date = dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
                txtDate.setText(date);

            }
            else{
                SweetAlertDialog dialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE);
                dialog.setTitleText("No escoja fecha anterior a hoy!").show();
            }
        }
        catch(ParseException e){

        }

    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        Calendar now = Calendar.getInstance();

        String fechaDespues = (String) txtDate.getText();
        String fecha = now.get(Calendar.MONTH)+"/"+now.get(Calendar.DAY_OF_MONTH)+"/"+now.get(Calendar.YEAR);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date converterDate = new Date();
        Date converterDate2 = new Date();

        try{
            converterDate = dateFormat.parse(fecha);
            converterDate2 = dateFormat.parse(fechaDespues);
            if(converterDate2.after(converterDate))
            {
                if (String.valueOf(minute).length() == 1){
                    String time = hourOfDay+":0"+minute;
                    txtHour.setText(time);
                }
                else{
                    String time = hourOfDay+":"+minute;
                    txtHour.setText(time);
                }

            }
            else{
                SweetAlertDialog dialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE);
                dialog.setTitleText("No escoja hora anterior a la actual!").show();
            }
        }
        catch(ParseException e){

        }

    }
}

