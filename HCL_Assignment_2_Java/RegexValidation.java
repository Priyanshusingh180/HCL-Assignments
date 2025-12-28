import java.util.Scanner;
import java.util.regex.*;

public class RegexValidation {
    static Scanner sc = new Scanner(System.in);

    static boolean validate(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {
        int choice;
        try {
            do {
                System.out.println("\n1.Mobile\n2.Email\n3.Username\n4.Password\n5.Exit");
                System.out.println("Enter your choice:");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Mobile: ");
                        String mobile = sc.nextLine();
                        if (validate(mobile, "[6-9][0-9]{9}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Mobile Number");
                        break;

                    case 2:
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        if (validate(email, "[a-zA-Z0-9._%+-]+@[a-z]+\\.[a-z]{2,}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Email");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String user = sc.nextLine();
                        if (validate(user, "[A-Za-z0-9_]{5,15}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Username");
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        String pass = sc.nextLine();
                        if (validate(pass, "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}"))
                            System.out.println("Welcome!");
                        else
                            System.out.println("Invalid Password");
                        break;
                }
            } while (choice != 5);
        } catch (Exception e) {
            System.out.println("Error Occurred");
        }
    }
}
