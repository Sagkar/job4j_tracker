package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when000And006Then44() {
        Point x = new Point(0, 0, 0);
        Point y = new Point(0, 0, 6);
        double expected = 6;
        double out = x.distance3d(x, y);
        Assert.assertEquals(expected, out, 0.1);
    }

    @Test
    public void when00to00then0() {
        double expected = 0;
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when00to23then360() {
        double expected = 3.60;
        Point a = new Point(0, 0);
        Point b = new Point(2, 3);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

}