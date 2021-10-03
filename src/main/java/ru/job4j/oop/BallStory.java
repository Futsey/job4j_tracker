package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball kolobock = new Ball();
        Hare greyEar = new Hare();
        Wolf sharpTooth = new Wolf();
        Fox fireTail = new Fox();
        greyEar.tryEat(kolobock);
        sharpTooth.tryEat(kolobock);
        fireTail.tryEat(kolobock);
    }
}
