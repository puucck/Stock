package com.dao;

public interface ProductDAO {
    //查找商品
    public boolean find();
    public int num(String sql);
    //修改商品
    public String update();
    //删除商品
    public String delete();
}
