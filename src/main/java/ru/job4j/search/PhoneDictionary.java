package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> rst = new ArrayList<Person>();
        for (Person value : persons) {
            if (value.getName().contains(key)
                    || value.getSurname().contains(key)
                    || value.getPhone().contains(key)
                    || value.getAdress().contains(key)) {
                rst.add(value);
                System.out.println("Method find: found: " + value);
            } else {
                System.out.println("Method find: nothing found");
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        PhoneDictionary vasya = new PhoneDictionary();
        vasya.add(new Person("Vasya", "Vasechkin", "333333", "Omsk"));
        vasya.find("Va");
    }
}

