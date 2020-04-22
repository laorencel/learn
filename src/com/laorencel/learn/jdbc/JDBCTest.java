package com.laorencel.learn.jdbc;

import com.laorencel.learn.annotation.DBConfig;

import java.sql.*;
import java.util.Random;

public class JDBCTest {

    public static void main(String[] args) {
//        pool();
        query();
    }

    private static void pool() {
        long l1 = System.currentTimeMillis();
        ConnectionPool pool = new ConnectionPool(5);
        for (int i = 0; i < 100; i++) {
            WorkingThread thread = new WorkingThread("英雄" + i, pool);
            thread.start();
        }
        long l2 = System.currentTimeMillis();
//        System.out.println("耗时" + (l2 - l1));
//        String sql = "select * from hero";
//        System.out.println("执行结果：" + SQLHelper.exec(sql));
    }

    private static void prepare() {
        String sql = "update hero set name = ? where id = 4";
        try (PreparedStatement statement = SQLHelper.getPrepareStatement(sql);) {
            statement.setString(1, "阿峰");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void test() {
        //        String sql = "update hero set name = '提莫1' where id = 4";
//        long l1 = System.currentTimeMillis();
//        System.out.println("执行结果：" + SQLHelper.exec(sql));
//        long l2 = System.currentTimeMillis();
//        System.out.println("耗时" + (l2 - l1));
//        String sql1 = "update hero set name = '提莫2' where id = 5";
//        System.out.println("执行结果：" + SQLHelper.exec(sql1));
//        long l3 = System.currentTimeMillis();
//        System.out.println("耗时" + (l3 - l2));
//        String sql2 = "update hero set name = '提莫3' where id = 5";
//        System.out.println("执行结果：" + SQLHelper.exec(sql2));
//        long l4 = System.currentTimeMillis();
//        System.out.println("耗时" + (l4 - l3));
    }

    private static void query() {
        String sql5 = "select * from " + DBConfig.TABLE_NAME_HERO;
        try (ResultSet set = SQLHelper.getStatement().executeQuery(sql5)) {
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                float hp = set.getFloat("hp");
                int damage = set.getInt("damage");
                System.out.println("id = " + id + " name = " + name + " hp = " + hp + " damage = " + damage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static class WorkingThread extends Thread {
        private ConnectionPool pool;

        public WorkingThread(String name, ConnectionPool pool) {
            super(name);
            this.pool = pool;
        }

        @Override
        public void run() {
            super.run();
            Connection connection = pool.getConnection();
            System.out.println(this.getName() + ":\t 获取了一根连接，并开始工作");
            try (Statement statement = connection.createStatement()) {
                Thread.sleep(1000);
                Random random = new Random();
                statement.execute("insert into " + DBConfig.TABLE_NAME_HERO + " values (null ,'"
                        + this.getName() + "',"
                        + random.nextInt(1000) + ","
                        + random.nextInt(500) + ")");
                pool.returnConnection(connection);
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
