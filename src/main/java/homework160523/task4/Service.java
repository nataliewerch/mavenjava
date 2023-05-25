package homework160523.task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {

    private Map<Integer, Student> allStudents;
    private int countId;

    public Service() {
        allStudents = new HashMap<>();
        countId = 0;
    }

    public void addStudents(String name, int age, Degree degree) {
        int id = ++countId;
        Student student = new Student(id, name, age, degree);
        allStudents.put(id, student);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(allStudents.values());
    }


    public List<Student> getAllStudents() {
        List<Student> allStudents = getStudents();
        System.out.println("Все студенты:");
        allStudents.forEach(student ->
                System.out.println("ID: " + student.getId() + ", Имя: " + student.getName() +
                        ", Возраст: " + student.getAge() + ", Учебная степень: " + student.getDegree())
        );
        return allStudents;
    }

    public List<Student> getAllStudents(Degree degree) {
        List<Student> allStudents = getStudents();
        System.out.println("Все сеуденты ученой степени: " + degree);
        allStudents = getStudents().stream()
                .filter(student -> student.getDegree() == degree)
                .collect(Collectors.toList());
        allStudents.forEach(student ->
                System.out.println("ID: " + student.getId() + ", Имя: " + student.getName() +
                        ", Возраст: " + student.getAge() + ", Учебная степень: " + student.getDegree())
        );
        return allStudents;
    }

    public double getAverageAge() {
        return getStudents().stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }

    public double getSumAge() {
        return getStudents().stream()
                .mapToInt(Student::getAge)
                .sum();
    }

    public double getSumAge(Degree degree) {
        return getStudents().stream()
                .filter(student1 -> student1.getDegree() == degree)
                .mapToInt(Student::getAge)
                .sum();
    }
}
