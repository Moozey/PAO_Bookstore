package Service;

import Model.Author;

import java.sql.*;

public class JDBC_AUTHOR {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost/projectpao";
    private static String user = "postgres";
    private static String password = "anavoinea";
    private static AuditService auditService = AuditService.getInstance();

    public JDBC_AUTHOR() {
        connectDB();
    }

    private static void connectDB() {
        try {
            connection = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to the PostgreSQL server successfully!");
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

    public void getAllAuthors() {
        try {
            auditService.write("Get all authors");
            System.out.println("The authors from this bookstore are:");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM author;");

            while (rs.next()) {
                int authorId = rs.getInt("id_author");
                String lastName = rs.getString("last_name");
                String firstName = rs.getString("first_name");
                String country = rs.getString("country");
                System.out.printf("Author Id = %s, lastName = %s, firstName = %s, country = %s\n", authorId, lastName, firstName, country);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createAuthor(Author author) {
        try {
            auditService.write("Create an author");
            Statement stmt = connection.createStatement();

            String query = "INSERT INTO author (id_author, last_name, first_name, country) " +
                    "VALUES (" + author.getId() + ", '"
                    + author.getLastName() + "', '"
                    + author.getFirstName() + "', '"
                    + author.getCountry() + "');";
            System.out.println(query);
            int result = stmt.executeUpdate(query);

            System.out.println("Author created successfully.");
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                System.out.println("The author exists already.");
            else
                e.printStackTrace();
        }
    }

    public void deleteAuthor(String lastName, String firstName) {
        try {
            auditService.write("Delete an author");
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM author WHERE last_name = '" + lastName
                    + "' AND first_name = '" + firstName + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            if (result == 0)
                System.out.println("The author doesn't exist, so it can't be deleted.");
            else
                System.out.println("Author deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAuthor(String authorLastName, String authorFirstName, String newLastName) {
        try {
            auditService.write("Update an author");
            Statement stmt = connection.createStatement();
            String query = "UPDATE author SET last_name = '" + newLastName + "' WHERE last_name = '" + authorLastName
                    + "' AND first_name = '" + authorFirstName + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            System.out.println("Author last name updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getAuthorIdByNames(String lastName, String firstName) {
        try {
            auditService.write("Get author id by name");
            if (connection == null)
                connectDB();
            Statement stmt = connection.createStatement();
            String query = "SELECT * from author WHERE" +
                    " (last_name = '"+ lastName + "' OR last_name = '" + firstName + "')" +
                    " AND" +
                    " (first_name = '" + firstName + "' OR first_name = '" + lastName + "');";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            int authorId = 0;
            while (rs.next()) {
                authorId = rs.getInt("id_author");

            }

            rs.close();
            stmt.close();
            return authorId;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
