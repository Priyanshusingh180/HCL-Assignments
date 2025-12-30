import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (!Login.authenticate()) return;

        EmployeeManager manager = new EmployeeManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Employee\n2.Display All\n3.Search by ID\n4.Update Salary\n5.Delete Employee\n6.Display Sorted\n7.Display Departments\n8.Exit");
            int ch = sc.nextInt();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Department: ");
                        String dept = sc.nextLine();
                        if (dept.isEmpty()) throw new Exception("Department cannot be empty");
                        manager.addEmployee(new Employee(id, name, sal, dept));
                        break;

                    case 2:
                        manager.displayAll();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        Employee e = manager.searchById(sc.nextInt());
                        System.out.println(e != null ? e : "Employee not found");
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int uid = sc.nextInt();
                        System.out.print("New Salary: ");
                        manager.updateSalary(uid, sc.nextDouble());
                        break;

                    case 5:
                        System.out.print("ID: ");
                        manager.deleteEmployee(sc.nextInt());
                        break;

                    case 6:
                        manager.displaySorted();
                        break;

                    case 7:
                        manager.displayDepartments();
                        break;

                    case 8:
                        return;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}