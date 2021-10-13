package ru.job4j.tracker;

import java.util.Arrays;
import ru.job4j.tracker.Item;

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
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item name = items[index];
            if (name != null) {
                itemsWithoutNull[size] = name;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        for (int index = size; index < itemsWithoutNull.length; index++) {
            System.out.println(itemsWithoutNull[index]);
        }
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] sameNameItems = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (name != null && name.getName().equals(key)) {
                sameNameItems[size] = name;
                size++;
            }
        }
        sameNameItems = Arrays.copyOf(sameNameItems, size);
        for (int index = size; index < sameNameItems.length; index++) {
            System.out.println(sameNameItems[index]);
        }
        return sameNameItems;
    }
}