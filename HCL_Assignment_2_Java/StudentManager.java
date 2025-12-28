import java.util.*;
import java.util.regex.*;

interface StudentOperations {
    void addStudent();
    void displayStudents();
    void searchStudent(int roll);
    void removeStudent(int roll);
}

class Student {
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }
}

public class StudentManager implements StudentOperations {
    List<Student> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Roll: ");
        int r = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String n = sc.nextLine();
        if (!Pattern.matches("[A-Za-z ]+", n))
            throw new IllegalArgumentException("Invalid Name");
        list.add(new Student(r, n));
    }

    public void displayStudents() {
        for (Student s : list)
            System.out.println(s.roll + " " + s.name);
    }

    public void searchStudent(int roll) {
        for (Student s : list)
            if (s.roll == roll)
                System.out.println("Found: " + s.name);
    }

    public void removeStudent(int roll) {
        list.removeIf(s -> s.roll == roll);
    }

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        try {
            sm.addStudent();
            sm.displayStudents();
            sm.searchStudent(1);
            sm.removeStudent(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
