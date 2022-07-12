package org.example;

public class Book {
    private Author author;

    public Book(Author author) {
        this.author = author;
    }

    public Book() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
