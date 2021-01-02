package com.Service.impl;

import com.DBUtils.JDBC;
import com.dao.UserDAO;
import com.point.ProductString;
import com.point.User;
import com.point.UserString;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class ServiceImpl implements UserDAO {
    User user;
    String sql;
    Statement stmt=null;
    ResultSet rs=null;
    public ServiceImpl(String sql){
        this.sql=sql;
    }
    @Override
    public boolean find(String sql) {
        if(sql==null)return false;
        try {
           stmt=JDBC.getConnection().createStatement();
           rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(String sql) {
        if(sql==null)return false;
        try {
            stmt=JDBC.getConnection().createStatement();
            int rs = stmt.executeUpdate(sql);
            if(rs>0)
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(String sql) {
        return  delete(sql);
    }

    @Override
    public boolean delete(String sql) {
        return add(sql);
    }

    @Override
    public List<UserString> display(String sql) {
        List<UserString>list=new ArrayList<>();
        try {
            stmt = JDBC.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                UserString user=new  UserString();
                user.setEmail(rs.getString(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setAuthority(rs.getString(4));
                user.setRegister_time(rs.getString(5));
                user.setLast_logintime(rs.getString(6));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int dis(String sql) {
        List<UserString>list=new ArrayList<>();
        int count=0;
        try {
            stmt = JDBC.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                count++;
            }
//            while (rs.next()){
//
//                UserString user=new  UserString();
//                System.out.println("---------------");
//                user.setEmail(rs.getString(1));
//                user.setName(rs.getString(2));
//                user.setPassword(rs.getString(3));
//                user.setAuthority(rs.getString(4));
//                user.setRegister_time(rs.getString(5));
//                user.setLast_logintime(rs.getString(6));
//                list.add(user);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public void close() throws SQLException {
        if(stmt!=null&&rs!=null)
        JDBC.close(rs,stmt,JDBC.getConnection());
        else if(stmt!=null){
            JDBC.close(stmt,JDBC.getConnection());
        }
    }
}
