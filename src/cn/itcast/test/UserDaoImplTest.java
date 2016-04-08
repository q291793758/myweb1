package cn.itcast.test;
//UserDaoImpl测试类

import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.utils.ServiceUtils;
import org.junit.Test;

public class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();
    User user = new User();


    @Test
    public void testadd() {
        user.setId("9527");
        user.setUsername("admin");
        user.setPassword("123");
        user.setEmail("admin@gmail.com");
        user.setNickname("管理员");
        user.setBirthday(null);
        user.setPassword(ServiceUtils.codingPassword(user.getPassword()));
        userDao.add(user);
    }

    @Test
    public void testfind() {
        boolean b = userDao.find("admin");
        System.out.println(b);

    }
    @Test
    public void testfind1() {
       user= userDao.find("admin","admin");
        System.out.println(user);

    }

}
