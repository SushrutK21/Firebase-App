package com.example.cgi.my_home_circle;


public class User {

    private String Authtype;
    private String email;
    private String Location;
    private String password;
    private  String Phone;
    private String Usertype;
    private String ZIP;

    public User(String authtype, String email, String location, String password, String phone, String usertype, String ZIP) {
        Authtype = authtype;
        this.email = email;
        Location = location;
        this.password = password;
        Phone = phone;
        Usertype = usertype;
        this.ZIP = ZIP;
    }

    public String getAuthtype() {
        return Authtype;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return Location;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return Phone;
    }

    public String getUsertype() {
        return Usertype;
    }

    public String getZIP() {
        return ZIP;
    }

    public User(String aNative, String trim, String s, String trim1, String s1, String trim2) {

    }
}



