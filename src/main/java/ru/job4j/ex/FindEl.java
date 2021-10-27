package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                rsl = index;
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
            indexOf(array, "22");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
