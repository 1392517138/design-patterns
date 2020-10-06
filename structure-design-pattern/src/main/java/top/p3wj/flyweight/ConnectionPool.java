package top.p3wj.flyweight;

import jdk.nashorn.internal.ir.CallNode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

/**
 * @author Aaron
 * @description
 * @date 2020/10/5 9:45 下午
 */
public class ConnectionPool {
    private Vector<Connection> pool;
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "root";
    private String driverClassName = "com.mysql.jdbc.Driver";
    private int poolSize = 100;

    public ConnectionPool() {
        pool = new Vector<Connection>(poolSize);
        try {
            Class.forName(driverClassName);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                pool.add(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection connection = pool.get(0);
            pool.remove(connection);
            return connection;
        }
        return null;
    }

    public synchronized void release(Connection connection) {
        pool.add(connection);
    }
}
