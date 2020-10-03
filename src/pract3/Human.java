package pract3;

public class Human {
    private Head head;
    private Leg[] legs;
    private Hand[] hands;

    public Hand[] getHands() {
        return hands;
    }

    public void setHands(Hand[] hands) {
        this.hands = hands;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Leg[] getLegs() {
        return legs;
    }

    public void setLegs(Leg[] legs) {
        this.legs = legs;
    }

    public Human(String eyeColor, float legLenght, float handLenght) {
        head = new Head(eyeColor);
        legs = new Leg[]{new Leg(legLenght), new Leg(legLenght)};
        hands = new Hand[]{new Hand(handLenght), new Hand(handLenght)};
    }
}
