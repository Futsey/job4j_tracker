package ru.job4j.tracker;

public class MegaDeleteAction implements UserAction {

    private final Output output;

    public MegaDeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete Mega-Pack";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Delete Items from Mega-Pack ====");
        int itemsToDeleteSum = input.askInt("How many items i should delete? ");
        int count = 0;
        while (itemsToDeleteSum > 0 && itemsToDeleteSum <= tracker.findAll().size()) {
            if (tracker.delete(count)) {
                itemsToDeleteSum--;
            }
            count++;
        }
        return true;
    }
}
