package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class TrackerTest {
    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(0).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenTestItemAscByName() {
        List<Item> items= new ArrayList<Item>();
        items.add(new Item("Beans"));
        items.add(new Item("Rice"));
        items.add(new Item("Peas"));
        items.add(new Item("Groats"));
        items.add(new Item("Millet"));
        List<Item> expected = new ArrayList<Item>();
        expected.addAll(items);
        Collections.sort(expected, new ItemAscByName());
        assertTrue(expected.size() == items.size()
                && expected.containsAll(items) && items.containsAll(expected));
    }

    @Test
    public void whenTestItemDescByName() {
        List<Item> items= new ArrayList<Item>();
        items.add(new Item("Beans"));
        items.add(new Item("Rice"));
        items.add(new Item("Peas"));
        items.add(new Item("Groats"));
        items.add(new Item("Millet"));
        List<Item> expected = new ArrayList<Item>();
        expected.addAll(items);
        Collections.sort(expected, new ItemDescByName());
        assertTrue(expected.size() == items.size()
                && expected.containsAll(items) && items.containsAll(expected));
    }
}