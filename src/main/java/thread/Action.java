package thread;

import JDBC.EmployeeGateway;
import dto.Employee;

import java.util.ArrayList;

public class Action extends Thread {
    private ArrayList<Employee> subList;

    public void setSubList(ArrayList<Employee> subList) {
        this.subList = subList;
    }

    @Override
    public void run() {
        try {
            EmployeeGateway e = new EmployeeGateway();
            e.createEmployee(subList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
