package ru.job4j.search;

import java.util.Arrays;
import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int count = 0;
        for (Task el : tasks) {
            if (task.getPriority() < el.getPriority()) {
                break;
            }
            count++;
        }
        this.tasks.add(count, task);
        System.out.println(task);
    }

    public Task take() {
        return tasks.poll();
    }
}
