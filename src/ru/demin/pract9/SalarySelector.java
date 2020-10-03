package ru.demin.pract9;

public class SalarySelector implements EmployeeSelector {
    private double salary;

    public SalarySelector(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean needEmployee(Employee employee) {
        return employee.getSalary() > salary;
    }
}
