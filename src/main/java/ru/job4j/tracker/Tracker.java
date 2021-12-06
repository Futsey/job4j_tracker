package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.job4j.tracker.Item;

public class Tracker {
    /*
    private final Item[] items = new Item[100];
     */
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        /*
        items[size++] = item;
         */
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        /*
        return index != -1 ? items[index] : null;
         */
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        /*
        return Arrays.copyOf(items, size);
         */
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        /*
        Item[] result = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item name = items[i];
            if (name.getName().equals(key)) {
                result[count++] = name;
            }
        }
        return Arrays.copyOf(result, count);
         */
        List<Item> result = new ArrayList<Item>();
        for (Item el : items) {
            if (el.getName().equals(key)) {
                result.add(el);
            }
        }
        return result;
    }

    /*
    * Создаем метод под булево значение, где в переменную index записываем элемент,
    * полученный посредством использования метода indexOf.
    *
    * Далее, чтобы перезаписать элемент, нам необходимо извлечь(скопировать)
    * его и поместить в переменную item
    *
    * Вся процедура осуществляется в операторе ветвления,
    * дабы исключить выход за отрицательную границу массива
    *
    * Внутри тела оператора ветвления мы присваиваем объекту item идентификатор
    * (достаем из аргумента), а далее записываем полученный в аргументе item
    * в ячейку нашего массива с индексом,
    * равным найденному индексу в начале итерации
    *
    * возвращаем true, если процесс состоялся
    *
    * возвращаем false, если процесс не состоялся
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            /*
            items[index] = item;
             */
            items.set(index, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            /*
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
             */
            items.remove(index);
            return true;
        }
        return false;
    }
}