package com.sparta.nw;

import JDBC.ConnectionPool;
import thread.ThreadPool;

public class Start {


    public static void starter(){
        ReadFile.readIO();
        ConnectionPool.create();
        ThreadPool.create();
        FileSplitter f = new FileSplitter();
        System.out.println("the CSV file contained "+ReadFile.getEmployeeList().size()+"values");
        f.split(ReadFile.getEmployeeList(),70);
    }
}
