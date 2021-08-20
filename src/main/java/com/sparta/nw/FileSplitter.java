package com.sparta.nw;

import thread.ThreadPool;
import dto.Employee;

import java.util.ArrayList;
import java.util.List;

public class FileSplitter {
    public void split(ArrayList<Employee> employee, int numOfSplit) {
        int constant = employee.size() / numOfSplit;
//        Logger.getLogger().log(Level.SEVERE, null, ex);
        for (int i = 0; i < employee.size(); i += constant) {
            if (i + constant > employee.size()) {
                addToThread(employee.subList(i, employee.size()));
            } else {
                addToThread(employee.subList(i, i + constant));
            }
        }


    }


    public synchronized void addToThread(List subList) {
        ThreadPool.getThread(new ArrayList<>(subList)).start();


    }
}
