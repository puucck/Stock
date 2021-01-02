package com.controller;

import com.Service.impl.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @RequestMapping("/forward")
    @ResponseBody
    public String register(String email,String pwd,String username) {
        ServiceImpl service=new ServiceImpl();
        String sql="select * from user where email="+"\""+email+"\""+";";
        service.find(sql);
        if (service.find(sql))
        {
            return "邮箱已经存在";
        }
        sql="select * from user where name="+"\""+username+"\""+";";
        if(service.find(sql)){
            return "用户名已存在";
        }
        return "error";
    }
}
