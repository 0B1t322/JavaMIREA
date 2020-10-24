package ru.demin.old.pract7_8;
import java.util.ArrayList;
import java.util.Random;

public class CompanyTest {
    public static void main(String[] args) {
        Random random = new Random();
        Company company = new Company();
        company.setIncome(1100000000);
        var operators = hireOperatots(180);
        company.hireAll(operators);

        ArrayList<Employee> managers = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            managers.add(new Employee(
                            "Jonh",
                            "Smit",
                    90000 + random.nextInt(30000),
                            new Manager()
                    )
            );
        }
        company.hireAll(managers);

        ArrayList<Employee> topManagers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            topManagers.add(new Employee(
                            "Jonh",
                            "Smit",
                    150000 + random.nextInt(30000),
                            new TopManager(company)
                    )
            );
        }
        company.hireAll(topManagers);

        System.out.printf("На данный момент в компании: %s человек\n", company.getCountOfEmployees());

        System.out.println("Топ 15 высоких зарплат");
        for(var emp: company.getTopSalaryStuff(15)) {
            System.out.println(emp.calcSalarry());
        }

        System.out.println("Топ 30 низких зарплат");
        for(var emp: company.getLowestSalaryStuff(30)) {
            System.out.println(emp.calcSalarry());
        }

        System.out.println("Удалим 50 процентов");
        company.fire(50);

        System.out.printf("На данный момент в компании: %s человек \n", company.getCountOfEmployees());

        System.out.println("Топ 15 высоких зарплат");
        for(var emp: company.getTopSalaryStuff(15)) {
            System.out.println(emp.calcSalarry());
        }

        System.out.println("Топ 30 низких зарплат");
        for(var emp: company.getLowestSalaryStuff(30)) {
            System.out.println(emp.calcSalarry());
        }
    }

    public static ArrayList<Employee> hireOperatots(int count) {
        Random random = new Random();
        ArrayList<Employee> operators = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            operators.add(new Employee(
                            "Jonh",
                            "Smit",
                            60000 + random.nextInt(10000),
                            new Operator()
                    )
            );
        }
        return operators;
    }
}
