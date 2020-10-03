package ru.demin.pract7_8;

public abstract class Position implements EmployeePosition {
    private String jobTittle;
    private double salary;

    protected void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public Position(String jobTittle) {
        this.jobTittle = jobTittle;
        this.salary = 0;
    }

    @Override
    public String getJobTittle() {
        return jobTittle;
    }

}
