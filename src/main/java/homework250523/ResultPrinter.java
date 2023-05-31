package homework250523;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ResultPrinter implements Runnable{
    @Override
    public void run() {
        while (HorseRaceApp.resultMap.size() < 10) {
           try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Результаты забега: ");

        HorseRaceApp.resultMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(p -> {
                    String horseName = p.getKey();
                    long finishTime = p.getValue();
                    String formattedTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss SSS").format(new Date(finishTime));
                    System.out.println("Имя: " + horseName + ", Время финиша: " + formattedTime);
                });
    }
}
