package com.hjy.mapper;


import com.hjy.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setCode(resultSet.getString("code"));
        user.setState(resultSet.getBoolean("state"));
        user.setRegisterTime(resultSet.getTime("registerTime"));
        return user;
    }
}
