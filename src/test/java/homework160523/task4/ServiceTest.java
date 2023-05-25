package homework160523.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    Service service = new Service();

    @BeforeEach
    void init() {
        service.addStudents("Ivan", 20, Degree.BACHELOR);
        service.addStudents("Anton", 23, Degree.MAGISTRACY);
        service.addStudents("Anna", 18, Degree.BACHELOR);
        service.addStudents("Inna", 25, Degree.MAGISTRACY);
    }

    @Test
    void addStudents() {
        List<Student> students = service.getStudents();
        Student addedStudent = students.get(0);
        Assertions.assertEquals(1, addedStudent.getId());
        Assertions.assertEquals("Ivan", addedStudent.getName());
        Assertions.assertEquals(20, addedStudent.getAge());
        Assertions.assertEquals(Degree.BACHELOR, addedStudent.getDegree());
    }

    @Test
    void getStudents() {
        List<Student> students = service.getStudents();
        Assertions.assertEquals(4, students.size());
    }

    @Test
    void getAllStudents() {
        List<Student> students = service.getAllStudents();
        Assertions.assertEquals(4, students.size());
    }

    @Test
    void getAllStudentsByDegree() {
        List<Student> bachelorStudents = service.getAllStudents(Degree.BACHELOR);
        Assertions.assertEquals(2, bachelorStudents.size());
    }

    @Test
    void getAverageAge() {
        double averageAge = service.getAverageAge();
        Assertions.assertEquals(21.5, averageAge);
    }

    @Test
    void getSumAge() {
        double sumAge = service.getSumAge();
        Assertions.assertEquals(86, sumAge);
    }

    @Test
    void getSumAgeByDegree() {
        double sumAge = service.getSumAge(Degree.BACHELOR);
        Assertions.assertEquals(38, sumAge);
    }
}