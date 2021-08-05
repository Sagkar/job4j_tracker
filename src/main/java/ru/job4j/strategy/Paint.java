package ru.job4j.strategy;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint contex = new Paint();
        contex.draw(new Triangle());
        contex.draw(new Square());
    }
}
