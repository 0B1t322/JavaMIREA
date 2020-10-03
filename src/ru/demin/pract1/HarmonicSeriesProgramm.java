package ru.demin.pract1;

public class HarmonicSeriesProgramm {

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++ ) {
            getHarmonicNum(i);
        }
    }

    public static void getHarmonicNum(int index) {
        double ans = 0;
        for(int i = 1; i < index + 1; i++) {
            double denom = (double) 1/i;
            ans += denom;
            System.out.printf("%.3f + ", denom );
        }
        System.out.printf(" = %f\n", ans );
    }
}
