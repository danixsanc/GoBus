package com.yozzibeens.gobus.solicitud;

public class SolicitudLogin {


    public SolicitudLogin() {
    }

    public SolicitudLogin(String email, String password) {
        Email = email;
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    private String Email;
    private String Password;


}
