package com.controller;

import com.Service.impl.ProductImpl;
import com.Service.impl.ServiceImpl;
import com.point.User;
import com.point.UserString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/adm")
    @ResponseBody
    public String userJudge(@RequestParam("email")String email){
        String sql="select * from admin_form where email=\""+email+"\";";
        ServiceImpl service=new ServiceImpl();
        boolean flag=service.find(sql);
        try {
            service.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(flag){
            return "yes";
        }
        else
        return "no";
    }
    @RequestMapping("/user")
    @ResponseBody
    public List<UserString> userList(){
        ServiceImpl service=new ServiceImpl();
        String sql="select * from user;";
        //将数据库中用户信息读取到list
        //回写到html
        List<UserString>list =service.display(sql);
//        int num=service.dis(sql);
        try {
           service.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            return list;
//        return num;
    }
    @RequestMapping("/aut")
    @ResponseBody
    public String Authority(@RequestParam("email")String email,@RequestParam("authority") int authority){
        String sql="UPDATE user SET Authority="+authority+" WHERE `email`=\""+email+"\";";
        ServiceImpl service=new ServiceImpl();
        service.update(sql);
        try {
            service.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "User.html";
    }
    @RequestMapping("/userDel")
    @ResponseBody
    public String del(@RequestParam("email")String email){
        String sql="DELETE FROM user WHERE email=\""+email+"\";";
        ServiceImpl service=new ServiceImpl();
        service.delete(sql);
        try {
            service.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "User.html";
    }
}
