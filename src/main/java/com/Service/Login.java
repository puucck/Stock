package com.Service;

import com.Service.impl.ServiceImpl;
import com.point.User;

import java.util.Date;

public class Login {
    String email;
    String password;
    public Login(String email,String password) {
        this.email=email;
        this.password=password;
    }
    public boolean find(){
        ServiceImpl s=new ServiceImpl();
        User user=new User(this.email,this.password);
        return true;
//        return  s.find(user);
    }

}
