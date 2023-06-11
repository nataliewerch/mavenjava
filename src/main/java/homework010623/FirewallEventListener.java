package homework010623;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FirewallEventListener {

    private List<Event> eventList;
    private Thread[] threads;
    private List<String> logList;
    private AtomicInteger eventsProcessed;


    public FirewallEventListener(List<Event> eventList) {
        this.eventList = eventList;
        this.threads = new Thread[4];
        this.logList = new ArrayList<>();
        this.eventsProcessed = new AtomicInteger(0);
    }

    public void startProcessing() {
        for (int i = 0; i < threads.length; i++) {
            int handlerId = i + 1;
            threads[i] = new Thread(() -> processEvents(handlerId));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread logThread = new Thread(() -> {
            synchronized (logList) {
                System.out.println("Log List:");
                for (String log : logList) {
                    System.out.println(log);
                }
            }
        });
        logThread.start();
    }

    private void processEvents(int handlerId) {
        while (true) {
            int eventIndex = eventsProcessed.getAndIncrement();
            if (eventIndex >= eventList.size()) {
                break;
            }

            Event event = eventList.get(eventIndex);
            String handlerName = "Handler-" + handlerId;

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String log1 = "Обработчик " + handlerName + " event ID: " + event.getEventId() + event.getUserName();
            String log2 = "Обработчик " + handlerName + " event ID: " + event.getEventId() + event.getUserIp();
            String log3 = "Обработчик " + handlerName + " event ID: " + event.getEventId() + " " + event.getEventDate();
            String log4 = "Обработчик " + handlerName + " event ID: " + event.getEventId() + " " + event.getEventState();

            synchronized (logList) {
                logList.add(log1);
                logList.add(log2);
                logList.add(log3);
                logList.add(log4);
            }
        }
    }
}

