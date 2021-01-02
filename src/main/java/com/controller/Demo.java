package com.controller;

import com.Service.impl.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class Demo {
    //登录
    @RequestMapping("/hello")
    @ResponseBody
    public String tlc(
            @RequestParam("email")String email,
            @RequestParam("pwd")String pwd,
            Model model,HttpSession session
            ){
        /**
         * 登录数据库查询
         * */
        String sql="select * from user where email="+"\""+email+"\""+" and password="+"\""+pwd+"\""+";";
        ServiceImpl service=new ServiceImpl();
        if(service.find(sql)){
            try {
                service.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            session.setAttribute("loginUser",email);
            return "ok";
        }
        else{
            model.addAttribute("msg","用户名或密码错误");
            return "error";
        }

    }
    //注册
    @RequestMapping(value = "/hello2")
    public String hello(
            @RequestParam("email")String email,
            @RequestParam("username")String username,
            @RequestParam("pwd")String pwd
    ) throws SQLException {
        //不存在注册
        //数据库写入
        String sql="select * from user where email="+"\""+email+"\""+";";
        ServiceImpl service=new ServiceImpl();
        if(service.find(sql)==false)
        {
            //写入
            SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String date=df.format(new Date());
            String sql2="INSERT INTO user(email,name,password,Authority,Regist_time,last_logintime)" +
                    "VALUES(\"" +email+"\",\""+username+"\",\""+pwd+"\",1,\""+date+"\",\""+date+"\");";
            service.add(sql2);
            service.close();
            return "error.html";
        }
        else {
            return "error.html";

        }

    }
}
