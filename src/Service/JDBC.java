package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    private Connection connection;

    public JDBC() {
        connectDB();
    }

    private void connectDB() {
        String url = "jdbc:postgresql://localhost/projectpao";
        String user = "postgres";
        String password = "anavoinea";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully!!!!!!!!.");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery( "select * from book;" );

            while ( rs.next() ) {

                int bookId = rs.getInt("id_book");

                String  title = rs.getString("title");
                String  author = rs.getString("author");
                int price = rs.getInt("price");

                System.out.printf( "Book Id = %s , title = %s, author = %s, price = %s", bookId,title,author,price );

                System.out.println();

            }

            rs.close();

            stmt.close();

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

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }
}
