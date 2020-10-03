package ru.demin.pract7_8;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Company implements Incomner {
    private double income;
    final private ArrayList<Employee> employees;

    public Company() {
        employees = new ArrayList<Employee>();
    }

    public Company(double income) {
        employees = new ArrayList<Employee>();
        this.income = income;
    }

    public int getCountOfEmployees() {
        return employees.size();
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public double getIncome() {
        return income;
    }

    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void hireAll(ArrayList<Employee> employees) {
            this.employees.addAll( employees );
    }

    public void fire(Position position, int count) {
        for(int i = 0; i < count; i++) {
            for(int j = 0; j < employees.size(); j++){
                if(employees.get(j).getEmployeePosition().getJobTittle() == position.getJobTittle()) {
                    employees.remove(j);
                }
            }
        }
    }

    public void fire(String name, String secondName) {
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getName() == name || employees.get(i).getSecondName() == secondName) {
                employees.remove(i);
                return;
            }
        }
    }

    public void fire(float percent) {
        Collections.shuffle(this.employees);
        int count = 0;
        int size = employees.size();
        for (int j = 0; ((float) count / size) < percent/100; j++ ) {
            employees.remove(j);
            count++;
        }
    }

    public List<Employee> getTopSalaryStuff(int count) {
        if(count < 0 || count > employees.size()) {
            return null;
        }
        ArrayList<Employee> top = new ArrayList<Employee>(this.employees);
        Collections.sort(top, Comparator.comparing(Employee::calcSalarry));
        Collections.reverse(top);
        ArrayList<Employee> countOfTop = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            countOfTop.add( top.get(i) );
        }
        return countOfTop;
    }

    public List<Employee> getLowestSalaryStuff(int count) {
        if(count < 0 || count > employees.size()) {
            return null;
        }
        ArrayList<Employee> low = new ArrayList<Employee>(this.employees);
        Collections.sort(low, Comparator.comparing(Employee::calcSalarry));
        ArrayList<Employee> countOfLow = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            countOfLow.add( low.get(i) );
        }

        return countOfLow;
    }
}
