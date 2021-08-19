package com.sparta.nw;

import dao.EmployeeGateway;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        ReadFile.readIO();
//        System.out.println(ReadFile.getEmployeeList());
        EmployeeGateway e = new  EmployeeGateway();
        e.createEmployee(ReadFile.getEmployeeList());

    }
}
