package ru.demin.pract14;

public class CountTime<E> {
    public long countTime(SomeMethod<E> e, E someList) {

        long start = System.nanoTime();

        e.method(someList);

        long end = System.nanoTime() - start;

        return end;

    }
}
