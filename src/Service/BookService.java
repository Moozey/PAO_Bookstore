package Service;

import Model.Author;
import Model.Book;
import Model.Type;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private JDBC jdbc;

    public BookService() {
        jdbc = new JDBC();
    }

    public void createBook(Book book) {
//        System.out.println("Book created successfully.");
        String query = "INSERT INTO book1 (id_book, title, description, price, author, type, pages) VALUES (" + book.getId() + ", '" + book.getTitle() + "', '"
                + book.getDescription() + "', "
                + book.getPrice() + ", '"
                + book.getAuthor().getLastName() + " " + book.getAuthor().getFirstName() + "', '"
                + book.getType().getName() + "', "
                + book.getPages() + ")";
        jdbc.executeQuery(query);
        System.out.println();
        System.out.println(query);
        System.out.println("Book created successfully.");

    }
    public void deletBook(Book book) {
//        System.out.println("Book created successfully.");
        String query = "INSERT INTO book1 (id_book, title, description, price, author, type, pages) VALUES (" + book.getId() + ", '" + book.getTitle() + "', '"
                + book.getDescription() + "', "
                + book.getPrice() + ", '"
                + book.getAuthor().getLastName() + " " + book.getAuthor().getFirstName() + "', '"
                + book.getType().getName() + "', "
                + book.getPages() + ")";
        jdbc.executeQuery(query);
        System.out.println();
        System.out.println(query);
        System.out.println("Book created successfully.");

    }
}