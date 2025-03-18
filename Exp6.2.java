import java.util.*;
import java.util.stream.Collectors;
class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println(name);
    }
}


public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 80),
            new Student("Bob", 72),
            new Student("Charlie", 90),
            new Student("David", 65),
            new Student("Eve", 85)
        );

        System.out.println("Filtered and Sorted Students:");

        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> s2.marks != s1.marks ? Double.compare(s2.marks, s1.marks) : s1.name.compareTo(s2.name))
                .forEach(Student::display);
    }
}
