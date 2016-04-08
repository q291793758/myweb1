package cn.itcast.dao.impl;

import org.junit.Test;
import cn.itcast.utils.JdbcUtils;

//导入接口API,实现同用性,以便将来更换数据库(例:ORACLE),创建链接可以正常使用
//如果导入的是mysql的链接Connection,Oracle数据库执行时可能会发生错误
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//操作数据库工具类
public class Demo2 {
    //插入信息
    @Test
    public void insert() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "insert into users(id,name,password,email,birthday) values('4','hans','123456','hans@admin.com','1990-02-02')";
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("插入" + i + "条信息成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(connection, statement, resultSet);
        }


    }
    //修改信息
    @Test
    public void update() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "UPDATE users set name='zimmer' WHERE id='4' ";
            int i = statement.executeUpdate(sql);
            System.out.println("影响到的行数"+i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(connection, statement, resultSet);
        }

    }
    //删除信息
    @Test
    public void delete() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "DELETE FROM users WHERE name='zimmer' ";
            int i = statement.executeUpdate(sql);
            System.out.println("修改的条数"+i);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(connection, statement, resultSet);
        }

    }
    //查找信息
    @Test
    public void find() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id,name,password,email ,birthday FROM users WHERE id='4'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getObject("id"));
                System.out.println("name=" + resultSet.getObject("name"));
                System.out.println("passowrd=" + resultSet.getObject("password"));
                System.out.println("email=" + resultSet.getObject("email"));
                System.out.println("birthday=" + resultSet.getObject("birthday"));
                System.out.println("================================================");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(connection, statement, resultSet);
        }

    }

    //返回所有信息
    @Test
    public void getAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            resultSet = statement.executeQuery(sql);
//        5,从结果中获取数据
            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getObject("id"));
                System.out.println("name=" + resultSet.getObject("name"));
                System.out.println("passowrd=" + resultSet.getObject("password"));
                System.out.println("email=" + resultSet.getObject("email"));
                System.out.println("birthday=" + resultSet.getDate("birthday"));
                System.out.println("================================================");
            }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                JdbcUtils.release(connection, statement, resultSet);
            }


    }
}

