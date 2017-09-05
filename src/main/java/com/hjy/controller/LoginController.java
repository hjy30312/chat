package com.hjy.controller;


import com.hjy.dao.IUserDao;
import com.hjy.dao.impl.UserDao;
import com.hjy.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller //扫描
public class LoginController {
    @Resource //注入
    private IUserDao userDao;

    @RequestMapping("/tologin.do")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login.do")
    public String checkLogin(
            String username,
            String password,
            ModelMap model,
            HttpSession session) {
        User user = userDao.findByUsername(username);
        if (user.getPassword().equals(password)) {
            return "ok";
        } else {
            model.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}
