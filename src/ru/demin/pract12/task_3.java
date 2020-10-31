package ru.demin.pract12;

import java.text.Format;
import java.util.*;


public class task_3 {
    final static int LENGHT = 11;

    final static String format = "+7 (%s%s%s) %s%s%s-%s%s-%s%s";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> nums = new ArrayList<String>(Arrays.asList(
                scanner.nextLine().replace("+7","7").
                replace(" ", "").
                replace("-","").
                replace("(", "").
                replace(")", "").
                split("")));

        switch (nums.size()) {
            case 11:
                if(!nums.get(0).equals("8") && !nums.get(0).equals("7")) {
                    System.out.println("Неверный формат номера");
                    return;
                } else if(nums.get(0).equals("8")){
                    nums.remove("8");
                    System.out.println(formatPhoneNumber(nums));
                } else {
                    nums.remove("7");
                    System.out.println(formatPhoneNumber(nums));
                }
                break;
            case 10:
                System.out.println(formatPhoneNumber(nums));
                break;
            default:
                System.out.println("Неверный формат номера");
                break;
        }
    }

    public static String formatPhoneNumber(List<String> nums) {
        String phoneNumber = "+7 (";

        int i = 0;
        while (i < nums.size()){
            int count = 0;
            for(int k = 0; k < 2 ; k++) {
                for (int j = 0; j < 3; j++) {

                    phoneNumber += nums.get(i);
                    count++;
                    i++;
                    if (count == 3) {
                        if(k == 0) phoneNumber += ") ";
                        else phoneNumber += "-";
                        count = 0;
                    }
                }
            }

            count = 0;
            for(int k = 0; k < 2; k++) {
                for (int j = 0; j < 2; j++) {

                    phoneNumber += nums.get(i);
                    count++;
                    i++;
                    if (count == 2) {
                        if(k != 1)phoneNumber += "-";
                        count = 0;
                    }
                }
            }
            return phoneNumber;
        }

        return phoneNumber;
    }

    public static String getFormatedNubmer(String number) {
        ArrayList<String> nums = new ArrayList<String>(Arrays.asList(
                number.replace("+7","7").
                        replace(" ", "").
                        replace("-","").
                        replace("(", "").
                        replace(")", "").
                        split("")));

         if(nums.get(0).equals("8")){
            nums.remove("8");
            return formatPhoneNumber(nums);
        } else if (nums.get(0).equals("7")){
            nums.remove("7");
            return formatPhoneNumber(nums);
        } else {
             return formatPhoneNumber(nums);
         }
    }

}
