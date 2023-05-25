package homework160523.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    int[] arr = {1, 5, 3, 9, 2};

    @Test
    void testFindMax() {
        int max = homework160523.task1.Calculator.findMax(arr);
        Assertions.assertEquals(9, max);
    }

    @Test
    void testFindMin() {
        int min = homework160523.task1.Calculator.findMin(arr);
        Assertions.assertEquals(1, min);
    }

    @Test
    void testFindMaxAndMinIfArrIsEmpty() {
        int[] emptyArr = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            homework160523.task1.Calculator.findMax(emptyArr);
        });
    }

    @Test
    void testFindMaxIfNullArr() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            homework160523.task1.Calculator.findMax(null);
        });
    }

    @Test
    void testFindMinIfNullArr() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            homework160523.task1.Calculator.findMin(null);
        });
    }


    @Test
    public void testFindIdenticalElements() {
        int[] arrFirst = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] arrSecond = {1, 0, 6, 15, 6, 4, 7, 0};
        int[] expected = {1, 7};
        Assertions.assertArrayEquals(expected, homework160523.task1.Calculator.findIdenticalElements(arrFirst, arrSecond));
    }

    @Test
    public void testFindIdenticalElementsIfNullArr() {
        int[] arrFirst = {1, 2, 5, 5, 8, 9, 7, 10};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            homework160523.task1.Calculator.findIdenticalElements(arrFirst, null);
        });
    }

    @Test
    public void testFindIdenticalElementsIfNullTwoArr() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            homework160523.task1.Calculator.findIdenticalElements(null, null);
        });
    }

    @Test
    public void testRemoveDuplicateElements() {
        int[] arr = {0, 3, -2, 4, 3, 2};
        int[] expected = {0, 3, -2, 4, 2};
        Assertions.assertArrayEquals(expected, homework160523.task1.Calculator.removeDuplicateElements(arr));
    }

    @Test
    void testRemoveDuplicateIfNullArr() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            homework160523.task1.Calculator.removeDuplicateElements(null);
        });
    }
}



