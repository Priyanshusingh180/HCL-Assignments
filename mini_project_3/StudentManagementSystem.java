package mini_project_3;

import java.sql.*;
import java.util.*;

class InvalidStudentDataException extends Exception {
    InvalidStudentDataException(String msg) {
        super(msg);
    }
}

public class StudentManagementSystem {

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    static void connect() throws Exception {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "saud@123"
        );
    }

    static boolean login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();
        return u.equals("admin") && p.equals("admin123");
    }

    static void addStudent() {
        try {
            System.out.print("Eno: ");
            int eno = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Branch: ");
            String branch = sc.next();
            System.out.print("Sem: ");
            int sem = sc.nextInt();
            System.out.print("Percentage: ");
            float per = sc.nextFloat();

            if (branch.isEmpty() || sem <= 0)
                throw new InvalidStudentDataException("Sem or Branch cannot be empty");

            if (per <= 0)
                throw new InvalidStudentDataException("Percentage must be positive");

            PreparedStatement ps1 =
                    con.prepareStatement("select eno from students where eno=?");
            ps1.setInt(1, eno);
            ResultSet rs = ps1.executeQuery();

            if (rs.next())
                throw new InvalidStudentDataException("Eno must be unique");

            PreparedStatement ps2 =
                    con.prepareStatement("insert into students values(?,?,?,?,?)");
            ps2.setInt(1, eno);
            ps2.setString(2, name);
            ps2.setString(3, branch);
            ps2.setInt(4, sem);
            ps2.setFloat(5, per);
            ps2.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void displayAll() throws Exception {
        ResultSet rs = con.createStatement()
                .executeQuery("select * from students");

        while (rs.next())
            System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3) + " " +
                    rs.getInt(4) + " " +
                    rs.getFloat(5)
            );
    }

    static void searchByEno() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        PreparedStatement ps =
                con.prepareStatement("select * from students where eno=?");
        ps.setInt(1, eno);
        ResultSet rs = ps.executeQuery();

        if (rs.next())
            System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3) + " " +
                    rs.getInt(4) + " " +
                    rs.getFloat(5)
            );
        else
            System.out.println("Student Not Found");
    }

    static void updateBranch() {
        try {
            System.out.print("Eno: ");
            int eno = sc.nextInt();
            System.out.print("New Branch: ");
            String branch = sc.next();

            if (branch.isEmpty())
                throw new InvalidStudentDataException("Branch cannot be empty");

            PreparedStatement ps =
                    con.prepareStatement("update students set branch=? where eno=?");
            ps.setString(1, branch);
            ps.setInt(2, eno);

            System.out.println(ps.executeUpdate() > 0 ? "Updated" : "Not Found");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void deleteByEno() throws Exception {
        System.out.print("Eno: ");
        int eno = sc.nextInt();

        PreparedStatement ps =
                con.prepareStatement("delete from students where eno=?");
        ps.setInt(1, eno);

        System.out.println(ps.executeUpdate() > 0 ? "Deleted" : "Not Found");
    }

    static void displaySorted() throws Exception {
        ResultSet rs = con.createStatement()
                .executeQuery("select * from students order by percentage desc");

        while (rs.next())
            System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3) + " " +
                    rs.getInt(4) + " " +
                    rs.getFloat(5)
            );
    }

    public static void main(String[] args) throws Exception {

        connect();

        if (!login()) {
            System.out.println("Invalid Login");
            return;
        }

        while (true) {
            System.out.println(
                    "\n1.Add Student\n2.Display All\n3.Search by Eno\n" +
                    "4.Update Branch\n5.Delete by Eno\n6.Display Sorted\n7.Exit"
            );

            int ch = sc.nextInt();

            switch (ch) {
                case 1: addStudent(); break;
                case 2: displayAll(); break;
                case 3: searchByEno(); break;
                case 4: updateBranch(); break;
                case 5: deleteByEno(); break;
                case 6: displaySorted(); break;
                case 7: System.exit(0);
                default: System.out.println("Invalid Choice");
            }
        }
    }
}
