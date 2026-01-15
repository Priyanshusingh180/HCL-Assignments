package Assignment_4;
import java.sql.*;

class IncreaseCsePercentage {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college",
            "root",
            "password"
        );

        Statement st = con.createStatement();
        st.executeUpdate(
            "update Students set percentage = percentage + 5 where branch='CSE'"
        );

        con.close();
    }
}
