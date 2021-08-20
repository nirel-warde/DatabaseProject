package thread;

import com.sparta.nw.ReadFile;
import dao.EmployeeGateway;
import dto.Employee;

import java.util.ArrayList;

public class Action extends Thread {
    private ArrayList<Employee> subList;

//    TODO split array in 4
//     probably use subArray to split the array
//     initialise the thread in a for loop


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
