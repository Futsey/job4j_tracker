package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = p -> p.getName().contains(key);
        Predicate<Person> predSurname = p -> p.getSurname().contains(key);
        Predicate<Person> predPhone = p -> p.getPhone().contains(key);
        Predicate<Person> predAdress = p -> p.getAdress().contains(key);
        Predicate<Person> combine = predName
                .or(predSurname
                .or(predPhone
                .or(predAdress)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;

        /*
        * OUTDATE CODE
        ArrayList<Person> rst = new ArrayList<Person>();
        for (Person value : persons) {
            if (value.getName().contains(key)
                    || value.getSurname().contains(key)
                    || value.getPhone().contains(key)
                    || value.getAdress().contains(key)) {
                rst.add(value);
            }
        }
        return rst;
         */
    }

    public static void main(String[] args) {
        PhoneDictionary vasya = new PhoneDictionary();
        vasya.add(new Person("Vasya", "Vasechkin", "333333", "Omsk"));
        vasya.find("Va");
    }
}

