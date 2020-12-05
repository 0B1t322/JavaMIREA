package ru.demin.pract19;

public class Account {
    private double money;
    private final long accNumber;
    private boolean isBlocked = false;

    public Account(long accNumber) {
        this.accNumber = accNumber;
    }

    public Account(double money, long accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public synchronized double getMoney() {
        return money;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public synchronized void setMoney(double money) {
        this.money = money;
    }

    public synchronized void addMoney(double money) {
        this.money += money;
    }

    public synchronized void subMoney(double money) throws Exception {
        if(this.money - money >= 0) {
            this.money -= money;
        } else throw new Exception("Not enough money");
    }

    public void block() {
        this.isBlocked = true;
    }

    public boolean checkIsBlocked() {
        return isBlocked;
    }
}
