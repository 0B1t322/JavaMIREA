package seventh;
import java.util.Random;

public class Manager extends Position {
    public Manager() {
        super("Manager");
    }




    @Override
    public double calcSalary(double baseSalary) {
        if(this.getSalary() == 0) {
            Random random = new Random();
            double comSalary = 115000 + (random.nextInt(25000));
            setSalary( (comSalary * 0.05) + baseSalary);
        }
        return getSalary();
    }
}
