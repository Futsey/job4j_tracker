package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        String answer = input.nextLine();
        int randomize = new Random().nextInt(3);
            if (randomize == 0) {
                System.out.println("Да");
            } else if (randomize == 1) {
                System.out.println("Нет");
            } else {
                System.out.println("Может быть...");
            }
    }
}

