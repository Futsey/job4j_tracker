package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private static final String SELECT_ALL = "FROM Item";
    private static final String SELECT_WHERE_NAME = "FROM Item WHERE name = :key";
    private static final String UPDATE = "UPDATE Item SET name = :fname, created = :fcreated WHERE id = :fId";
    private static final String DELETE = "DELETE Item WHERE id = :fId";

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            rsl = session.createQuery(UPDATE)
                    .setParameter("fname", item.getName())
                    .setParameter("fcreated", item.getCreated())
                    .setParameter("fId", item.getId())
                    .executeUpdate() != 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            rsl = session.createQuery(DELETE)
                    .setParameter("fId", id)
                    .executeUpdate() != 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery(SELECT_ALL, Item.class);
        session.close();
        return query.list();
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> itemList = session.createQuery(SELECT_WHERE_NAME, Item.class)
                .setParameter("key", key)
                .list();
        session.close();
        return itemList;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item item = session.find(Item.class, id);
        session.close();
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
