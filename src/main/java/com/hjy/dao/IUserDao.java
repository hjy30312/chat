package com.hjy.dao;

import com.hjy.models.User;

public interface IUserDao {
    public void save(User user);
    public User findByUsername(String username);
}
