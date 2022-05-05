package com.example.pfe.models;

public class user {
    public  String fullName;
    public String email;
    public String phone;

    public String password;

    public user(String fullName, String email, String phone,String password) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }

    public user() {
    }
}
