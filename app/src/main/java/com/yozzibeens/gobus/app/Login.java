package com.yozzibeens.gobus.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.yozzibeens.gobus.R;
import com.yozzibeens.gobus.controlador.UserController;
import com.yozzibeens.gobus.listener.AsyncTaskListener;
import com.yozzibeens.gobus.listener.ServicioAsyncService;
import com.yozzibeens.gobus.respuesta.ResultadoLogin;
import com.yozzibeens.gobus.servicios.webservices;
import com.yozzibeens.gobus.solicitud.SolicitudLogin;
import com.yozzibeens.gobus.utilerias.Preferencias;

import java.util.HashMap;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Antonio on 04/11/2016.
 */

public class Login extends Activity{

    private Button btnLogin,btnSignup;
    private SweetAlertDialog pDialog;
    private Gson gson;
    private Button btnOlvidePass;
    private MaterialEditText inputEmail;
    private MaterialEditText inputPassword;
    private TextView loginErrorMsg;
    private ResultadoLogin resultadoLogin;
    private UserController userController;
    private Typeface RobotoCondensed_Regular;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        this.userController = new UserController(this);
        this.gson = new Gson();

        this.RobotoCondensed_Regular = Typeface.createFromAsset(getAssets(), "RobotoCondensed-Regular.ttf");

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setTypeface(RobotoCondensed_Regular);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        btnSignup.setTypeface(RobotoCondensed_Regular);

        inputEmail = (MaterialEditText) findViewById(R.id.loginEmail);
        inputEmail.setTypeface(RobotoCondensed_Regular);
        inputPassword = (MaterialEditText) findViewById(R.id.loginPassword);
        inputPassword.setTypeface(RobotoCondensed_Regular);

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                SolicitudLogin oData = new SolicitudLogin();
                oData.setEmail(email);
                oData.setPassword(password);
                LoginWebService(gson.toJson(oData));

                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
                finish();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent registro = new Intent(getApplicationContext(), Registro.class);
                startActivity(registro);
                finish();
            }


        });
    }

    private void LoginWebService(String rawJson) {
        ServicioAsyncService servicioAsyncService = new ServicioAsyncService(this, webservices.LoginWebService, rawJson);
        servicioAsyncService.setOnCompleteListener(new AsyncTaskListener() {
            @Override
            public void onTaskStart() {
                /*
                progressdialog = new ProgressDialog(Login.this);
                progressdialog.setMessage("Iniciando, espere");
                progressdialog.setCancelable(true);
                progressdialog.setCanceledOnTouchOutside(false);
                progressdialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        progressdialog.dismiss();
                    }
                });
                progressdialog.show();
                pDialog = new SweetAlertDialog(Login.this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("Iniciando");
                pDialog.setCancelable(false);
                pDialog.show();*/
            }

            @Override
            public void onTaskDownloadedFinished(HashMap<String, Object> result) {
                try {
                    int statusCode = Integer.parseInt(result.get("StatusCode").toString());
                    if (statusCode == 0) {
                        resultadoLogin = gson.fromJson(result.get("Resultado").toString(), ResultadoLogin.class);
                    }
                }
                catch (Exception error) {
                    String messageError = "Ocurrio un error inesperado";
                    SweetAlertDialog dialog = new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE);
                    dialog.setContentText(messageError)
                            .show();

                }
            }

            @Override
            public void onTaskUpdate(String result) {

            }


            @Override
            public void onTaskComplete(HashMap<String, Object> result) {
                //pDialog.dismiss();
                if ((!resultadoLogin.isError()) && resultadoLogin.getData() != null) {

                    userController.eliminarTodo();
                    userController.guardarOActualizarUser(resultadoLogin.getData());

                    Preferencias preferencias = new Preferencias(getApplicationContext());
                    Long clientId = resultadoLogin.getData().getUser_Id();
                    preferencias.setCabbie_Id(clientId);
                    preferencias.setSesion(false);

                    Intent main = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(main);
                    finish();
                }
                else if (resultadoLogin.isError())
                {
                    String messageError = resultadoLogin.getMessage();
                    SweetAlertDialog dialog = new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE);
                    dialog.setContentText(messageError)
                            .show();

                    /*AlertDialog.Builder dialog = new AlertDialog.Builder(Login.this, R.style.AlertDialogStyle);
                    dialog.setMessage(messageError);
                    dialog.setCancelable(true);
                    dialog.setNegativeButton("OK", new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int which)
                        {
                            dialog.cancel();
                        }
                    });
                    dialog.show();*/
                }
            }

            @Override
            public void onTaskCancelled(HashMap<String, Object> result) {
                pDialog.dismiss();
            }
        });
        servicioAsyncService.execute();
    }
}
