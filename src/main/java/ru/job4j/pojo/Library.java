package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 500);
        Book cook = new Book("Cooking", 300);
        Book math = new Book("Math", 450);
        Book anatomy = new Book("Anatomy", 350);
        Book[] books = {cleanCode, cook, math, anatomy};
        for (Book book : books) {
            System.out.println(book.getName() + " " + book.getPages() + " pages");
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book: books) {
            System.out.println(book.getName() + " " + book.getPages() + " pages");
        }
        for (Book book : books) {
            if ("Clean Code".equals(book.getName())) {
                System.out.println(book.getName() + " " + book.getPages() + " pages");
            }
        }
    }
}
