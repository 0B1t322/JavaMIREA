package pract1;

public class FactorialProgramm {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            System.out.printf("Факториал числа %s = %s\n",i, GetFactorialNum(i));
        }
    }

    public static int GetFactorialNum(int num) {
        int ans = 1;
        for(int i = 1; i < num + 1; i++) {
            ans *= i;
        }
        return ans;
    }
}
