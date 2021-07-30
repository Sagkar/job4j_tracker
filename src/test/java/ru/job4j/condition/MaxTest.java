package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void when1and2then2() {
        int a = 1;
        int b = 2;
        int out = 2;
        int expected = Max.max(a, b);
        Assert.assertEquals(out, expected);
    }

    @Test
    public void when1and2and3then3() {
        int a = 1;
        int b = 2;
        int c = 3;
        int out = 3;
        int expected = Max.max(a, b, c);
        Assert.assertEquals(out, expected);
    }

    @Test
    public void when1and2and3and4then2() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int out = 4;
        int expected = Max.max(a, b, c, d);
        Assert.assertEquals(out, expected);
    }

}