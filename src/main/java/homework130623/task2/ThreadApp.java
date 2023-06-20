package homework130623.task2;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ThreadApp implements Runnable {

    private final int number;
    private final Exchanger<String> exchanger;

    public ThreadApp(int number, Exchanger<String> exchanger) {
        this.number = number;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            String before = "Thread - " + number;
            Thread.sleep(random.nextInt(3) * 1000L);
            String after = exchanger.exchange(before);
            Thread.sleep(random.nextInt(3) * 1000L);
            System.out.println("До обмена: " + before + " ------> После обмена: " + after);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
