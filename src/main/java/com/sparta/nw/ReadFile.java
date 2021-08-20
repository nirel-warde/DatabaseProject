package com.sparta.nw;

import dto.Employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReadFile {

    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static ArrayList<Employee> dupeEmployeeList = new ArrayList<>();
    private static ArrayList<Employee> incompleteEmployeeList = new ArrayList<>();

    public static void readIO() {

        try {
            Files.lines(Path.of("src/main/resources/EmployeeRecords.csv"))
                    .skip(1)
                    .map(s -> new Employee(s))
                    .distinct()
                    .forEach((Employee e) -> setArrayListValues(employeeList, dupeEmployeeList, e));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void setArrayListValues(ArrayList<Employee> employeeList, ArrayList<Employee> dupeEmployeeList, Employee e) {
        employeeList.add(e);

    }

    public static ArrayList<Employee> getDupeEmployeeList() {
        return dupeEmployeeList;
    }


    public static ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public static ArrayList<Employee> getIncompleteEmployeeList() {
        return incompleteEmployeeList;
    }

    public static void setIncompleteEmployeeList(ArrayList<Employee> incompleteEmployeeList) {
        ReadFile.incompleteEmployeeList = incompleteEmployeeList;
    }
}
