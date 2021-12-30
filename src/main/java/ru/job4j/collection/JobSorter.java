package ru.job4j.collection;

import java.util.*;

public class JobSorter {

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println("До сортировки: " + jobs);
        Collections.sort(jobs);
        System.out.println("После сортировки: " + jobs);
        Collections.sort(jobs, new SortByNameJob());
        System.out.println("После сортировки по имени: " + jobs);
        List<Job> secondJob = new ArrayList<Job>();
        secondJob.add(new Job("X task", 21));
        secondJob.add(new Job("Z task", 3));
        secondJob.add(new Job("Z task", 2));
        secondJob.add(new Job("Reboot server", 9));
        Collections.sort(secondJob, new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println("После комбинированной сортировки: " + secondJob);

        Comparator<Job> comb = new JobDescByNameLn()
                .thenComparing(new JobDescByName())
                .thenComparing(new JobAscByName())
                .thenComparing(new JobDescByPriority())
                .thenComparing(new JobAscByPriority());
        Collections.sort(jobs, comb);
    }
}
