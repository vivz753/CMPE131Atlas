package com.example.x1user.atlas;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by X1 User on 5/15/2017.
 */

public class User {


    private String email;
    private String password;
    private String name;
    private String phone;



    public User(String theEmail, String thePassword, String theName, String thePhone){
        this.email = theEmail;
        this.password = thePassword;
        this.name = theName;
        this.phone = thePhone;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }
}
