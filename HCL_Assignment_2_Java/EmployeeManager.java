import java.util.*;
import java.util.regex.*;

interface EmployeeOps {
    void addEmployee();
    void displayEmployees();
}

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class EmployeeManager implements EmployeeOps {
    HashMap<Integer, Employee> hm = new HashMap<>();
    Hashtable<Integer, Employee> ht = new Hashtable<>();
    TreeMap<Integer, Employee> tm = new TreeMap<>();
    Scanner sc = new Scanner(System.in);

    public void addEmployee() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        if (!Pattern.matches("[A-Za-z ]+", name))
            throw new IllegalArgumentException("Invalid Name");
        Employee e = new Employee(id, name);
        hm.put(id, e);
        tm.put(id, e);
    }

    public void displayEmployees() {
        for (Map.Entry<Integer, Employee> e : tm.entrySet())
            System.out.println(e.getKey() + " " + e.getValue().name);
    }

    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();
        try {
            em.addEmployee();
            em.displayEmployees();

            em.hm.put(null, null); // allowed
            // em.ht.put(null, null); // not allowed

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
