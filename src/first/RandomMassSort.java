package first;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomMassSort {
    public static void main(String[] args) {

        Random random = new Random();

        ArrayList<Integer> mass;

        mass = GenerateWithMath();
        System.out.printf("Сгенерируем массив с помощью Math: %s\n", mass);

        Collections.sort(mass);
        System.out.printf("Отсортированный массив %s\n", mass);

        mass = GenerateWithRandom();
        System.out.printf("Сгенерируем массив с помощью Random: %s\n", mass);


        Collections.sort(mass);
        System.out.printf("Отсортированный массив %s\n",mass);
    }

    public static ArrayList<Integer> GenerateWithRandom() {
        ArrayList<Integer> mass = new ArrayList<Integer>();
        Random random = new Random();

        for(int i = 0; i < 10; i++) {
            int num = Math.abs(random.nextInt() % 100);
            mass.add(num);
        }

        return mass;
    }

    public static ArrayList<Integer> GenerateWithMath() {
        ArrayList<Integer> mass = new ArrayList<Integer>();

        for(int i = 0; i < 10; i++) {
            int num = (int) Math.abs((20 + Math.random() * 1000) % 100);
            mass.add(num);
        }

        return mass;
    }
}
