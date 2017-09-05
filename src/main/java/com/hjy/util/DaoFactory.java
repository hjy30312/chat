package com.hjy.util;

import com.hjy.dao.IUserDao;
import com.hjy.dao.impl.UserDao;

/**
 * 数据访问工厂
 */
public class DaoFactory {

    public static IUserDao getUserDao() {
        return new UserDao();
    }
}
