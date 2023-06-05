package Service;

import Model.Type;

import java.sql.*;

public class JDBC_TYPE {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost/projectpao";
    private static String user = "postgres";
    private static String password = "anavoinea";

    private static AuditService auditService = AuditService.getInstance();

    public JDBC_TYPE() {
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

    public void getAllTypes() {
        try {
            auditService.write("Get all types");
            System.out.println("The types from db are:");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM type;");

            while (rs.next()) {
                int typeId = rs.getInt("id_type");
                String name = rs.getString("name");
                System.out.printf("Type Id = %s, name = %s\n", typeId, name);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createType(Type type) {
        try {
            auditService.write("Get all types");
            Statement stmt = connection.createStatement();

            String query = "INSERT INTO type (id_type, name) " +
                    "VALUES (" + type.getId() + ", '" + type.getName() +  "');";
            System.out.println(query);
            int result = stmt.executeUpdate(query);

            System.out.println("Type created successfully.");
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                System.out.println("The type exists already.");
            else
                e.printStackTrace();
        }
    }

    public void deleteType(Type type) {
        try {
            auditService.write("Delete a type");
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM type WHERE title = '" + type.getName() + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            if (result == 0)
                System.out.println("The type doesn't exist, so it can't be deleted.");
            else
                System.out.println("Type deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateType(Type type, String typeName) {
        try {
            auditService.write("Update a type");
            Statement stmt = connection.createStatement();
            String query = "UPDATE type SET name = '" + typeName + "' WHERE title = '" + type.getName() + "';";
            System.out.println(query);
            int result = stmt.executeUpdate(query);
            System.out.println("Type updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int getMaxTypeId(){
        try {
            if (connection == null)
                connectDB();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM type;");
            int maxId=0;
            while (rs.next()) {
                int idType = rs.getInt("id_type");
                if( idType > maxId){
                    maxId = idType;
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
    public static int getTypeIdByNames(String name) {
        try {
            if (connection == null)
                connectDB();
            Statement stmt = connection.createStatement();
            String query = "SELECT * from type WHERE" +
                    " name = '"+ name +  "';";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            int typeId = 0;
            while (rs.next()) {
                typeId = rs.getInt("id_type");

            }

            rs.close();
            stmt.close();
            return typeId;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
