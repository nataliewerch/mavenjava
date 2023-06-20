package homework130623.task1;

import java.util.concurrent.Semaphore;

public class Auto implements Runnable {

    private final String model;
    private final Semaphore semaphore;
    private final boolean[] freeGas;

    public Auto(String model, Semaphore semaphore, boolean[] freeGas) {
        this.model = model;
        this.semaphore = semaphore;
        this.freeGas = freeGas;
    }

    @Override
    public void run() {
        System.out.println("-> " + model + " подъехал к заправочной станции ");
        try {
            semaphore.acquire();
            int temp = -1;
            synchronized (freeGas) {
                for (int i = 0; i < freeGas.length; i++) {
                    if (!freeGas[i]) {
                        freeGas[i] = true;
                        System.out.println("" + model + " заправляется на колонке номер " + (i + 1));
                        temp = i;
                        System.out.println();
                        break;
                    }
                }
            }

            Thread.sleep(5000);

            synchronized (freeGas) {
                freeGas[temp] = false;
            }

            semaphore.release();
            synchronized (freeGas) {
                System.out.println("<- " + model + " закончил заправляться и уехал");
                System.out.println("Запрвочная колонка номер " + (temp + 1) + " освободилась");
                System.out.println();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
