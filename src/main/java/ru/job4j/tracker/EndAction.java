package ru.job4j.tracker;

public class EndAction implements UserAction {

    @Override
    public String name() {
        return "Exit programm";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Exit programm ====");
        return false;
    }
}
