package ru.job4j.oop;

public class Story {

    public static void main(String[] args) {
        Pioneer petya = new Pioneer();
        Girl girl = new Girl();
        Wolf wolfy = new Wolf();
        girl.helpCall(petya);
        wolfy.eat(girl);
        petya.kill(wolfy);
    }
}
