package Service;

import Model.Book;

import java.sql.*;

public class JDBC_BOOK {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost/projectpao";
    private static String user = "postgres";
    private static String password = "anavoinea";
    private static AuditService auditService = AuditService.getInstance();

    public JDBC_BOOK() {
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
            auditService.write("Get all books");
            System.out.println("The books from db are:");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM book;");

            while (rs.next()) {
                int bookId = rs.getInt("id_book");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                int authorId = rs.getInt("id_author");
                int typeId = rs.getInt("id_type");
                int pages = rs.getInt("pages");
                System.out.printf("Book Id = %s, title = %s, description = %s, price = %s, authorId = %s, typeId = %s, pages = %s\n", bookId, title, description, price, authorId, typeId, pages);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createBook(int id_book, String title, String description, double price, int id_author, int id_type, int pages) {
        try {
            auditService.write("Create a book");
            Statement stmt = connection.createStatement();

            String query = "INSERT INTO book (id_book, title, description, price, id_author, id_type, pages) " +
                    "VALUES (" + id_book + ", '" + title + "', '"
                    + description + "', "
                    + price + ", "
                    + id_author + ", "
                    + id_type + ", "
                    + pages + ")";
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

    public void deleteBook(String title) {
        try {
            auditService.write("Delete a book");
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM book WHERE title = '" + title + "';";
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

    public void updateBook(String bookTitle, double newPrice) {
        try {
            auditService.write("Update a book");
            Statement stmt = connection.createStatement();
            String query = "UPDATE book SET price = " + newPrice + " WHERE title = '" + bookTitle + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            System.out.println("Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
