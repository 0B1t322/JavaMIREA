package ru.demin.pract19;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static final int countOfUsers = 1_000_000;
    public static void main(String[] args) {
        Random random = new Random();
        Bank bank = new Bank();
        createsAccounts().forEach(bank::addAccount);
        BankRunner bankRunner = new BankRunner(bank);

        new Thread(bankRunner).start();

        for(int i = 0; i < 1000000; i++) {
            var from = random.nextInt(countOfUsers);
            var to = random.nextInt(countOfUsers);
            var money = random.nextInt(100_000) + 10_000;
            do {
                to = random.nextInt(countOfUsers);
            } while (to == from);

            bankRunner.addTransfer(from,to,money);
        }

    }

    public static ArrayList<Account> createsAccounts() {
        Random random = new Random();
        ArrayList<Account> accounts = new ArrayList<>();
        for(int i = 0; i < countOfUsers; i++) {
            accounts.add(
                    new Account(
                        random.nextInt(200_000) + 1000,
                            i
                    )
            );
        }

        return accounts;
    }
}
