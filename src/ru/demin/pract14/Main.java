package ru.demin.pract14;

import java.util.*;

public class Main {
    public static int parseInt(boolean var) {
        if(var == true) return 1;
        else return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] finded = new String[] {"не найден", "найден"};

        BeatifulCarNumber beatifulCarNumber = new BeatifulCarNumber();

        String search = scanner.next();

        final boolean[] find = new boolean[4];
        double time = (double) new CountTime<ArrayList>().countTime(new SomeMethod<ArrayList>() {
            @Override
            public void method(ArrayList someList) {
                find[0] = someList.contains(search);
            }
        }, beatifulCarNumber.carNumbers) / 1000000000;

        System.out.printf("Поиск перебором: номер %s, поиск занял %10f\n", finded[parseInt(find[0])],time);

        Collections.sort(beatifulCarNumber.carNumbers);

        time =  (double) new CountTime<ArrayList>().countTime(new SomeMethod<ArrayList>() {
                    @Override
                    public void method(ArrayList someList) {
                        if(Collections.binarySearch(someList,search) >= 0) {
                            find[1] = true;
                        } else
                            find[0] = false;
                    }
                }, beatifulCarNumber.carNumbers) / 1000000000;

        System.out.printf("Бинарный поиск: номер %s, поиск занял %10f\n", finded[parseInt(find[1])], time);


        time =  (double) new CountTime<HashSet>().countTime(new SomeMethod<HashSet>() {
                @Override
                public void method(HashSet someList) {
                    find[2] = someList.contains(search);
                }
            }, new HashSet(beatifulCarNumber.carNumbers)) / 1000000000;

        System.out.printf("Поиск в HashSet: номер %s, поиск занял %10f\n", finded[parseInt(find[2])], time);


        time =  (double) new CountTime<TreeSet>().countTime(new SomeMethod<TreeSet>() {
                @Override
                public void method(TreeSet someList) {
                    find[3] = someList.contains(search);
                }
            }, new TreeSet(beatifulCarNumber.carNumbers)) / 1000000000;

        System.out.printf("Поиск в HashSet: номер %s, поиск занял %10f\n", finded[parseInt(find[3])], time);


// В666ЕА16



    }
}
