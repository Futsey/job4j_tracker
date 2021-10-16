package ru.job4j.oop;

public class College {

    public static void main(String[] args) {
        /*
        * Создаем новый экземпляр vasya, что имеет тип Freshman (первокурсник);
        * Создаем новый экземпляр petya, что приводит нашего vasya к типу Student
        * (а умеем сразу и в Object, проверенно=)));
        * Создаем новый экземпляр student, что приводит нашего vasya к типу Object;
        * Так как мы движемся от малого к большему, от потомка к родителю
        * по цепочке extends (а родитель по правой стороне всегда),
        * то вывод тут очевиден - это уверенный up casting.
         */
        Freshman vasya = new Freshman();
        Student petya = vasya;
        Object student = vasya;
    }
}
