package seventh;

public class Employee {
    private String name;
    private String secondName;
    private double baseSalery;
    private EmployeePosition employeePosition;

    public Employee(String name, String secondName, double baseSalery, EmployeePosition employeePosition) {
        this.name = name;
        this.secondName = secondName;
        this.baseSalery = baseSalery;
        this.employeePosition = employeePosition;
    }


    // getters --------

    public String getName() {
        return name;
    }

    public double getBaseSalery() {
        return baseSalery;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public String getSecondName() {
        return secondName;
    }

    public double calcSalarry() {
        return employeePosition.calcSalary(this.baseSalery);
    }
    // ----------

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalery(double baseSalery) {
        this.baseSalery = baseSalery;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    // ---------
}
