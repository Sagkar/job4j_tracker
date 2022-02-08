package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadFunctionThenResult() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(1,3, x -> 3 * Math.pow(x, 2) - 1);
        List<Double> expected = Arrays.asList(2D, 11D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D);
        assertThat(result, is(expected));
    }
}