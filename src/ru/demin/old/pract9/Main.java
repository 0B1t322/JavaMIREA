package ru.demin.old.pract9;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random();

        for(int i = 0; i < 50; i++) {
            company.hireEmployee(new Employee(
                    "Jonh",
                    "Snow",
                    LocalDate.of(random.nextInt(2020),1 + random.nextInt(11),1 + random.nextInt(20)),
                    "Black Castle",
                    "00000000",
                    10_000 + random.nextInt(40_000)
            ));
        }
        company.SomeEmployee(new SalarySelector(30_000));
        System.out.println("-----------------------");
        company.SomeEmployee(new EmployeeSelector() {
            @Override
            public boolean needEmployee(Employee employee) {
                return employee.getBirthDate().getYear() > 700;
            }
        });
        System.out.println("-----------------------");
        company.SomeEmployee( employee -> employee.getSalary() > 40000);
        System.out.println("-----------------------");
        company.doSomethingWithSomeEmployee(
                employee -> employee.getBirthDate().getDayOfMonth() > 15,
                (employee, index) -> {
                System.out.println("------" + index + "------");
                System.out.println(employee);
            });
    }

}
