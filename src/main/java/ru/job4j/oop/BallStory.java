package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball kolobock = new Ball();
        Hare greyEar = new Hare();
        Wolf sharpTooth = new Wolf();
        Fox fireTail = new Fox();
        greyEar.tryEat(kolobock.tryRun(false));
        sharpTooth.tryEat(kolobock.tryRun(false));
        fireTail.tryEat(kolobock.tryRun(true));
    }
}
