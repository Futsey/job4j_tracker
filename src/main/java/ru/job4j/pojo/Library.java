package ru.job4j.pojo;

public class Library {

    public static Book[] swap(Book[] array, int source, int dest) {
        Book temp = array[source];
        array[source] = array[dest];
        array[dest] = temp;
        return array;
    }

    public static void wordFinder(Book[] books, String wordToFind) {
        for (Book book : books) {
            if (wordToFind.equals(book.getName())) {
                System.out.println("Searched book title: " + book.getName() + "; "
                        + book.getPageCount() + " pages");
            }
        }
    }

        public static void main(String[]args) {
            Book redBook = new Book("Red Book", 100);
            Book greenBook = new Book("Green Book", 200);
            Book whiteBook = new Book("White Book", 300);
            Book cleanCode = new Book("Clean code", 400);
            Book[] books = {redBook, greenBook, whiteBook, cleanCode};

            for (Book book : books) {
                System.out.println("Book title: " + book.getName() + "; "
                        + book.getPageCount() + " pages");
            }
            swap(books, 0, 3);
            for (Book book : books) {
                System.out.println("After swap: " + "Book title: " + book.getName() + "; "
                        + book.getPageCount() + " pages");
            }
            String wordToFind = "Clean code";
            wordFinder(books, wordToFind);
    }
}
