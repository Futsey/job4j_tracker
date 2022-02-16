package ru.job4j.collection.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

/**
 * Класс описывает работу основных функциональных интерфейсов в JAVA
 * @author ANDREW PETRUSHIN (JOB4J project)
 * @version 1.0
 */
public class FunctionInterfaceUsage {

    public static void main(String[] args) {

        /*
         * Пример работы функционального интерфейса Supplier (поставщик)
         * @param String
         */
        Supplier<String> sup = () -> "New String For Interface";
        System.out.println("sup:" + sup.get());

        /*
         * Пример работы функционального интерфейса Supplier (поставщик) в коллекции HashSet
         * @param String
         */
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supHash = () -> new HashSet<>(list);
        Set<String> strings = supHash.get();
        for (String s : strings) {
            System.out.println("supHash:" + s);
        }

        /*
         * Пример работы функционального интерфейса Consumer (потребитель)
         * @param s (String)
         */
        Supplier<String> supCons = () -> "New String For Interface";
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("supCons:" + supCons.get());

        /*
         * Пример работы функционального интерфейса BiConsumer (потребитель с двумя аргументами)
         * @param i,s1 (Integer, String)
         */
        Supplier<String> supBiCons = () -> "New String For Interface";
        BiConsumer<String, String> biCons = (s, s1) -> System.out.println(s + s1);
        biCons.accept("supBiCons:" + supBiCons.get(), "and the second String");

        List<String> monsterList = List.of("Godzilla", "King Kong", "Zmey Goriyniych", "Baba Yaga", "King Kong", "Putin");
        Supplier<Set<String>> supBiConsMonster = () -> new HashSet<>(monsterList);
        BiConsumer<Integer, String> biConsMonster = (i, s1) -> System.out.println("biConsMonster:" + i + s1);
        Set<String> monsterStr = supBiConsMonster.get();
        int i = 1;
        for (String s : monsterStr) {
            biConsMonster.accept(i++, " is " + s);
        }

        /*
         * Пример работы функционального интерфейса Predicate (утверждение)
         * @param s (String)
         */
        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("pred: " + "Строка пустая: " + pred.test(""));
        System.out.println("pred: " + "Строка пустая: " + pred.test("test"));

        /*
         * Пример работы функционального интерфейса Predicate (утверждение с двумя аргументами)
         * @param s,j (String, Integer)
         */
        BiPredicate<String, Integer> biPred = (s, j) -> s.contains(j.toString());
        System.out.println("biPred: " + "Строка содержит подстроку: " + biPred.test("Name123", 123));
        System.out.println("biPred: " + "Строка содержит подстроку: " + biPred.test("Name", 123));

        /*
         * Пример работы функционального интерфейса Function
         * @param s (String)
         */
        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("func: " + "Третий символ в строке: " + func.apply("first"));
        System.out.println("func: " + "Третий символ в строке: " + func.apply("second"));

        /*
         * Пример работы функционального интерфейса Function  (утверждение с двумя аргументами)
         * @param s,k (String, Integer)
         */
        BiFunction<String, Integer, String> biFunc = (s, k) -> s.concat(" ").concat(k.toString());
        System.out.println("biFunc: " + "Результат работы бифункции: " + biFunc.apply("Name", 123));
        System.out.println("biFunc: " + "Результат работы бифункции: " + biFunc.apply("String number", 12345));

        /*
         * Пример работы функционального интерфейса UnaryOperator
         * @param t (StringBuilder)
         */
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("builder: " + "Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("builder: " + "Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));

        /*
         * Пример работы функционального интерфейса BinaryOperator
         * @param b1, b2 (StringBuilder, StringBuilder)
         */
        BinaryOperator<StringBuilder> binBuilder = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "binBuilder: "
                        + "Строка после объединения: " + binBuilder.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
