package com.hjy.controller;

import com.hjy.dao.IUserDao;
import com.hjy.models.User;
import com.hjy.util.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller //扫描
public class LoginController {
    @Resource //注入
    private IUserDao userDao;

    @RequestMapping(value = "/captcha.jpg", method = RequestMethod.GET)
    public void captcha(HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse) throws ServletException, IOException {
        // 通知浏览器不要缓存
        httpServletResponse.setHeader("Expires", "-1");
        httpServletResponse.setHeader("Cache-Control", "no-cache");
        httpServletResponse.setHeader("Pragma", "-1");

        CaptchaUtil util = CaptchaUtil.Instance();
        // 将验证码输入到session中，用来验证
        String code = util.getString();
        httpServletRequest.getSession().setAttribute("code", code);
        // 输出打web页面
        ImageIO.write(util.getImage(), "jpg", httpServletResponse.getOutputStream());
    }

    @RequestMapping(value = "/toregister",method = RequestMethod.POST)
    public String toregister() {
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
            return "redirect:/login";
        } else {
          model.put("msg","用户名已存在");
          return "redirect:/register";
           //返回用户名已存在信息
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/chat",method = RequestMethod.POST)
    public String chat() {
        return "chat";
    }

    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    public String checkLogin(
            String username,
            String password,
            String captcha,
            ModelMap model,
            HttpSession session) {
        User user = userDao.findByUsername(username);
        String codeSession = (String) session.getAttribute("code");
        System.out.println("codeSession:" + codeSession);
        System.out.println("captcha:" + captcha);

        if(codeSession.equalsIgnoreCase(captcha)) {
            //验证码正确
        } else {
            model.put("msg", "验证码错误");
            return "/login";
        }

        if(user != null) {
            if (user.getPassword().equals(password)) {
                model.put("username",username);
                session.setAttribute(
                        "username", username);
                return "/chat";
            } else {
                model.put("msg", "用户名或密码错误");
                return "/login";
            }
        } else {
            model.put("msg", "用户名或密码错误");
            return "/login";
        }
    }
}
