package com.sparta.nw;

import Util.Converter;
import JDBC.EmployeeGateway;
import Util.PropertiesLoader;
import dto.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;


public class JunitExample {


    @Test
    void checkFileIsNotNull() {
        Assertions.assertNotNull(ReadFile.getEmployeeList());
    }


    @Test
    void checkIfCleanData() {

        try {
            Files.lines(Path.of("src/main/resources/EmployeeRecords.csv"))
                    .skip(1)
                    .map(s -> new Employee(s)).close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Assertions.assertNotEquals(ReadFile.readDirtyIO(), ReadFile.readIO());
    }

    @Test
    void databaseConnection() {
        String url = PropertiesLoader.getProperties().getProperty("url");
        String username = PropertiesLoader.getProperties().getProperty("username");
        String password = PropertiesLoader.getProperties().getProperty("password");
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Assertions.assertNotNull(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    void queryConnection() {
        try {
            String url = PropertiesLoader.getProperties().getProperty("url");
            String username = PropertiesLoader.getProperties().getProperty("username");
            String password = PropertiesLoader.getProperties().getProperty("password");

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT Count(*) FROM employees.employees_table");

            Assertions.assertTrue(statement.execute());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    void AddArrayListToDatabase() {
        try {
            String url = PropertiesLoader.getProperties().getProperty("url");
            String username = PropertiesLoader.getProperties().getProperty("username");
            String password = PropertiesLoader.getProperties().getProperty("password");

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO employees.employees_table (employeeID,namePrefix,firstName,middleInitial,lastName,gender,email,dob,dateOfJoining,salary) VALUES (?,?,?,?,?,?,?,?,?,?)");

            EmployeeGateway eg = new EmployeeGateway();
            ArrayList<Employee> employee = new ArrayList<>(ReadFile.getEmployeeList());
            for (Employee e : employee) {

                statement.setInt(1, e.getEmployeeID());
                statement.setString(2, e.getNamePrefix());
                statement.setString(3, e.getFirstName());
                statement.setString(4, e.getMiddleInitial());
                statement.setString(5, e.getLastName());
                statement.setString(6, e.getGender());
                statement.setString(7, e.getEmail());
                statement.setDate(8, Converter.utilToSqlConverter(e.getDob()));
                statement.setDate(9, Converter.utilToSqlConverter(e.getDateOfJoining()));
                statement.setDouble(10, e.getSalary());

            }


            Assertions.assertTrue(statement.execute());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
