package homework130623.task_lesson32;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calculator {

    /*
     Я бы еще этот метод разделила на пару методов, но не знаю целесообразно ли это?
     */

    public static int calculateSumOfArrayElement(int[] array, int numOfThread) {
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThread);
        Future<Integer>[] results = new Future[numOfThread];
        int size = array.length / numOfThread;
        int remains = array.length % numOfThread;
        int startIndex = 0;
        int endIndex = size;
        for (int i = 0; i < numOfThread; i++) {
            if (i == numOfThread - 1) {
                endIndex = endIndex + remains;
            }
            SumElement sumElement = new SumElement(array, startIndex, endIndex);
            results[i] = executorService.submit(sumElement);
            startIndex = endIndex;
            endIndex = endIndex + size;
        }
        int totalSum = 0;
        for (int i = 0; i < numOfThread; i++) {
            try {
                totalSum = totalSum + results[i].get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        return totalSum;
    }
}

