package homework130623.task_lesson32;

import java.util.concurrent.Callable;

public class SumElement implements Callable<Integer> {

    private final int[] array;
    private final int start;
    private final int end;

    public SumElement(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum = sum + array[i];
        }
        System.out.println(Thread.currentThread().getName() + ": сумма элементов подмассива =  " + sum);
        return sum;
    }
}
