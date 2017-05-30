package com.yozzibeens.gobus.respuesta;


import com.yozzibeens.gobus.modelo.User;

public class ResultadoLogin {

    private User Data;
    private boolean IsError;
    private String Message;



    public User getData() {
        return Data;
    }

    public void setData(User data) {
        Data = data;
    }

    public boolean isError() {
        return IsError;
    }

    public void setError(boolean error) {
        IsError = error;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

}
