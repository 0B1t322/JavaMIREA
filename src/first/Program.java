package first;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Integer> mass = new ArrayList<Integer>();

        for(int i = 0; i < 10; i++) {
            int num = Math.abs(random.nextInt() % 100);
            mass.add(num);
        }

        System.out.printf("Массив: %s\n",mass);
        System.out.printf("Сумма массива с помощью цикла for: %s\n",MassSumWithFor(mass));
        System.out.printf("Сумма массива с помощью цикла while: %s\n",MassSumWithWhile(mass));
        System.out.printf("Сумма массива с помощью цикла do while: %s\n",MassSumWithDoWhile(mass));

    }

    public static int MassSumWithFor(List<Integer> mass) {
        int sum = 0;
        for(int i = 0; i < mass.size(); i++) {
            sum += mass.get(i);
        }
        return sum;
    }

    public static int MassSumWithWhile(List<Integer> mass) {
        int sum = 0;
        int i = 0;
        while (i < mass.size()) {
            sum += mass.get(i);
            i++;
        }
        return sum;
    }

    public static int MassSumWithDoWhile(List<Integer> mass) {
        int sum = 0;
        int i = 0;
        do {
            sum += mass.get(i);
            i++;
        } while (i < mass.size());
        return sum;
    }
}