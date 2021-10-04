package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare greyEar = new Hare();
        Wolf sharpTooth = new Wolf();
        Fox fireTail = new Fox();
        greyEar.tryEat(kolobok.tryRun(false));
        sharpTooth.tryEat(kolobok.tryRun(false));
        fireTail.tryEat(kolobok.tryRun(true));
    }
}
