package cn.itcast.test;

import cn.itcast.dao.impl.UserDaoJdbcImpl;
import cn.itcast.domain.User;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoImplJdbcTest {
    UserDaoJdbcImpl dao = new UserDaoJdbcImpl();


    @Test
    public void testAdd() throws ParseException {
    User user = new User();
        user.setId("1");
        user.setUsername("kw7143");
        user.setPassword("123456");
        user.setEmail("hans@163.com");
        user.setNickname("昵称");
        user.setBirthday(new Date());

        dao.add(user);


    }

    @Test
    public void testfind1() {
        boolean b=dao.find("hans");
        System.out.println(b);

    }

    @Test
    public void testfind2() {
        User hans = dao.find("hans", "a1518074859");
        System.out.println(hans);

    }

}
