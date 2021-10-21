package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == null) {
                try {
                    throw new ElementNotFoundException("Can`t find element in value");
                } catch (ElementNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Index of array, where exception happened: " + i);
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        FindEl testValue = new FindEl();
        String[] array = {"1", "2", "3", null, "4", "5"};
        testValue.indexOf(array, "4");
    }
}
