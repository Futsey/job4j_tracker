package ru.job4j.tracker;

public class EndAction implements UserAction {

    private final Output out;

    public EndAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit programm";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Exit programm ====");
        return false;
    }
}
