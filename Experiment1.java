import java.util.*;

class Employee {
    private int id;
    private String name, department;
    private double salary;

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }

    public void display() {
        System.out.printf("ID: %d | Name: %s | Dept: %s | Salary: %.2f%n", id, name, department, salary);
    }
}

public class EmployeeManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Enter max employees: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            System.out.println("\n1. Add Employee  2. Display Employees  3. Exit");
            switch (scanner.nextInt()) {
                case 1 -> addEmployee(max);
                case 2 -> employees.forEach(Employee::display);
                case 3 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addEmployee(int max) {
        if (employees.size() >= max) {
            System.out.println("Employee limit reached.");
            return;
        }
        System.out.print("ID: "); int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Dept: "); String dept = scanner.nextLine();
        System.out.print("Salary: "); double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, dept, salary));
        System.out.println("Employee added!");
    }
}
