package Model;

import java.util.*;

public class Book extends Product {

    private Author author;
    private Type type;
    private int pages;

    public Book(int id, String title, String description, double price, Author author, Type type, int pages) {
        super(id, title, description, price);
        this.author = author;
        this.type = type;
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}