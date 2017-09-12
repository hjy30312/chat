package com.hjy.text;

import com.hjy.dao.impl.UserDao;
import com.hjy.models.User;
import com.hjy.util.DaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static int[] printMatrix(int[][] mat,int n, int m) {
        // write code here
        int[] temp = new int[n * m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[ans++] = mat[i][j];
            }
            if (i + 2 != n ) {
                i++;
            } else {
                break;
            }
            for (int j = m-1; j >= 0; j--) {
                temp[ans++] = mat[i][j];
            }
        }
        return temp;
    }
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

