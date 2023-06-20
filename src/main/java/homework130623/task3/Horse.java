package homework130623.task3;

public class Horse implements Runnable {
    private final String name;
    private final double step;

    public Horse(String name) {
        this.name = name;
        this.step = Math.random() * 2;
    }

    @Override
    public void run() {
        double distance = 0;
        while (distance < 1000) {
            distance += step;
        }
        HorseRaceApp.resultMap.put(name, System.currentTimeMillis());
    }
}


