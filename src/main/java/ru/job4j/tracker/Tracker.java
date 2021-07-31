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
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        for (Item value : items) {
            if (value != null) {
                itemsWithoutNull[size] = value;
                size++;
            }
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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }
    public boolean delete(int id) {
        int index = indexOf(id);
        if(index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            return true;
        }
     return false;
    }
}
