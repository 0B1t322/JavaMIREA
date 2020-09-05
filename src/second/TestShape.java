package second;

public class TestShape {
    public static void main(String[] args) {
        Shape rect = new Shape(1,1,4,"Rectangle");
        System.out.println(rect.toString());

        Shape square = new Shape(2,10,4,"Square");
        System.out.println(square.toString());
    }
}
