import java.util.Scanner;

public class Login {
    private static final String USER = "admin";
    private static final String PASS = "admin123";

    public static boolean authenticate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        if (u.equals(USER) && p.equals(PASS)) {
            System.out.println("Login Successful");
            return true;
        }
        System.out.println("Invalid Credentials");
        return false;
    }
}