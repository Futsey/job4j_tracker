package ru.job4j.collection;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobSorterTest {

    @Test
    public void whenCompatorZeroAtNameAndAscOnPrority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 32),
                new Job("Impl task", 12)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorZeroAtProrityAndAscOnName() {
        Comparator<Job> cmpNamePriority =
                new JobDescByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorZeroAtProrityAndDescOnName() {
        Comparator<Job> cmpNamePriority =
                new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    
    @Test
    public void whenCompatorZeroAtNameAndDescOnPrority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Impl task", 24)
        );
        assertThat(rsl, greaterThan(0));
    }
}