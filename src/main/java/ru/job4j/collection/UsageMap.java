package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> user = new HashMap<>();
        user.put("boba@bob.com", "Bob Thornton");
        for (Map.Entry<String, String> element : user.entrySet()) {
            System.out.println(element);
        }
        user.put("Andrew@andrew.com", "Andrew Petrushin");
        user.put("Andrew@andrew.com", "Andrey petrushin");
        for (String key : user.keySet()) {
            String value = user.get(key);
            System.out.println(key + "|" + value);
        }
    }
}
