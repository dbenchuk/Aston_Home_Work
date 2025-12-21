import java.util.Iterator;
import java.util.Set;

public class StudentManagement {
    public static void deleteStudent(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    public static void changeCourse(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            if (student.getAverageGrade() >= 3) {
                student.changeCourse();
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            if (student.getCourse() == course) {
                System.out.println("Name: " + student.getName() + "  Course: " + student.getCourse());
            }
        }
    }
}