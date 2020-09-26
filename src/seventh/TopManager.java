package seventh;
import java.math.*;
public class TopManager extends Position {
    private Incomner incomner;

    public TopManager(Incomner incomner) {
        super("TopManager");
        this.incomner = incomner;
    }

    public void setIncomner(Incomner incomner) {
        this.incomner = incomner;
    }


    @Override
    public double calcSalary(double baseSalary) {
        if(getSalary() == 0) {
            if (incomner.getIncome() > Math.pow(10, 6)) {
                setSalary(baseSalary * 1.5);
            } else {
                setSalary(baseSalary);
            }
        }
        return getSalary();
    }
}
