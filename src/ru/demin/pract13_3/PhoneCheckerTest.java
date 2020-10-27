package ru.demin.pract13_3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.JUnit4;
import ru.demin.pract12.task_3;

import static org.junit.jupiter.api.Assertions.*;

class PhoneCheckerTest {
    PhoneChecker phoneChecker = new PhoneChecker();

    @org.junit.jupiter.api.Test
    void ifPhoneNumber() {
        String number = "89199656474";

        Assert.assertEquals(true, PhoneChecker.ifPhoneNumber(number));
    }

    @org.junit.jupiter.api.Test
    void ifPhoneNumberString() {
        String[] numbers = new String[] {
                "89199656324", "8 917 965 64-74", "+7 (909) 963-64-74"
        };
        String ans = "";
        for(var number : numbers) {
            try {
                ans = PhoneChecker.ifPhoneNumberString(number);
            } catch (IllegalStateException e) {
                fail(e);
            }

            System.out.println(task_3.getFormatedNubmer(ans));
        }

        String[] failsNumbers = new String[] {"2","9 919 934 45 78"};
        for(var number: failsNumbers) {
            try {
                PhoneChecker.ifPhoneNumberString(number);
                fail(); // если не словил экзепшон то тест не пройден
            } catch (IllegalStateException e) {
                // попасть сюда обязательно
            }

        }


    }
}