package com.laorencel.learn.se.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPool {
    private int size;
    private List<Connection> connections = new LinkedList<>();

    public ConnectionPool(int size) {
        this.size = size;
        init();
    }

    private void init() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < this.size; i++) {
                connections.add(SQLHelper.getConnection());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection(){
        while (connections.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       return connections.remove(0);
    }

    public synchronized void returnConnection(Connection connection){
        if (null != connection ){
            this.connections.add(connection);
            this.notifyAll();
        }
    }
}
