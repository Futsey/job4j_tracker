package ru.job4j.collection;

import java.util.*;

/**
 * Класс описывает стандартизированную структуру виртуального департамента с сетью подведомственных подразделений.
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
public class Departments {

    /**
     * @param deps - список структурных подразделений департамента;
     * @return упорядоченный список подразделений департамента;
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = "".equals(start) ? el : start + "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<String>(tmp);
    }

    /**
     * Метод производит сортировку данных в естественном порядке;
     * @param orgs - список структурных подразделений департамента для сортировки;
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    /**
     * Метод производит сортировку данных в порядке, объявленном в классе:
     * @see DepDescComp;
     * @param orgs - список структурных подразделений департамента для сортировки;
     */
    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }

    @Override
    public String toString() {
        return "Departments{}";
    }
}
