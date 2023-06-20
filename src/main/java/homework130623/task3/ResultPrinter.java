package homework130623.task3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class ResultPrinter implements Callable<String> {

    @Override
    public String call() throws Exception {
        while (HorseRaceApp.resultMap.size() < 10) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return HorseRaceApp.resultMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(p -> {
                    String horseName = p.getKey();
                    long finishTime = p.getValue();
                    String formattedTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss SSS").format(new Date(finishTime));
                    return "Имя: " + horseName + ", Время финиша: " + formattedTime;
                })
                .collect(Collectors.joining("\n"));
    }
}


