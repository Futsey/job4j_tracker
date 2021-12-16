package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {

    /*
    * добавили поле с перечнем граждан
     */
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        /*
        * по умолчанию вносимый персонаж у нас присутствует в списке
         */
        boolean rsl = false;
        /*
        * если перечень не содержит данных о паспорте
         */
        if (!citizens.containsKey(citizen.getPassport())) {
            /*
            * то добавляем нового гражданина и говорим сервису, что персонаж уникален (true)
             */
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        /*
        * заглядываем в паспорт и возвращаем значение в тест
         */
        citizens.get(passport);
        return citizens.get(passport);
    }
}
