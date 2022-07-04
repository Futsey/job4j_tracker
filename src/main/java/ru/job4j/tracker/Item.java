package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Класс для создания заявок
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
public class Item {
    /**
     * поле FORMATTER редактирует конечный вид даты создания заявки
     * поле id является уникальным идентификатором заявки
     * поле name является названием заявки
     * поле created автоматически определяет дату создания заявки
     */
    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object k) {
        if (this == k) {
            return true;
        }
        if (k == null || getClass() != k.getClass()) {
            return false;
        }
        Item item = (Item) k;
        return id == item.id && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Item {"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created = " + created.format(FORMATTER)
                + '}';
    }
}