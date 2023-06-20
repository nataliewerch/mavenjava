package homework130623.task_lesson32;

import java.util.concurrent.*;

public class SumElementApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int numOfTread = 3;
        int sum = Calculator.calculateSumOfArrayElement(array, numOfTread);
        System.out.println("Сумма всех элементов массива = " + sum);


        // Предыдущий примитивный код, но короткий

     /*   ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> futureOne = executorService.submit(new SumElement(array, 0,5));
        Future<Integer> futureTwo = executorService.submit(new SumElement(array, 5,10));
        Future<Integer> futureThree = executorService.submit(new SumElement(array, 10,15));

        int result = futureOne.get() + futureTwo.get() + futureThree.get();
        System.out.println(result);
        executorService.shutdown();*/
    }
}
