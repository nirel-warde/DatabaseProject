

package JDBC;


import Util.PropertiesLoader;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionPool {

    private static Connection connection;
    private static int POOL_SIZE = 150  ;
    private static ArrayList<Connection> connectionPool = new ArrayList<>();

    private ConnectionPool() {
    }

    public static void create() {
        for (int i = 0; i < POOL_SIZE; i++) {
            connectionPool.add(createConnection());
        }
        System.out.println(POOL_SIZE+ "Connections have been created");
    }

    public static synchronized Connection getConnection() {
        System.out.println("A connection has been removed from the pool");
        return  connection = connectionPool.remove(0);

    }

    protected static synchronized void releaseConnection(Connection connection) {
        System.out.println("the Connection have been returned to the pool");
        connectionPool.add(connection);
    }

    protected static Connection createConnection() {
        String url = PropertiesLoader.getProperties().getProperty("url");
        String username = PropertiesLoader.getProperties().getProperty("username");
        String password = PropertiesLoader.getProperties().getProperty("password");
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    protected static void closeAllConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}