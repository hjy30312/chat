package com.hjy.dao.impl;

import com.hjy.dao.IUserDao;
import com.hjy.models.User;
import com.hjy.mapper.UserRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository //扫描Dao
public class UserDao implements IUserDao {


    @Resource
    private JdbcTemplate template;


    public void save(User user) {
        String sql = "insert into tb_user " +
                "(username,password) value(?,?)";
        Object[] params = {
                user.getUsername(),
                user.getPassword(),
        };
        template.update(sql, params);
    }


    public User findByUsername(String username) {
        String sql = "select * from tb_user " +
                "where username=?";
        Object[] params = {username};
        UserRowMapper rowMapper = new UserRowMapper();
        User user;
        try {
            user = template.queryForObject(
                    sql, params, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return user;
    }
}


