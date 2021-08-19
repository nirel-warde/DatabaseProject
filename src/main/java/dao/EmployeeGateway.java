package dao;

import Util.SpeedTest;
import dto.Employee;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class EmployeeGateway {
    //    private static final String GET_ALL_EMPLOYEES = "SELECT * FROM employees.employees_table";
    private static final String INSERT_EMPLOYEES = "INSERT INTO employees_table (employeeID,namePrefix,firstName,middleInitial,lastName,gender,email,dob,dateOfJoining,salary) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_USER = "DELETE FROM employees.employees_table";

    public void createEmployee(ArrayList<Employee> employee) {
        deleteEmployee();
        Connection connection = ConnectionManager.getConnectionDB();
        long start = SpeedTest.startTime();

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEES);
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
                statement.addBatch();

            }
            statement.executeBatch();
            ConnectionManager.closeConnection();
            long nano = SpeedTest.totalTime(start);
            long seconds = TimeUnit.SECONDS.convert(
                    Duration.ofNanos(nano));
            System.out.println(seconds);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    //    public void getEmployee() {
////        ArrayList<Employee> employeesList = new ArrayList<>();
//        try {
//            Connection connection = ConnectionManager.getConnectionDB();
//            PreparedStatement statement = connection.prepareStatement(GET_ALL_EMPLOYEES);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
////                Employee employee =
//
//                System.out.println(resultSet.getInt(1));
//                System.out.println(resultSet.getString(2));
//                System.out.println(resultSet.getString(3));
//                System.out.println(resultSet.getString(4));
//                System.out.println(resultSet.getString(5));
//                System.out.println(resultSet.getString(6));
//                System.out.println(resultSet.getString(7));
//                System.out.println(resultSet.getDate(8));
//                System.out.println(resultSet.getDate(9));
//                System.out.println(resultSet.getDouble(10));
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    public void updateEmployee(Employee employee) {
//
//    }
//
    private void deleteEmployee() {
        try {
            Connection connection = ConnectionManager.getConnectionDB();
            PreparedStatement statement = connection.prepareStatement(DELETE_USER);
            statement.execute();
            ConnectionManager.closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
