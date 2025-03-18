import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + salary + ")";
    }
}

public class Exp6Easy {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));
        employees.add(new Employee("Alex", 28, 45000));
        employees.add(new Employee("David", 29, 50000));
        employees.add(new Employee("Eve", 31, 50000));
        employees.add(new Employee("Frank", 27, 50000));

        System.out.println("Before Sorting:");
        employees.forEach(System.out::println);

        System.out.println("\nSorted by Name:");
        employees.sort(Comparator.comparing(emp -> emp.name));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by Age:");
        employees.sort(Comparator.comparingInt(emp -> emp.age));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by Salary (Descending):");
        employees.sort((emp1, emp2) -> Double.compare(emp2.salary, emp1.salary));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by Age for Same Name (Alex):");
        employees.stream()
                 .filter(emp -> emp.name.equals("Alex"))
                 .sorted(Comparator.comparingInt(emp -> emp.age))
                 .forEach(System.out::println);

        System.out.println("\nSorted by Name for Same Salary:");
        employees.stream()
                 .filter(emp -> emp.salary == 50000)
                 .sorted(Comparator.comparing(emp -> emp.name))
                 .forEach(System.out::println);
    }
}
