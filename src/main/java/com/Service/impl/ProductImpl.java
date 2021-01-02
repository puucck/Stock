package com.Service.impl;

import com.DBUtils.JDBC;
import com.dao.ProductDAO;
import com.point.ProductString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductDAO {
    Statement stmt = null;
    ResultSet rs = null;

    @Override
    public boolean find() {
        String sql = "select * from product_form;";
        try {
            stmt = JDBC.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public  int num(String sql) {
        int num=0;
        try {
            stmt = JDBC.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next())
            {num=rs.getInt(1);}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }

    public List<ProductString> display(String sql){
        List<ProductString>list=new ArrayList<>();
        int count=0;
        try {
            stmt = JDBC.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                if(rs.getInt(1)>count)
                    count=rs.getInt(1);
                ProductString product=new ProductString();
                product.setId(rs.getString(1));
                product.setName(rs.getString(2));
                product.setType(rs.getString(3));
                product.setNumber(rs.getString(4));
                product.setPrice(rs.getString(5));
                product.setProduct_Date(rs.getString(6));
                product.setShelf_life(rs.getString(7));

                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void close() throws SQLException {
        if (stmt != null && rs != null)
            JDBC.close(rs, stmt, JDBC.getConnection());
        else if (stmt != null) {
            JDBC.close(stmt, JDBC.getConnection());
        }
    }
}