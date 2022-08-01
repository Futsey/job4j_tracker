package ru.job4j.tracker;

public class MemProfiling {

    public static void main(String[] args) {
        MemTracker memTracker = new MemTracker();
        for (int i = 0; i < 100000000; i++) {
            Item testItem = new Item();
            memTracker.add(testItem);
            if (i % 2 == 0) {
                memTracker.delete(i - 1);
            }
            System.out.println(testItem);
        }
    }
}
