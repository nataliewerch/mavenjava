package homework160523.task1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


public class Calculator {

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть null или пустым");
        }
        return Arrays.stream(arr).max().getAsInt();
    }

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть null или пустым");
        }
        return Arrays.stream(arr).min().getAsInt();
    }

    public static int[] findIdenticalElements(int[] arrFirst, int[] arrSecond) {
        if (arrFirst == null || arrSecond == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        Set<Integer> arrFirstDistinct = Arrays.stream(arrFirst).boxed().collect(Collectors.toSet());
        return Arrays.stream(arrSecond)
                .distinct()
                .filter(arrFirstDistinct :: contains)
                .toArray();
    }

    public static int[] removeDuplicateElements(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        return Arrays.stream(arr).distinct().toArray();
    }

}
