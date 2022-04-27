# job4j. II part

Учебный проект. Основные аспекты JAVA Core

### Визуализация учебного блока:


``` JAVA
    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> map = new HashMap<>();
        Info info = new Info(0, 0, 0);
        info = new Info(
                info.getAdded(),
                info.getChanged(),
                info.getDeleted());
        for (User user: previous) {
            map.put(user.getId(), user.getName());
        }
        for (User user: current) {
            String el = map.get(user.getId());
            if (el == null) {
                info.setAdded(info.getAdded() + 1);
            } else if (el != null && !el.equals(user.getName())) {
                info.setChanged(info.getChanged() + 1);
            }
            info.setDeleted((previous.size() + info.getAdded()) - current.size());
        }
        return info;
    }
```

### **Программа учебного блока:**

>### 1. Java Collections Framework

>### 2. Comparator and Comparable

>### 3. Lambda and Stream API;

>### 4. Iterator;

>### 5. Generic;

...

