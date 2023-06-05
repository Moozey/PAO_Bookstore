package Service;

import Model.Author;
import Model.Client;

import java.sql.*;

public class JDBC_CLIENT {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost/projectpao";
    private static String user = "postgres";
    private static String password = "anavoinea";
    private static AuditService auditService = AuditService.getInstance();

    public JDBC_CLIENT() {
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

    public void getAllClients() {
        try {
            auditService.write("Get all clients");
            System.out.println("The clients from this bookstore are:");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM client;");

            while (rs.next()) {
                int clientId = rs.getInt("id_client");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                System.out.printf("Client Id = %s, firstName = %s, lastName = %s,  address = %s, email = %s, phoneNumber = %s\n", clientId, firstName, lastName, address, email, phoneNumber);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createClient(Client client) {
        try {
            auditService.write("Create a client");
            Statement stmt = connection.createStatement();

            String query = "INSERT INTO client (id_client, first_name, last_name, address, email, phone_number) " +
                    "VALUES (" + client.getId() + ", '"
                    + client.getFirstName() + "', '"
                    + client.getLastName() + "', '"
                    + client.getAddress()
                    + client.getEmail()
                    + client.getPhoneNumber() + "');";
            System.out.println(query);
            int result = stmt.executeUpdate(query);

            System.out.println("Client created successfully.");
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                System.out.println("The client exists already.");
            else
                e.printStackTrace();
        }
    }

    public void deleteClient(String lastName, String firstName) {
        try {
            auditService.write("Delete a client");
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM client WHERE last_name = '" + lastName
                    + "' AND first_name = '" + firstName + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            if (result == 0)
                System.out.println("The client doesn't exist, so it can't be deleted.");
            else
                System.out.println("Client deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(String clientLastName, String clientFirstName, String newLastName) {
        try {
            auditService.write("Update a client");
            Statement stmt = connection.createStatement();
            String query = "UPDATE client SET last_name = '" + newLastName + "' WHERE last_name = '" + clientLastName
                    + "' AND first_name = '" + clientFirstName + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            System.out.println("Client's last name updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int getMaxIdClient(){
        try {
            if (connection == null)
                connectDB();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM client;");
            int maxId=0;
            while (rs.next()) {
                int clientId = rs.getInt("id_client");
                if( clientId > maxId){
                    maxId = clientId;
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

    public static int getClientIdByNames(String lastName, String firstName) {
        try {
            if (connection == null)
                connectDB();
            Statement stmt = connection.createStatement();
            String query = "SELECT * from client WHERE" +
                    " (last_name = '"+ lastName + "' OR last_name = '" + firstName + "')" +
                    " AND" +
                    " (first_name = '" + firstName + "' OR first_name = '" + lastName + "');";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            int clientId = 0;
            while (rs.next()) {
                clientId = rs.getInt("id_client");

            }

            rs.close();
            stmt.close();
            return clientId;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
