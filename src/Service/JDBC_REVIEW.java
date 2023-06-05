package Service;

import Model.Review;

import java.sql.*;

public class JDBC_REVIEW {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost/projectpao";
    private static String user = "postgres";
    private static String password = "anavoinea";
    private static AuditService auditService = AuditService.getInstance();


    public JDBC_REVIEW() {
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

    public void getAllReviews() {
        try {
            auditService.write("Get all reviews");
            System.out.println("The reviews from db are:");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM review;");

            while (rs.next()) {
                int reviewId = rs.getInt("id_review");
                int rating = rs.getInt("rating");
                String description = rs.getString("description");
                int clientId = rs.getInt("id_client");
                int productId = rs.getInt("id_product");
                System.out.printf("Review Id = %s, rating = %s, description = %s, clientId = %s, productId = %s\n", reviewId, rating, description,clientId, productId);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createReview(Review review, int productId) {
        try {
            auditService.write("Create a review");
            Statement stmt = connection.createStatement();

            String query = "INSERT INTO review (id_review, rating, description, id_client, id_product) " +
                    "VALUES (" + review.getId() + ", " + review.getRating() + ", '"
                    + review.getDescription() + "', "
                    + review.getClientId() + ", "
                    + review.getProductId() + ");";
            System.out.println(query);
            int result = stmt.executeUpdate(query);

            System.out.println("Review created successfully.");
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                System.out.println("The review exists already.");
            else
                e.printStackTrace();
        }
    }

    public void deleteReview(Review review) {
        try {
            auditService.write("Tried to delete a review");
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM review WHERE id_review = " + review.getId() + ";";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            if (result == 0)
                System.out.println("The review doesn't exist, so it can't be deleted.");
            else
                System.out.println("Review deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReview(String reviewDescription, String newDescription) {
        try {
            auditService.write("Update a review");
            Statement stmt = connection.createStatement();
            String query = "UPDATE review SET description = '" + newDescription + "' WHERE description = '" + reviewDescription + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            System.out.println("Review updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
