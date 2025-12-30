import java.io.*;
import java.util.*;

public class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();
    private final String FILE = "employees.txt";

    public EmployeeManager() {
        loadFromFile();
    }

    private void loadFromFile() {
        File f = new File(FILE);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                employees.add(Employee.fromString(line));
            }
        } catch (Exception e) {
            System.out.println("Error loading file");
        }
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (Employee e : employees) {
                pw.println(e);
            }
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    public void addEmployee(Employee e) throws Exception {
        for (Employee emp : employees) {
            if (emp.getId() == e.getId())
                throw new Exception("Employee ID must be unique");
        }
        employees.add(e);
        saveToFile();
    }

    public void displayAll() {
        employees.forEach(System.out::println);
    }

    public Employee searchById(int id) {
        for (Employee e : employees)
            if (e.getId() == id) return e;
        return null;
    }

    public void updateSalary(int id, double salary) throws Exception {
        if (salary <= 0) throw new Exception("Salary must be positive");
        Employee e = searchById(id);
        if (e == null) throw new Exception("Employee not found");
        e.setSalary(salary);
        saveToFile();
    }

    public void deleteEmployee(int id) throws Exception {
        Employee e = searchById(id);
        if (e == null) throw new Exception("Employee not found");
        employees.remove(e);
        saveToFile();
    }

    public void displaySorted() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
    }

    public void displayDepartments() {
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);
    }
}