package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Can`t find element in value");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"1", "2", "3", null, "4", "5"};
        try {
            System.out.println(indexOf(array, "keyword"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
