package pract9;

import java.util.ArrayList;

public class Company {
    private final ArrayList<Employee> employees = new ArrayList<>();

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void SomeEmployee(EmployeeSelector employeeSelector) {
        for(var emp: employees) {
            if(employeeSelector.needEmployee(emp)) {
                System.out.println(emp);
            }
        }
    }

    public void doSomethingWithSomeEmployee(EmployeeSelector employeeSelector,
                                       EmployeeHandler handler) {
        int count = 0;
        for(var emp: employees) {
            if(employeeSelector.needEmployee(emp)) {
                handler.handleEmp(emp, count);
                count++;
            }
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }
}
