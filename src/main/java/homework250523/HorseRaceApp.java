package homework250523;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HorseRaceApp {
    public static Map<String, Long> resultMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Horse[] horses = new Horse[10];
        Thread[] threads = new Thread[horses.length];

        for (int i = 0; i < horses.length; i++) {
            horses[i] = new Horse("Horse " + (i + 1));
            threads[i] = new Thread(horses[i]);
            threads[i].start();
        }

        Thread result = new Thread(new ResultPrinter());
        result.start();
        try {
            result.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
