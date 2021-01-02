package com.controller;

import com.Service.impl.ProductImpl;
import com.Service.impl.ServiceImpl;
import com.point.Product;
import com.point.ProductString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PageController {
    @RequestMapping("/page")
    @ResponseBody
    public List<ProductString> page(@RequestParam("page")int page){
        ProductImpl product=new ProductImpl();
        int pageNum=10;
        String sql = "select * from product_form limit "+page*10+","+pageNum+";";
        //将数据库中商品读取到list
        //回写到html
        List<ProductString> list=product.display(sql);
        try {
            product.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    @RequestMapping("pageNum")
    @ResponseBody
    public int page(){
        String sql="SELECT COUNT(*) FROM product_form;";
        ProductImpl product=new ProductImpl();
        int num= product.num(sql);
        try {
            product.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }
    @RequestMapping("/add")
    public String pageAdd(
                        @RequestParam("product_name")String product_name,
                        @RequestParam("type")String type,
                        @RequestParam("price")String price,
                        @RequestParam("number")String number,
                        @RequestParam("date")String date,
                        @RequestParam("shelf")String shelf
                        ) throws ParseException {
        ServiceImpl service=new ServiceImpl();
        String sql="INSERT INTO product_form(name,type,number,price,Production_Date,Shelf_life)" +
                "VALUES(\""+product_name+"\","+Integer.parseInt(type)+","+Integer.parseInt(number)+","+Float.valueOf(price)+
                ",\""+date+"\","+shelf+");";
        service.add(sql);
        try {
            service.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "homePage.html";
    }
    @RequestMapping("/del")
    public String pageDel(@RequestParam("product_id")String product_id){
        ServiceImpl service=new ServiceImpl();
        String sql="DELETE FROM product_form WHERE id=\""+product_id+"\";";
        service.delete(sql);
        try {
            service.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "homePage.html";
    }
    @RequestMapping("/upd")
    public String pageUpd( @RequestParam("product_id")String product_id,
            @RequestParam("product_name")String product_name,
            @RequestParam("type")String type,
            @RequestParam("price")String price,
            @RequestParam("number")String number,
            @RequestParam("date")String date,
            @RequestParam("shelf")String shelf
    ){
        String sql="UPDATE product_form SET type="+type+",number="+number+",Production_Date=\""+date+"\"," +
                "Shelf_life="+shelf+",price="+price+",name=\""+product_name+"\"WHERE id="+product_id+";";
        ServiceImpl service=new ServiceImpl();
        service.update(sql);
        try {
            service.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "homePage.html";
    }

    @RequestMapping("/In")
    public List<String> InAdd(@RequestParam("arr") List<String> arr){

        return arr;
    }


}
