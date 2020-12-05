package ru.demin.pract19;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class BankRunner implements Runnable {
    private Bank bank;
    private Queue<Thread> transferPool      = new ArrayDeque<>();
    private Queue<Thread> addAccountPool    = new ArrayDeque<>();

    public BankRunner(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (transferPool) {
                if (transferPool.size() != 0) {
                    transferPool.poll().start();
                }
            }
            synchronized (addAccountPool) {
                if (addAccountPool.size() != 0) {
                    addAccountPool.poll().start();
                }
            }
        }
    }

    public void addTransfer(
            long accNumberFrom,
            long accNumberTo,
            double money
    ) {
        transferPool.add(new Thread(() -> {
                    bank.transfer(accNumberFrom, accNumberTo, money);
            })
        );
    }

    public void addAccount(long accNumber, double money) {
        addAccountPool.add(new Thread( () -> {
                    bank.addAccount(new Account(money, accNumber));
            })
        );
    }
}
