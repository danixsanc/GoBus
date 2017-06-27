package com.yozzibeens.gobus.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;
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

import java.io.IOException;
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
    private GoogleCloudMessaging gcm;
    private Context context;
    private String regId;
    private static final String TAG = "Register Activity";
    private static final String REG_ID = "regId";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        resultadoLogin = new ResultadoLogin();

        this.userController = new UserController(getApplicationContext());
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

        this.context = getApplication();
        this.regId = registerGCM();

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

                /*Intent intent=new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                Login.this.finish();*/
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
                pDialog.setTitleText("Iniciando...");
                pDialog.setCancelable(false);
                pDialog.show();*/
            }

            @Override
            public void onTaskDownloadedFinished(HashMap<String, Object> result) {
                try {
                    int statusCode = Integer.parseInt(result.get("StatusCode").toString());
                    Log.d("CHAYO ME LA PELA", statusCode+"");
                    if (statusCode == 0) {
                        resultadoLogin = gson.fromJson(result.get("Resultado").toString(), ResultadoLogin.class);
                        Log.d("Resultado de chayo JOTO",resultadoLogin.isError()+"");
                    }
                }
                catch (Exception error) {
                    String messageError = "Ocurrio un error inesperado";
                    /*SweetAlertDialog dialog = new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE);
                    dialog.setContentText(messageError)
                            .show();*/

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
                    String userId = resultadoLogin.getData().getUser_Id();
                    preferencias.setUser_Id(userId);
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
                else{
                    SweetAlertDialog dialog = new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE);
                    dialog.setContentText("NULO Pinchi kk")
                            .show();
                }

            }

            @Override
            public void onTaskCancelled(HashMap<String, Object> result) {
                pDialog.dismiss();
            }
        });
        servicioAsyncService.execute();
    }

    public String registerGCM() {

        gcm = GoogleCloudMessaging.getInstance(this);
        regId = getRegistrationId(context);

        if (TextUtils.isEmpty(regId)) {

            registerInBackground();

            Log.d("Registro",
                    "registerGCM - successfully registered with GCM server - regId: "
                            + regId);
        } else {
            //Toast.makeText(getApplicationContext(), "RegId already available. RegId: " + regId, Toast.LENGTH_LONG).show();
            System.out.print("RegId already available. RegId: " + regId);
        }
        return regId;
    }

    private String getRegistrationId(Context context) {
        final SharedPreferences prefs = getSharedPreferences(
                Splash.class.getSimpleName(), Context.MODE_PRIVATE);
        String registrationId = prefs.getString(REG_ID, "");
        if (registrationId.isEmpty()) {
            Log.i(TAG, "Registration not found.");
            return "";
        }
        return registrationId;
    }

    private void registerInBackground() {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        Toast.makeText(context, "Listo", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(context, "!!!!!", Toast.LENGTH_LONG).show();
                        break;
                }
                super.handleMessage(msg);
            }

        };
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(context);
                    }
                    regId = gcm.register("1001209534751");

                    saveRegisterId(context, regId);
                } catch (IOException ex) {
                    handler.sendEmptyMessage(1);
                    Log.e(TAG, ex.getMessage(), ex);
                }
            }
        };
        new Thread(runnable).start();
    }

    private void saveRegisterId(Context context, String regId) {
        final SharedPreferences prefs = getSharedPreferences(
                Splash.class.getSimpleName(), Context.MODE_PRIVATE);
        Log.i(TAG, "Saving regId on app version ");
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(REG_ID, regId);
        editor.commit();
    }
}
