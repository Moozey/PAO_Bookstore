package Service;

import java.sql.*;

public class JDBC {
    public void connectDB (){
        String url = "jdbc:postgresql://localhost/projectpao";
        String user = "postgres";
        String password = "anavoinea";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery( "select * from roles;" );

            while ( rs.next() ) {

                int roleId = rs.getInt("role_id");

                String  roleName = rs.getString("role_name");

                System.out.printf( "Role Id = %s , Role name = %s", roleId,roleName );

                System.out.println();

            }

            rs.close();

            stmt.close();

            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
