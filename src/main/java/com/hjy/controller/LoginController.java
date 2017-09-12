package com.hjy.controller;

import com.hjy.dao.IUserDao;
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

    @RequestMapping("/toregister.do")
    public String toRegister(){
        return "register";
    }

    /**
     * 注册功能：从数据库中找是否有相同的username，
     * 如果有 则返回注册页面重新注册
     * 如果没有 则注册成功返回登录页面
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/register.do")
    public String register(
            String username,
            String password,
            ModelMap model) {
        //找不到
        System.out.println(132);
        System.out.println("username:" + userDao.findByUsername(username));
        if(userDao.findByUsername(username) == null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userDao.save(user);
            return "login";
        } else {
          model.put("msg","用户名已存在");
          return "register";
           //返回用户名已存在信息
        }
    }

    @RequestMapping("/login.do")
    public String checkLogin(
            String username,
            String password,
            ModelMap model,
            HttpSession session) {
        User user = userDao.findByUsername(username);
        System.out.println("checkLogin");
        if(user != null) {
            if (user.getPassword().equals(password)) {
                model.put("username",username);
                session.setAttribute(
                        "username", username);
                return "index";
            } else {
                model.put("msg", "用户名或密码错误");
                return "login";
            }
        } else {
            model.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}
