package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public class MemProfiling {

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(output),
                new MegaCreateAction(output),
                new ShowAllAction(output),
                new EditAction(output),
                new DeleteAction(output),
                new MegaDeleteAction(output),
                new FindByIDAction(output),
                new FindByNameAction(output),
                new EndAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
    }
}
