package Service;

import Model.Product;

import java.sql.*;

public class JDBC_PRODUCT {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost/projectpao";
    private static String user = "postgres";
    private static String password = "anavoinea";
    private static AuditService auditService = AuditService.getInstance();

    public JDBC_PRODUCT() {
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

    public void getAllProducts() {
        try {
            auditService.write("Get all products");
            System.out.println("The products from db are:");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM product;");

            while (rs.next()) {
                int productId = rs.getInt("id_product");
                String title = rs.getString("title");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                System.out.printf("Product Id = %s, title = %s, description = %s, price = %s\n", productId, title, description,price);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createProduct(Product product) {
        try {
            auditService.write("Create a prodct");
            Statement stmt = connection.createStatement();

            String query = "INSERT INTO product (id_product, title, description, price) " +
                    "VALUES (" + product.getId() + ", '" + product.getTitle() + "', '"
                    + product.getDescription() + "', "
                    + product.getPrice() + ");";
            System.out.println(query);
            int result = stmt.executeUpdate(query);

            System.out.println("Product created successfully.");
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                System.out.println("The product exists already.");
            else
                e.printStackTrace();
        }
    }

    public void deleteProduct(String title) {
        try {
            auditService.write("Delete a product");
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM product WHERE title = '" + title + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            if (result == 0)
                System.out.println("The product doesn't exist, so it can't be deleted.");
            else
                System.out.println("Product deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(String productTitle, double price) {
        try {
            auditService.write("Update a product");
            Statement stmt = connection.createStatement();
            String query = "UPDATE product SET price = " + price + " WHERE title = '" + productTitle+ "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            System.out.println("Product price updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getMaxId(){
        try {
            if (connection == null)
                connectDB();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM product;");
            int maxId=0;
            while (rs.next()) {
                int productId = rs.getInt("id_product");
                if( productId > maxId){
                    maxId = productId;
                }
            }

            rs.close();
            stmt.close();
            return maxId;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public static int getProductIdByNames(String productName) {
        try {
            auditService.write("Get product id by name");
            if (connection == null)
                connectDB();
            Statement stmt = connection.createStatement();
            String query = "SELECT * from product WHERE" +
                    " title = '"+ productName + "';";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            int productId = 0;
            while (rs.next()) {
                productId = rs.getInt("id_product");

            }

            rs.close();
            stmt.close();
            return productId;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
