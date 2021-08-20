//package dao;
//
//
//import java.sql.*;
//
//public class ConnectionManager {
//
//    private static Connection connection;
//
//    private ConnectionManager() {
//
//    }
//
//    public static Connection getConnectionDB() {
//        String url = PropertiesLoader.getProperties().getProperty("url");
//        String username = PropertiesLoader.getProperties().getProperty("username");
//        String password = PropertiesLoader.getProperties().getProperty("password");
//
//        try {
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return connection;
//
//    }
//
//
//
//}
