package homework130623.task1;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

public class GasStationApp {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4, true);
        LocalDateTime start = LocalDateTime.now();
        int minutesToWork = 10;
        LocalDateTime end = start.plusSeconds(minutesToWork);
        boolean[] freeGas = new boolean[4];
        String[] auto = {"BMW", "Audi", "WV", "Nissan", "Lada"};

        while (LocalDateTime.now().isBefore(end)){
            new Thread(new Auto(auto[(int) (Math.random()* auto.length)], semaphore, freeGas)).start();
            Thread.sleep(700);
        }

    }
}
