package ru.job4j.tracker;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Класс для создания заявок
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
@Entity
@Table(name = "items")
@Data
public class Item {
    /**
     * поле FORMATTER редактирует конечный вид даты создания заявки
     * поле id является уникальным идентификатором заявки
     * поле name является названием заявки
     * поле created автоматически определяет дату создания заявки
     */
    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

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
}