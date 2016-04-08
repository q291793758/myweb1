<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工厂设计模式实现数据库切换</title>
    <style>
        body {
            /*text-align: center;*/
            /*margin: auto;*/
            width: 80%;
        }
    </style>
</head>
<body bgcolor="c7edcc">
<div>
    <pre>
        dao.properties:<br/>
        UserDao=cn.itcast.dao.impl.UserDaoJdbcImpl
    </pre>
</div>
<hr/>

<div>
    <pre>
        工厂返回实例<br/>
package cn.itcast.factory;

import com.intellij.openapi.roots.ui.configuration.artifacts.sourceItems.actions.PutSourceItemIntoParentAndLinkViaManifestAction;

import java.io.IOException;
import java.util.Properties;

//singleInstance
public class DaoFactory {
    private static DaoFactory ourInstance = new DaoFactory();

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    Properties daoconfig = new Properties();

    private DaoFactory() {
        try {
            daoconfig.load(DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties"));
        } catch (IOException e) {
            new RuntimeException(e);
        }
    }


    public < T> T createDao(Class< T> clazz) {
        //获得相对应类名
        String name = clazz.getName();   //cn.itcast.dao.impl.UserDaoJdbcImpl
        name=name.substring(name.lastIndexOf(".")+1);
        //String name=clazz.getSimpleName();  //UserDaoJdbcImpl
        String classname = daoconfig.getProperty(name);

        try {
        T dao= (T) Class.forName(classname).newInstance();
        return dao;
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
        }


        }

    </pre>

</div><hr/>

<div>
    <pre>
        调用工厂产生实例
        //操作dao层为web层提供业务
public class BussinessServiceImpl {
    // UserDao dao= new UserDaoJdbcImpl();
    //工厂模式 spring
    private UserDao dao= DaoFactory.getInstance().createDao(UserDao.class);
    </pre>

</div>

</body>
</html>
<!--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/19
  Time: 15:44
  To change this template use File | Settings | File Templates.
-->