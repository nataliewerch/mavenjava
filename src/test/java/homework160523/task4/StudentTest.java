package homework160523.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Service service = new Service();

    @BeforeEach
    void init() {
        service.addStudents("Ivan", 20, Degree.BACHELOR);
        service.addStudents("Anton", 23, Degree.MAGISTRACY);
        service.addStudents("Anna", 18, Degree.BACHELOR);
        service.addStudents("Inna", 25, Degree.MAGISTRACY);
    }

    @Test
    void getId() {
        Student student = service.getStudents().get(0);
        Assertions.assertEquals(1, student.getId());
    }

    @Test
    void getName() {
        Student student = service.getStudents().get(3);
        Assertions.assertEquals("Inna", student.getName());
    }

    @Test
    void getAge() {
        Student student = service.getStudents().get(1);
        Assertions.assertEquals(23, student.getAge());
    }

    @Test
    void getDegree() {
        Student student = service.getStudents().get(2);
        Assertions.assertEquals(Degree.BACHELOR, student.getDegree());
    }

    @Test
    void testToString() {
        Student student = service.getStudents().get(2);
        String expected = "Student{" +
                "id=" + student.getId() +
                ", name='" + student.getName() + '\'' +
                ", age=" + student.getAge() +
                ", degree=" + student.getDegree() +
                '}';
        Assertions.assertEquals(expected, student.toString());
    }
}