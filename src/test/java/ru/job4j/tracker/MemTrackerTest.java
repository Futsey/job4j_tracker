package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class MemTrackerTest {
    @Test
    public void whenTestFindById() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        Item item = memTracker.add(bug);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        Item result = memTracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(new Item("First"));
        memTracker.add(new Item("Second"));
        memTracker.add(new Item("First"));
        List<Item> result = memTracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(new Item("First"));
        memTracker.add(new Item("Second"));
        memTracker.add(new Item("First"));
        List<Item> result = memTracker.findByName(second.getName());
        assertThat(result.get(0).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenTestItemAscByName() {
        List<Item> items = new ArrayList<Item>();
        Item beans = new Item("Beans");
        items.add(beans);
        Item rice = new Item("Rice");
        items.add(rice);
        Item peas = new Item("Peas");
        items.add(peas);
        Item groats = new Item("Groats");
        items.add(groats);
        Item millet = new Item("Millet");
        items.add(millet);
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = new ArrayList<Item>();
        expected.add(rice);
        expected.add(peas);
        expected.add(millet);
        expected.add(groats);
        expected.add(beans);
        assertEquals(expected, items);
    }

    @Test
    public void whenTestItemDescByName() {
        List<Item> items = new ArrayList<Item>();
        Item beans = new Item("Beans");
        items.add(beans);
        Item rice = new Item("Rice");
        items.add(rice);
        Item peas = new Item("Peas");
        items.add(peas);
        Item groats = new Item("Groats");
        items.add(groats);
        Item millet = new Item("Millet");
        items.add(millet);
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = new ArrayList<Item>();
        expected.add(rice);
        expected.add(peas);
        expected.add(millet);
        expected.add(groats);
        expected.add(beans);
        assertEquals(expected, items);
    }

    @Test
    public void whenReplaceWithMock() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Заявка изменена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenFindByIdWithMock() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Find item by id"));
        int idToFind = 1;
        FindByIDAction rep = new FindByIDAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(idToFind);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + tracker.findById(idToFind) + ln));
    }

    @Test
    public void whenDeleteWithMock() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        int idToDelete = 1;
        DeleteAction rep = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(idToDelete);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно." + ln));
        assertThat(tracker.findById(1), is(nullValue()));
    }

    @Test
    public void whenFindByNameWithMock() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Find item by name"));
        tracker.add(new Item("Bobby"));
        Item bob = new Item("Bob");
        tracker.add(bob);
        String nameToFind = "Bob";
        FindByNameAction rep = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(nameToFind);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        System.out.println(tracker.findByName(nameToFind));
        assertThat(out.toString(), is("=== Find items by name ===" + ln + bob + ln));
    }
}