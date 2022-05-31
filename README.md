# job4j. II part

Учебный проект. Основные аспекты JAVA Core

### Визуализация учебного блока:


``` JAVA
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(value -> new Tuple(
                        value.getName(),
                        value.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
```

### **Программа учебного блока:**

>### 1. Java Collections Framework

>### 2. Comparator and Comparable

>### 3. Lambda and Stream API;

>### 4. Iterator;

>### 5. Generic;

...

