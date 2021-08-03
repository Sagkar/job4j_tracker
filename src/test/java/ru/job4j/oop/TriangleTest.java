package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.condition.Point;
import ru.job4j.condition.Triangle;

public class TriangleTest {

    @Test
    public void area() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

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
