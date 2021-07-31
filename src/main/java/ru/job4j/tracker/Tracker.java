package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        for (Item value : items) {
            if (value != null)
                itemsWithoutNull[size] = value;
            size++;
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        for (Item item : itemsWithoutNull) {
            System.out.println(item);
        }
        return items;
    }

    public Item[] findByName(String key) {
        Item[] withoutNull = new Item[items.length];
        int size = 0;
        for (Item value : items) {
            if (value != null && value.getName().equals(key)) {
                withoutNull[size] = value;
                size++;
            }
        }
        withoutNull = Arrays.copyOf(withoutNull, size);
        for (Item item : withoutNull) {
            System.out.println(item);
        }
        return withoutNull;
    }
}