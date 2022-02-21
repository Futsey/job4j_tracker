package ru.job4j.collection.function;

import ru.job4j.lambda.Attachment;

import java.util.Arrays;
import java.util.Comparator;

public class FI {

    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        Arrays.sort(atts, comparator);
        System.out.println(Arrays.toString(atts));

        Comparator<Attachment> cmpDescSize = (left, right) -> Integer.compare(right.getSize(), left.getSize());
        Arrays.sort(atts, cmpDescSize);
        System.out.println("cmpDescSize: " + Arrays.toString(atts));

        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        System.out.println("cmpText: " + Arrays.toString(atts));
    }
}
