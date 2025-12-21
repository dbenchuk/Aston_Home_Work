import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        students.add(new Student("Ivan Ivanov", "Mathematics", 1, Arrays.asList(1,2,5,3)));
        students.add(new Student("Petr Sokolov", "English", 1, Arrays.asList(4,5,6,3)));
        students.add(new Student("Denis Novikov", "Physics", 1, Arrays.asList(1,1,2,5)));
        students.add(new Student("Yana Strelcova", "Chemistry", 2, Arrays.asList(5,5,5,5)));

        StudentManagement.printStudents(students,1);

        StudentManagement.deleteStudent(students);

        StudentManagement.changeCourse(students);

        telephoneDirectory.add("Иванов", "+375447854126");
        telephoneDirectory.add("Иванов", "+375258541275");
        telephoneDirectory.add("Петров", "+375295843654");
        telephoneDirectory.add("Сидоров", "+375446593185");

        telephoneDirectory.get("Иванов");
        telephoneDirectory.get("Петров");
    }
}