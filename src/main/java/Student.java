import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        Integer[] gradesArray = getGrades().toArray(new Integer[0]);

        for (int i = 0; i < gradesArray.length; i++) {
            sum += gradesArray[i];
        }

        return sum / gradesArray.length;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void changeCourse() {
        course++;
    }
}
