package ru.demin.pract7_8;

public class Operator extends Position {

    public Operator() {
        super("Operator");
    }


    @Override
    public double calcSalary(double baseSalary) {
        if(getSalary() == 0) {
            setSalary(baseSalary);
        }
        return getSalary();
    }
}
