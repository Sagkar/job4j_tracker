package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void ifTriangleNotExist() {
    Point a = new Point(0, 2);
    Point b = new Point(0, 3);
    Point c = new Point(0, 6);
    Triangle triangle = new Triangle(a, b , c);
    double expected = -1;
    double out = triangle.area();
    Assert.assertEquals(expected, out, 0.1);
    }
}