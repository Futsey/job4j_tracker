package ru.job4j.tracker;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateRun {

    public static void main(String[] args) {
        var registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (var sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            var session = sf.openSession();
            session.beginTransaction();
            var item = new Item();
            item.setName("check timezone");
            item.setCreated(LocalDateTime.now());
            session.persist(item);
            session.getTransaction().commit();
            System.out.println(item.getCreated());
            System.out.println("__________________________________");

            var stored = session.createQuery(
                    "from Item", Item.class
            ).list();
            for (Item it : stored) {
                String time = it.getCreated().atZone(
                        ZoneId.of("UTC+3")
                ).format(DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd"));
                System.out.println("Your`s time: " + time);
            }

            System.out.println("__________________________________");

            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
