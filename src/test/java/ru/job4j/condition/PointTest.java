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
}