package Model;

import java.util.*;

public class Book extends Product {

    private Author author;
    private Type type;
    private int pages;
    private static List<Book> listOfBooks = new ArrayList<Book>();

    public Book(String title, String description, double price, Author author, Type type, int pages) {
        super(title, description, price);
        this.author = author;
        this.type = type;
        this.pages = pages;
        addBookToList(this);
    }

    public void addBookToList(Book book){
        this.listOfBooks.add(book);
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

    public static List<Book> getListOfBooks() {
        return listOfBooks;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", type=" + type +
                ", pages=" + pages +
                '}';
    }
}