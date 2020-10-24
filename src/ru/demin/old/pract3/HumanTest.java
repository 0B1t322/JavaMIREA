package ru.demin.old.pract3;

public class HumanTest {
    public static void main(String[] args) {
        Human human = new Human("blue",14,7);
        human.getHands()[0].setLenght(8);
        human.getHands()[1].setLenght(9);
        human.getHands()[0].clenchedFist();
        human.getHead().blink();
        human.getLegs()[0].makeStep();
    }
}
