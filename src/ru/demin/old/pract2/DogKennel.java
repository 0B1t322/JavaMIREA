package ru.demin.old.pract2;

import java.util.ArrayList;

public class DogKennel {
    private ArrayList<Dog> dogs;

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public DogKennel() {
        dogs = new ArrayList<Dog>();
    }

    public void add(Dog ...dogs) {
        for(var dog : dogs) {
            this.dogs.add(dog);
        }
    }
}