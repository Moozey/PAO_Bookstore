package Service;

import Model.Vinyl;

import java.sql.*;

public class JDBC_VINYL {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost/projectpao";
    private static String user = "postgres";
    private static String password = "anavoinea";

    public JDBC_VINYL() {
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

    public void getAllVinyls() {
        try {
            System.out.println("The vinyls from db are:");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM vinyl;");

            while (rs.next()) {
                int vinylId = rs.getInt("id_vinyl");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                String band = rs.getString("band");
                String type = rs.getString("type");
                System.out.printf("Vinyl Id = %s, title = %s, description = %s, price = %s, band = %s, type = %s\n", vinylId, title, description,price, band, type);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createVinyl(Vinyl vinyl) {
        try {
            Statement stmt = connection.createStatement();

            String query = "INSERT INTO vinyl (id_vinyl, title, description, price, band, type) " +
                    "VALUES (" + vinyl.getId() + ", '" + vinyl.getTitle() + "', '"
                    + vinyl.getDescription() + "', "
                    + vinyl.getPrice() + ", '"
                    + vinyl.getBand().getBandName() +  "', '"
                    + vinyl.getType().getName() +  "');";
            System.out.println(query);
            int result = stmt.executeUpdate(query);

            System.out.println("Vinyl created successfully.");
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                System.out.println("The vinyl exists already.");
            else
                e.printStackTrace();
        }
    }

    public void deleteVinyl(Vinyl vinyl) {
        try {
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM vinyl WHERE title = '" + vinyl.getTitle() + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            if (result == 0)
                System.out.println("The vinyl doesn't exist, so it can't be deleted.");
            else
                System.out.println("Vinyl deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVinyl(Vinyl vinyl, int newPrice) {
        try {
            Statement stmt = connection.createStatement();
            String query = "UPDATE vinyl SET price = " + newPrice + " WHERE title = '" + vinyl.getTitle() + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            System.out.println("Vinyl updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
