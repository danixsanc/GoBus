package com.yozzibeens.gobus.app;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.fragmentos.DrawerMenu;

import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;


import java.util.Calendar;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class MainActivity extends AppCompatActivity implements
        View.OnClickListener,
        TimePickerDialog.OnTimeSetListener,
        com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener{

    private DrawerMenu mDrawerMenu;

    private LinearLayout calendarButton, hourButton;
    private TextView txtDate, txtHour;
    private TextView btnBuscar;

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

        btnBuscar = (TextView) findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(),"Si jala",Toast.LENGTH_SHORT);
                t.show();
            }
        });

        calendarButton=(LinearLayout) findViewById(R.id.calendarButton);
        calendarButton.setOnClickListener(new View.OnClickListener() {
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

        hourButton=(LinearLayout) findViewById(R.id.hourButton);
        hourButton.setOnClickListener(new View.OnClickListener() {
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

        }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Calendar now = Calendar.getInstance();
        if((dayOfMonth < now.get(Calendar.DAY_OF_MONTH))||
           (monthOfYear < now.get(Calendar.MONTH))      ||
           (year < now.get(Calendar.YEAR))){

            SweetAlertDialog dialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE);
            dialog.setTitleText("No escoja fecha anterior a hoy!").show();

        }else{
            String date = dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
            txtDate.setText(date);
        }

    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        if (String.valueOf(minute).length() == 1){
            String time = hourOfDay+":0"+minute;
            txtHour.setText(time);
        }
        else{
            String time = hourOfDay+":"+minute;
            txtHour.setText(time);
        }


    }
}

