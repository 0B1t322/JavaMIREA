package ru.demin.pract19;

import java.util.HashMap;
import java.util.Random;

public class Bank {
    private HashMap<Long, Account> accounts;
    private final double CHECKABLEOPER = 50_000;
    private long accountLenght = 0;

    public Bank() {
        accounts = new HashMap<>();
    }

    public long getAccountLenght() {
        return accountLenght;
    }

    public synchronized void addAccount(Account account) {
        if( !accounts.containsKey( account.getAccNumber() ) ) {
            accounts.put( account.getAccNumber(), account );
        }
        accountLenght = accounts.size();
    }

    public void transfer(long accNumberFrom, long accNumberTo, double money) {
        var from = accounts.get(accNumberFrom);
        var to = accounts.get(accNumberTo);

        if(from.checkIsBlocked() || to.checkIsBlocked()) {
            System.err.println("Transaction Blocked");
            return;
        }

        if( money > CHECKABLEOPER && isFraud() ) {
            to.block();
            from.block();
        }

        try {
            from.subMoney(money);
            to.addMoney(money);
        } catch (Exception e) {
            System.err.println(e.toString());
            return;
        }

        System.out.printf("new balance of %s is %s\n", from.getAccNumber(), from.getMoney());
        System.out.printf("new balance of %s is %s\n", to.getAccNumber(), to.getMoney());
    }

    private boolean isFraud() {
        Random random = new Random();
        try {
            Thread.sleep(1000);
            return random.nextInt(200000) % 10 == 0;
        } catch (InterruptedException e) {
            System.err.println(e.toString());
            return false;
        }
    }

    public double getBalance(long accNumber) throws NullPointerException {
        return accounts.get(accNumber).getMoney();
    }
}
