package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.dao.impl.UserDaoJdbcImpl;
import cn.itcast.domain.User;
import cn.itcast.exceptions.UserexitException;
import cn.itcast.factory.DaoFactory;
import cn.itcast.utils.ServiceUtils;

//操作dao层为web层提供业务
public class BussinessServiceImpl {
    // UserDao dao= new UserDaoJdbcImpl();
    //工厂模式 spring
    private UserDao dao= DaoFactory.getInstance().createDao(UserDao.class);

    //注册
    public void register(User user) throws UserexitException {
        //如果用户名已存在,给web层抛userexitexception,提醒web层处理这个异常
        boolean b = dao.find(user.getUsername());
        if (b == true) {
            throw new UserexitException();
        } else {
            dao.add(user);
        }
    }
    //登录
    public User login(String username, String password) {
        return dao.find(username, password);
    }

}
