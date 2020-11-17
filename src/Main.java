import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Evolyb", 19));
        students.add(new Student(2, "Kaka", 34));
        students.add(new Student(3, "Enoy", 14));

        // Filter
        List<Student> result = students.stream()
                .filter(student -> student.getName().contains("E"))
                .collect(Collectors.toList());
        // Sort
        List<Student> sorted = students.stream()
                .sorted(Comparator.comparing(Student::getName)
                        .thenComparing(Student::getId).reversed())
                .collect(Collectors.toList());
        // All match
        boolean allMatch = students.stream()
                .allMatch(student -> student.getAge() > 18);
        // Any match
        boolean anyMatch = students.stream()
                .anyMatch(student -> student.getAge() > 40);
        // None match
        boolean noneMatch = students.stream()
                .noneMatch(student -> student.getName().equals("Evolyb"));
        // Max
        Optional<Student> student = students.stream()
                .max(Comparator.comparing(Student::getAge));
        // Group
        Map<String, List<Student>> groupByGender = students.stream()
                .collect(Collectors.groupingBy(Student::getName));

        Optional<String> oldestStudent = students.stream()
                .filter(student1 -> student1.getName().contains("E"))
                .max(Comparator.comparing(Student::getAge))
                .map(Student::getName);

        oldestStudent.ifPresent(System.out::println); // Evolyb
    }

}
