package ru.job4j.tracker;

public class MegaCreateAction implements UserAction {

    private final Output output;

    public MegaCreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Create Mega-Pack";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== New Items in Mega-Pack ====");
        int newItemSum = input.askInt("How many items i should create? ");
        for (int i = 0; i < newItemSum; i++) {
            Item item = new Item("TestItem" + i);
            tracker.add(item);
        }
        return true;
    }
}
