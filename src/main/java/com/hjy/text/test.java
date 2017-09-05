package com.hjy.text;

import com.hjy.dao.impl.UserDao;
import com.hjy.models.User;
import com.hjy.util.DaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        String conf = "applicationContext.xml";
        ApplicationContext ac =
                new ClassPathXmlApplicationContext(conf);
        UserDao userDao = ac.getBean(
                "userDao", UserDao.class);
        User user = userDao.findByUsername("hjy");
        System.out.println(user.getUsername());
    }
}
