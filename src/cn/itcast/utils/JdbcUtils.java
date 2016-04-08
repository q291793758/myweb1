package cn.itcast.utils;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    //get sql Connection
    private static Properties prop =new Properties();
    //静态代码块只执行一次.
     static {
        String path = JdbcUtils.class.getClassLoader().getResource("db.properties").getPath();

        try {
//            prop.load(JdbcUtils.class.getResourceAsStream("db.properties"));
        prop.load(new InputStreamReader(new FileInputStream(new File(path))));
             Class.forName(prop.getProperty("driver"));
         } catch (ClassNotFoundException e) {
             throw new ExceptionInInitializerError(e);
         } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //工具类的异常,可以直接抛给调用者,或者try catch转型再抛给调用者
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        return  connection;
    }
    //release resource
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet=null;
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement=null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection=null;
        }

    }


}
