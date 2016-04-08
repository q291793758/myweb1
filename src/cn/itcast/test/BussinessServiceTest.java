package cn.itcast.test;

import cn.itcast.domain.User;
import cn.itcast.exceptions.UserexitException;
import cn.itcast.service.impl.BussinessServiceImpl;
import org.junit.Test;

public class BussinessServiceTest {
    BussinessServiceImpl service=   new BussinessServiceImpl();
    User user=new User();

    //测试server层的register方法
    @Test
    public void testRegister()  {
    user.setId("23111");
    user.setUsername("jack");
    user.setPassword("123");
    user.setEmail("jone@email.com");
    user.setNickname("囧恩");
    user.setBirthday(null);
    try {
        service.register(user);
    } catch (UserexitException e) {
        System.out.println("注册的用户名已存在,请检查用户名");
    }
}
    //测试server层的login方法
    @Test
    public void testLogin() {
        User user = service.login("jone", "123");
        if (user == null) {
            System.out.println("登录失败!");
        } else {
            System.out.println("登录成功!");
        }
    }
}
