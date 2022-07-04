package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        items.add(new Item("Beans"));
        items.add(new Item("Rice"));
        items.add(new Item("Peas"));
        items.add(new Item("Groats"));
        items.add(new Item("Millet"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = new ArrayList<Item>();
        expected.add(new Item("Beans"));
        expected.add(new Item("Groats"));
        expected.add(new Item("Millet"));
        expected.add(new Item("Peas"));
        expected.add(new Item("Rice"));
        assertEquals(expected, items);
    }

    @Test
    public void whenTestItemDescByName() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Beans"));
        items.add(new Item("Rice"));
        items.add(new Item("Peas"));
        items.add(new Item("Groats"));
        items.add(new Item("Millet"));
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = new ArrayList<Item>();
        expected.add(new Item("Rice"));
        expected.add(new Item("Peas"));
        expected.add(new Item("Millet"));
        expected.add(new Item("Groats"));
        expected.add(new Item("Beans"));
        assertEquals(expected, items);
    }
}