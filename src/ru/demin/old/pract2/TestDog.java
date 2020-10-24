package ru.demin.old.pract2;

public class TestDog {
    public static void main(String[] args) {
        DogKennel dogKennel = new DogKennel();
        Dog little = new Dog(1,"Tomat");
        Dog rex = new Dog(3,"Persik");
        Dog haski = new Dog(2, "Medveshonok");

        dogKennel.add(little, rex);
        for(var dog: dogKennel.getDogs()) {
            System.out.printf("Информация о собаке: %s, возраст в человеческих годах: %s \n", dog.toString(), dog.humanAge());
        }

        dogKennel.add(haski);
        for(var dog: dogKennel.getDogs()) {
            System.out.printf("Информация о собаке: %s, возраст в человеческих годах: %s \n", dog.toString(), dog.humanAge());
        }

    }
}
