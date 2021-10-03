package ru.job4j.oop;

public class Cat {

    private String name;
    private String food;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void show() {
        System.out.println("Nick of that cat: " + this.name);
        System.out.println("Food of that cat: " + this.food);
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("Rissole");
        gav.giveNick("Gav");
        gav.show();
        Cat black = new Cat();
        black.eat("Fish");
        black.giveNick("Black");
        black.show();
    }
}
