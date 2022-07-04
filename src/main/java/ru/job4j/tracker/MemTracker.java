package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует интерфейс
 * @see ru.job4j.tracker.Store
 * Все экземпляры класса в оперативной памяти, в отличие от класса
 * @see ru.job4j.tracker.SqlTracker
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
public class MemTracker implements Store {

    /**
     * данные храним в листе с параметризацией наших заявок<Item>
     * поле ids является уникальным идентификатором для кождого созданного экземпляра заявки
     */
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    /**
     * Метод добавляет заявку
     * принимает заявку
     * @param item
     * возвращает новый элемент с проинкрементированным id
     * {@link #ids} )}
     * @return item (новая заявка)
     */
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    /**
     * Метод производит поиск заявки по ID
     * принимает уникальный идентификатор заявки
     * @param id
     * возвращает заявку по id, либо null
     * @return item (либо null)
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Метод производит поиск индекса заявки
     * принимает уникальный идентификатор заявки
     * @param id
     * возвращает индекс существующей заявки по id
     * @return index
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод производит поиск всех заявок
     * возвращает лист со всеми заявками
     * @return items
     */
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    /**
     * Метод производит поиск по имени
     * принимает строковое значение заявки
     * @param key
     * возвращает лист с искомым именем
     * @return items
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<Item>();
        for (Item el : items) {
            if (el.getName().equals(key)) {
                result.add(el);
            }
        }
        return result;
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
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            return true;
        }
        return false;
    }

    /**
     * Метод удаляет заявку
     * принимает уникальный идентификатор заявки
     * @param id
     * возвращает булев флаг об успешном удалении заявки по id
     * @return true\false
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }
}