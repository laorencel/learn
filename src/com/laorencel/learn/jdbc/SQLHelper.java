package com.laorencel.learn.jdbc;

import com.laorencel.learn.annotation.DBConfig;
import com.laorencel.learn.annotation.JDBCConfig;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

@JDBCConfig(database = DBConfig.DB_NAME, encoding = "utf-8", user = DBConfig.DB_USER, pwd = DBConfig.DB_PWD)
public class SQLHelper {
//    public static final String DB_USER = "root";
//    public static final String DB_PWD = "qwer1234";
//    public static final String DB_NAME = "how2java";
//    public static final String TABLE_NAME_HERO = "hero";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC连接初始化");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC连接初始化错误：e = " + e);
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        JDBCConfig config = SQLHelper.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        int port = config.port();
        String dbName = config.database();
        String encoding = config.encoding();
        String user = config.user();
        String pwd = config.pwd();
//        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, dbName, encoding);
        StringBuilder builder = new StringBuilder("jdbc:mysql://");
        builder.append(ip).append(":").append(port).append("/").append(dbName).append("?characterEncoding=").append(encoding);
        System.out.println("builder = " + builder.toString());
//        return DriverManager.getConnection("jdbc:mysql://"+ip+":3306/" + SQLHelper.DB_NAME + "?characterEncoding=UTF-8",
//                SQLHelper.DB_USER, SQLHelper.DB_PWD);
        return DriverManager.getConnection(builder.toString(),
                user, pwd);
    }

    public static Statement getStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    public static Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    public static PreparedStatement getPrepareStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    public static boolean exec(String sql) {
        if (null == sql || sql.isEmpty()) {
            return false;
        }
        try (Statement statement = getStatement()) {
            //execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
            return statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ResultSet executeQuery(String sql) {
        if (null == sql || sql.isEmpty()) {
            return null;
        }
        try (Statement statement = getStatement()) {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
