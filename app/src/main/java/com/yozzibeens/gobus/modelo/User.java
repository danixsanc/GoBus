package com.yozzibeens.gobus.modelo;

/**
 * Created by Antonio on 30/05/2017.
 */

public class User {

    private Long id;
    private String User_Id;
    private String User_Name;
    private String User_Email;

    public User(){

    }

    public User(Long id, String user_Id, String user_Name, String user_Email) {
        this.id = id;
        User_Id = user_Id;
        User_Name = user_Name;
        User_Email = user_Email;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String user_Id) {
        User_Id = user_Id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public void setUser_Email(String user_Email) {
        User_Email = user_Email;
    }


}
