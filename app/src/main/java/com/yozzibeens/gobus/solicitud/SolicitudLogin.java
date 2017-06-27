package com.yozzibeens.gobus.solicitud;

public class SolicitudLogin {


    public SolicitudLogin() {
    }

    public SolicitudLogin(String email, String password) {
        user_email = email;
        user_pass = password;
    }

    public String getEmail() {
        return user_email;
    }

    public void setEmail(String email) {
        user_email = email;
    }

    public String getPassword() {
        return user_pass;
    }

    public void setPassword(String password) {
        user_pass = password;
    }


    private String user_email;
    private String user_pass;


}
