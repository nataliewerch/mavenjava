package homework160523.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DegreeTest {

    @Test
    void values() {
        Degree[] degrees = Degree.values();
        Assertions.assertNotNull(degrees);
        Assertions.assertEquals(2, degrees.length);
    }

    @Test
    void valueOf() {
        Degree magistracy = Degree.valueOf(String.valueOf(Degree.MAGISTRACY));
        Degree bachelor = Degree.valueOf(String.valueOf(Degree.BACHELOR));
        Assertions.assertEquals(Degree.MAGISTRACY, magistracy);
        Assertions.assertEquals(Degree.BACHELOR, bachelor);
    }
}