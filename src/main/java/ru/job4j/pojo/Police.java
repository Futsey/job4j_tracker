package ru.job4j.pojo;

import java.util.Date;

public class Police {

    public static void main(String[] args) {
        License andrew = new License();
        andrew.setOwner("Andrew Petrushin");
        andrew.setModel("Toyota Camry");
        andrew.setCode("a111ss");
        andrew.setCreated(new Date());

        System.out.println(andrew.getOwner() + " has a car - " + System.lineSeparator()
                + andrew.getModel() + " : " + andrew.getCode());
    }
}
