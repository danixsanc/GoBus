package com.yozzibeens.gobus.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
    private ProgressDialog progressdialog;
    private Gson gson;
    private Button btnOlvidePass;
    private MaterialEditText inputEmail;
    private MaterialEditText inputPassword;
    private TextView loginErrorMsg;
    private ResultadoLogin resultadoLogin;
    private UserController userController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        this.userController = new UserController(this);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignup = (Button) findViewById(R.id.btnSignup);

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
               progressdialog.dismiss();
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
                progressdialog.dismiss();
            }
        });
        servicioAsyncService.execute();
    }
}
