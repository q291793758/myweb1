package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.JdbcUtils;
import cn.itcast.utils.ServiceUtils;

import java.sql.*;
import java.util.Date;

public class UserDaoJdbcImpl implements UserDao {


    //添加用户
    public void add(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String id = user.getId();
        String username = user.getUsername();
        String password = ServiceUtils.codingPassword(user.getPassword());
        String email = user.getEmail();
        String nickname = user.getNickname();
        Date birthday = user.getBirthday();

        try {
            connection = JdbcUtils.getConnection();
            String sql = "INSERT INTO users(id,username,password,email,nickname,birthday) VALUES (?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            statement.setString(2,username);
            statement.setString(3,password);
            statement.setString(4,email);
            statement.setString(5,nickname);
            statement.setDate(6,new java.sql.Date(birthday.getTime()));
            int i = statement.executeUpdate();
//            statement = connection.createStatement();
//            String sql = "insert into users(id,username,password,email,nickname,birthday )" +
//                    " value('"+id+"','"+username+"','"+password+"','"+email+"','"+nickname+"','"+birthday.toLocaleString()+"')";
//            int i = statement.executeUpdate(sql);
            if (i < 1) {
                throw new RuntimeException("注册失败!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(connection,statement, resultSet);
        }

    }

    //查找是否重名
    public boolean find(String username) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql="SELECT * FROM users WHERE username='"+username+"'";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return true;
            }

        return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(connection,statement, resultSet);
        }
    }

    //查找用户
    public User find(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //MD5 encoding
        password=ServiceUtils.codingPassword(password);
        try {
            String sql="SELECT * FROM users WHERE username=? AND password=?";
            connection = JdbcUtils.getConnection();
            //预编译这条语句
            statement = connection.prepareStatement(sql);
            //替换上面sql语句中的?
            statement.setString(1,username);
            statement.setString(2,password);
            //执行
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user=new User();

                user.setId(resultSet.getString("id"));
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(resultSet.getString("email"));
                user.setNickname(resultSet.getString("nickname"));
                user.setBirthday(resultSet.getDate("birthday"));
                return user;
            }

        return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(connection,statement, resultSet);
        }

    }
}
