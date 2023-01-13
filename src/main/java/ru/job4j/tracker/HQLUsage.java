package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class HQLUsage {

    public static void main(String[] args) {

        final String SEPARATOR = "____________________".concat(System.lineSeparator());

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            /* working with session */

            /* Sselect all */
            System.out.println("Find all: ");
            selectAll(session);
            /* Select unique */
            System.out.println(SEPARATOR);
            System.out.println("Select unique: ");
            unique(session);
            /* Select by ID */
            System.out.println(SEPARATOR);
            System.out.println("Select by ID: ");
            findById(session, 3);
            /* Update */
            System.out.println(SEPARATOR);
            System.out.println("Update: ");
            update(session, 3);
            /* Delete */
            System.out.println(SEPARATOR);
            System.out.println("Delete: ");
            delete(session, 3);
            selectAll(session);

            System.out.println("done");
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static void selectAll(Session session) {
        Query query = session.createQuery("from Item");
        for (Object st : query.list()) {
            System.out.println(st);
        }
    }

    /* select unique */
    public static void unique(Session session) {
        Query<Item> query = session.createQuery(
                "from Item as i where i.id = 3", Item.class);
        System.out.println(query.uniqueResult());
    }

    /* select by ID */
    public static void findById(Session session, int id) {
        Query<Item> query = session.createQuery(
                "from Item as i where i.id = :fId", Item.class);
        query.setParameter("fId", id);
        System.out.println(query.uniqueResult());
    }

    /* update */
    public static void update(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                            "UPDATE Item SET name = :fName WHERE id = :fId")
                    .setParameter("fName", "Oleg")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    /* delete */
    public static void delete(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                            "DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
