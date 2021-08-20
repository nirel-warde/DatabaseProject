package com.sparta.nw;

import dao.ConnectionPool;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        ReadFile.readIO();
        ConnectionPool.create();
        ThreadPool.create();
        FileSplitter f = new FileSplitter();
        System.out.println(ReadFile.getEmployeeList().size());
//        System.out.println(9943%8);
        f.split(ReadFile.getEmployeeList(),3);
//        EmployeeGateway e = new EmployeeGateway();
//        e.createEmployee(ReadFile.getEmployeeList());
//        Thread t1 = new Thread(f);
    }
}
