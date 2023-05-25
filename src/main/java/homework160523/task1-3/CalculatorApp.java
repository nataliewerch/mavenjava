package homework160523.task1;

import java.util.Arrays;

public class CalculatorApp {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] arrFirst = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] arrSecond = {1, 0, 6, 15, 6, 4, 7, 0};
        int[] arrDistinct = {0,3,-2,4,3,2};

        System.out.println(Calculator.findMax(arr));
        System.out.println(Calculator.findMin(arr));
        System.out.println(Arrays.toString(Calculator.findIdenticalElements(arrFirst, arrSecond)));
        System.out.println(Arrays.toString(Calculator.removeDuplicateElements(arrDistinct)));

    }
}
