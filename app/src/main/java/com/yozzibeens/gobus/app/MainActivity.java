package com.yozzibeens.gobus.app;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.fragmentos.DrawerMenu;

public class MainActivity extends AppCompatActivity {

    private DrawerMenu mDrawerMenu;

    LinearLayout boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerMenu = (DrawerMenu) getSupportFragmentManager().findFragmentById(R.id.left_drawer);
        mDrawerMenu.setUp(R.id.left_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar, getSupportActionBar(), this);


        boton = (LinearLayout) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

            }
        });
    }
}
