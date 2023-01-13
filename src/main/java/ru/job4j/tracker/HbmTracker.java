package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private static final String SELECT_ALL = "FROM Item";
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
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
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
            session.createQuery(UPDATE)
                    .setParameter("fname", item.getName())
                    .setParameter("fcreated", item.getCreated())
                    .setParameter("fId", item.getId())
                    .executeUpdate();
            session.getTransaction().commit();
            rsl = true;
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
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
            session.createQuery(DELETE)
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
            rsl = true;
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> allItemsList = new ArrayList<>();
        Query query = session.createQuery(SELECT_ALL);
        for (Object st : query.list()) {
            allItemsList.add((Item) st);
        }
        return allItemsList;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> itemList = new ArrayList<>();
        Query query = session.createQuery(SELECT_ALL);
        for (Object st : query.list()) {
            if (st.equals(key)) {
                itemList.add((Item) st);
            }
        }
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
