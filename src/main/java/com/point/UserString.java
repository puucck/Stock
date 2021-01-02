package com.point;

import java.util.Date;

public class UserString {
    String email;
    String name;
    String password;
    String authority;
    String Register_time;
    String last_logintime;

    public UserString(){};

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getRegister_time() {
        return Register_time;
    }

    public void setRegister_time(String register_time) {
        Register_time = register_time;
    }

    public String getLast_logintime() {
        return last_logintime;
    }

    public void setLast_logintime(String last_logintime) {
        this.last_logintime = last_logintime;
    }
}
