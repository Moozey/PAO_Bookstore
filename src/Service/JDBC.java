package Service;

import Model.Book;

import java.sql.*;

public class JDBC {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost/projectpao";
    private static String user = "postgres";
    private static String password = "anavoinea";

    public JDBC() {
        connectDB();
    }

    private static void connectDB() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed successfully.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllBooks() {
        try {
            System.out.println("The books from db are:");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM book1;");

            while (rs.next()) {
                int bookId = rs.getInt("id_book");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                String author = rs.getString("author");
                String type = rs.getString("type");
                int pages = rs.getInt("pages");
                System.out.printf("Book Id = %s, title = %s, author = %s, price = %s\n", bookId, title, description,price, author, type, pages);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createBook(Book book) {
        try {
            Statement stmt = connection.createStatement();

            String query = "INSERT INTO book1 (id_book, title, description, price, author, type, pages) " +
                    "VALUES (" + book.getId() + ", '" + book.getTitle() + "', '"
                    + book.getDescription() + "', "
                    + book.getPrice() + ", '"
                    + book.getAuthor().getLastName() + " " + book.getAuthor().getFirstName() + "', '"
                    + book.getType().getName() + "', "
                    + book.getPages() + ")";
            System.out.println(query);
            int result = stmt.executeUpdate(query);

            System.out.println("Book created successfully.");
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                System.out.println("The book exists already.");
            else
                e.printStackTrace();
        }
    }

    public void deleteBook(Book book) {
        try {
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM book1 WHERE title = '" + book.getTitle() + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            if (result == 0)
                System.out.println("The book doesn't exist, so it can't be deleted.");
            else
                System.out.println("Book deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book, int newPrice) {
        try {
            Statement stmt = connection.createStatement();
            String query = "UPDATE book1 SET price = " + newPrice + " WHERE title = '" + book.getTitle() + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            System.out.println("Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
