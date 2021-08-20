package com.sparta.nw;

import dto.Employee;
import thread.Action;

import java.util.ArrayList;
import java.util.List;

public class FileSplitter {
    public void split(ArrayList<Employee> employee, int numOfSplit) {
        int constant = employee.size() / numOfSplit;
        for (int i = 0; i <= employee.size()-1; i += constant) {
            if (i + (constant - 1) > employee.size()) {
                addToThread(employee.subList(i, i + (employee.size()) - i));
            } else {
                addToThread(employee.subList(i, i + constant - 1));
            }
            if(i==employee.size()-(employee.size()%numOfSplit)){
                addToThread(employee.subList(i, employee.size()-1));
            }
        }
//        addToThread(employee.subList(i, i + constant - 1));

    }


    public synchronized void addToThread(List a) {
//        action.setSubList();
        ThreadPool.getThread(new ArrayList<>(a)).start();
//        thread.start();


    }
}
