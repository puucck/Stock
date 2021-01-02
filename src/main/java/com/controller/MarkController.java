package com.controller;

import com.Service.impl.ProductImpl;
import com.Service.impl.ServiceImpl;
import com.point.ProductString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Controller
public class MarkController {
    @RequestMapping("/search")
    @ResponseBody
    public List<ProductString> search(@RequestParam("product_name") String product_name){
        if(product_name.equals(""))
        {
            List<ProductString> list=new ArrayList<>();
            ProductString productString=new ProductString();
            productString.setName("error");
            list.add(productString);
            return list;
        }
        String sql="select * from product_form where name="+"\""+product_name+"\";";
        ProductImpl product=new ProductImpl();
        List<ProductString> list=product.display(sql);
        try {
            product.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
