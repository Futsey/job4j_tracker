package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Класс реализует интерфейс
 * @see ru.job4j.tracker.Store
 * Все экземпляры класса в Базе данных, в отличие от класса
 * @see ru.job4j.tracker.MemTracker
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
public class SqlTracker implements Store, AutoCloseable {

    /**
     * поле cn является основным соединением с БД
     */
    private Connection cn;

    /**
     * Метод начинает соединение с БД
     * возвращает ошибку, если соединение невозможно
     * @see java.lang.IllegalStateException
     */
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Метод реализует функционал интерфейса
     * @see java.lang.AutoCloseable
     * и автоматически закрывает соединение в случае выхода программы из блока try-with-resources в методе
     * {@link #init()} )}
     */
    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    /**
     * Метод добавляет заявку в БД
     * принимает заявку
     * @param item
     * добавляет элемент в таблицу в полями "Имя" и "Дата создания заявки"
     * возвращает созданную заявку
     * @return item (новая заявка)
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = cn.prepareStatement(
                "insert into items (name, created) values(?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Метод перезаписывает заявку
     * принимает уникальный идентификатор заявки
     * @param id
     * а также новую заявку
     * @param item
     * возвращает булев флаг об успешности замены заявки по id
     * @return true\false
     */
    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set name = ?, created = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод удаляет заявку
     * принимает уникальный идентификатор заявки
     * @param id
     * возвращает булев флаг об успешном удалении заявки по id
     * @return true\false
     */
    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод производит поиск всех заявок
     * возвращает лист со всеми заявками
     * @return items
     */
    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items order by id")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(setNewItem(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Метод производит поиск по имени
     * принимает строковое значение заявки
     * @param key
     * возвращает лист с искомым именем
     * @return items
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(setNewItem(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Метод производит поиск заявки по ID
     * принимает уникальный идентификатор заявки
     * @param id
     * возвращает заявку по id, либо null
     * @return item (либо null)
     */    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = setNewItem(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public Item setNewItem(ResultSet resultSet) throws SQLException {
        return new Item(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getTimestamp("created").toLocalDateTime()
        );
    }
}
