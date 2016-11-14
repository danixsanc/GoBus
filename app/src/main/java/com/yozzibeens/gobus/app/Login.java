package com.yozzibeens.gobus.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.yozzibeens.gobus.R;

/**
 * Created by Antonio on 04/11/2016.
 */

public class Login extends Activity{

    private Button btnLogin;
    private Button btnOlvidePass;
    private MaterialEditText inputEmail;
    private MaterialEditText inputPassword;
    private TextView loginErrorMsg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                /*String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                SolicitudLogin oData = new SolicitudLogin();
                oData.setEmail(email);
                oData.setPassword(password);
                oData.setGcm_Id(regId);
                oData.setUser_Type("1");
                LoginWebService(gson.toJson(oData));*/

                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
                finish();
            }


        });
    }
}
