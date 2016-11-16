package com.yozzibeens.gobus.fragmentos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Antonio on 15/11/2016.
 */

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    TextView txtDate;
    public DateDialog(View view){
        txtDate=(TextView) view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar calendario= Calendar.getInstance();
        int anio=calendario.get(Calendar.YEAR);
        int mes=calendario.get(Calendar.MONTH);
        int dia=calendario.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,anio,mes,dia);
    }

    @Override
    public void onDateSet(DatePicker view, int anio, int mes, int dia) {
        String date=dia+"-"+(mes+1)+"-"+anio;
        txtDate.setText(date);
    }
}
