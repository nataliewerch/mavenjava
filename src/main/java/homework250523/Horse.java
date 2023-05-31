package homework250523;

public class Horse implements Runnable {
    private String name;
    private double step;

    public Horse(String name) {
        this.name = name;
        this.step = Math.random() * 2;
    }

    public String getName() {
        return name;
    }

    public double getStep() {
        return step;
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
