package com.hjy.controller;

import com.hjy.dao.IUserDao;
import com.hjy.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            String username,
            String password,
            ModelMap model) {
        //找不到
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

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String checkLogin(
            String username,
            String password,
            ModelMap model,
            HttpSession session) {
        User user = userDao.findByUsername(username);
        if(user != null) {
            if (user.getPassword().equals(password)) {
                model.put("username",username);
                session.setAttribute(
                        "username", username);
                return "redirect:/index";
            } else {
                model.put("msg", "用户名或密码错误");
                return "redirect:/login";
            }
        } else {
            model.put("msg", "用户名不存在");
            return "redirect:/login";
        }
    }
}
