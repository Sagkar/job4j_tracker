package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortByNameItemTest {

    @Test
    public void compare() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Bbb"));
        items.add(new Item("Ccc"));
        items.add(new Item("Aaa"));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Aaa"));
        expected.add(new Item("Bbb"));
        expected.add(new Item("Ccc"));
        Collections.sort(items, new ItemAscByName());
        assertThat(expected, is(items));
    }

    @Test
    public void reversed() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Aaa"));
        items.add(new Item("Bbb"));
        items.add(new Item("Ccc"));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Ccc"));
        expected.add(new Item("Bbb"));
        expected.add(new Item("Aaa"));
        Collections.sort(items, new ItemDeskByName());
        assertThat(expected, is(items));
    }
}