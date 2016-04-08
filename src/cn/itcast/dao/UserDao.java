package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {
    void add(User user);

    //username exit in database or not
    boolean find(String username);

    //login
    User find(String username, String password);
}
