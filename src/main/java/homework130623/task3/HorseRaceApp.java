package homework130623.task3;

import java.util.Map;
import java.util.concurrent.*;

public class HorseRaceApp {
    public static Map<String, Long> resultMap = new ConcurrentHashMap<>();
    public static final int NUMBERS_OF_PARTICIPANT = 10;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < NUMBERS_OF_PARTICIPANT; i++) {
            executorService.execute(new Horse("Horse " + (i + 1)));
        }

        Future<String> future = executorService.submit(new ResultPrinter());
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();
    }
}
