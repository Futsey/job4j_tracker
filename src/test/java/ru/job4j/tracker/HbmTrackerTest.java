package ru.job4j.tracker;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HbmTrackerTest {

    @Test
    public void whenFindByIdSuccessful() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenReplaceSuccessful() {
        try (var tracker = new HbmTracker()) {
            Item original = new Item();
            original.setName("originalName");
            Item modified = new Item();
            modified.setName("modifiedName");
            tracker.add(original);
            tracker.add(modified);
            tracker.replace(original.getId(), modified);
            Assertions.assertTrue(tracker.replace(original.getId(), modified));
        }
    }

    @Test
    public void whenDeleteSuccessful() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            Assertions.assertEquals(item.getId(), result.getId());
            Assertions.assertTrue(tracker.delete(result.getId()));
        }
    }

    @Test
    public void whenFindByNameSuccessful() {
        try (var tracker = new HbmTracker()) {
            List<Item> itemList = List.of(
                    new Item("test1"),
                    new Item("test2"),
                    new Item("test3"));
            itemList.forEach(tracker::add);
            List<Item> result = tracker.findByName("test1");
            Assertions.assertEquals(itemList.get(0).getName(), result.get(0).getName());
        }
    }
}