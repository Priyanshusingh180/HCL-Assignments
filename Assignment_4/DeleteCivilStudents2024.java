package Assignment_4;
import java.sql.*;

class DeleteCivilStudents2024 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college",
            "root",
            "password"
        );

        Statement st = con.createStatement();
        st.executeUpdate(
            "delete from Students where year_of_passing=2024 and branch='Civil'"
        );

        con.close();
    }
}
