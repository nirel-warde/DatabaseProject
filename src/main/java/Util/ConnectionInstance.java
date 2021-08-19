package Util;

import dao.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInstance {
    public ConnectionInstance() {
        String url = PropertiesLoader.getProperties().getProperty("url");
        String username = PropertiesLoader.getProperties().getProperty("username");
        String password = PropertiesLoader.getProperties().getProperty("password");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
