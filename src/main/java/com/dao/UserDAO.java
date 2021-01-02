package com.dao;

import com.point.User;
import com.point.UserString;

import java.util.List;

public interface UserDAO {
    public boolean find(String sql);
    public boolean add(String sql);
    public boolean update(String sql);
    public boolean delete(String sql);
    public List<UserString> display(String sql);
}
