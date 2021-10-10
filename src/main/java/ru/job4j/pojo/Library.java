package ru.job4j.pojo;

public class Library {

    public static Book[] swap(Book[] array, int firstElementToSwap, int secondElementToSwap) {
        Book temp = array[firstElementToSwap];
        array[firstElementToSwap] = array[secondElementToSwap];
        array[secondElementToSwap] = temp;
        return array;
    }

    public static boolean wordFinder(Book[] array, String wordToFind) {
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(wordToFind)) {
                found = true;
                System.out.println("Book " + wordToFind + " found." + "Index of book: " + array[i]);
            }
        }
        return found;
    }

        public static void main(String[]args) {
            Book redBook = new Book("Red Book", 100);
            Book greenBook = new Book("Green Book", 200);
            Book whiteBook = new Book("White Book", 300);
            Book cleanCode = new Book("Clean code", 400);
            Book[] books = {redBook, greenBook, whiteBook, cleanCode};

            for (Book array : books) {
                System.out.println("Book title: " + array.getName() + "; "
                        + array.getPageCount() + " pages");
            }
            swap(books, 0, 3);
            for (Book array : books) {
                System.out.println("After swap: " + "Book title: " + array.getName() + "; "
                        + array.getPageCount() + " pages");
            }
            String wordToFind = "Green Book";
            wordFinder(books, wordToFind);
    }
}
