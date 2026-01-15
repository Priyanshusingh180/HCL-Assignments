package Assignment_4;
import java.sql.*;

class CreateStudentsTable {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String pass = "saud@123";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            st.executeUpdate("create database if not exists college");
            st.executeUpdate("use college");

            st.executeUpdate(
                "create table if not exists students(" +
                "eno int primary key," +
                "name varchar(30) not null," +
                "branch varchar(10) not null," +
                "sem int not null," +
                "percentage float not null)"
            );

            System.out.println("Database and Table Created Successfully");
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
