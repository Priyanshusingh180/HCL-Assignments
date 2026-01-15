package Assignment_4;
import java.sql.*;

class JdbcConnectionCheck {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "password"
            );
            System.out.println("Connection Successful");
            con.close();
        } catch (Exception e) {
            System.out.println("Unable to connect");
        }
    }
}
