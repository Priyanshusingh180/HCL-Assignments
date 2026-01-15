package Assignment_4;
import java.sql.*;

class DisplayEcSemesterSeven {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college",
            "root",
            "password"
        );

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "select * from Students where semester=7 and branch='EC'"
        );

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("name") + " " +
                rs.getString("branch") + " " +
                rs.getInt("semester") + " " +
                rs.getFloat("percentage") + " " +
                rs.getInt("year_of_passing")
            );
        }

        con.close();
    }
}
