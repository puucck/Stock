package com.DBUtils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBC {
    private static String url="jdbc:mysql://127.0.0.1:3306/t?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
    private static String user="root";
    private static String password="123123";
    private static String driver="com.mysql.cj.jdbc.Driver";
    //读取资源文件
    static{
        //获取src路径下的文件方式--->ClassLoader 类加载器
        try {
//            Properties pro=new Properties();
//            //获取Src路径下文件的方式----->ClassLoader 类加载器
//            ClassLoader classLoader=JDBC.class.getClassLoader();
//            URL res=classLoader.getResource("C:\\Users\\28324\\Desktop\\XD\\Stock\\src\\main\\resources\\static\\jdbc.properties");
//            String path=res.getPath();
            //加载文件
//            pro.load(new FileReader(path));
            //获取属性,赋值
//            url=pro.getProperty("url");
//            user=pro.getProperty("user");
//            password=pro.getProperty("password");
//            driver=pro.getProperty("driver");
            //注册驱动
//            Class.forName(driver);
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接
     *
     * */
    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url,user,password);
    }
    /**
     * 释放资源
     * */
    public static void close(ResultSet rs, Statement stmt,Connection conn){
        if(rs!=null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if(stmt!=null)
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if(conn!=null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public static void close(Statement stmt, Connection conn){
        if(stmt!=null)
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if(conn!=null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
