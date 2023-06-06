package homework010623;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventCreator {
    private static final int NUM_USERS = 10;
    private List<Event> eventList;
    private Thread[] threads;
    private AtomicBoolean stopSignal;


    public EventCreator() {
        eventList = new ArrayList<>();
        threads = new Thread[NUM_USERS];
        stopSignal = new AtomicBoolean(false);
    }

    public void startSimulation() {
        for (int i = 0; i < NUM_USERS; i++) {
            int userId = i + 1;
            threads[i] = new Thread(() -> simulateUserWork(userId));
            threads[i].start();
        }
    }

    public void stopSimulation() {
        stopSignal.set(true);

        for (Thread userThread : threads) {
            try {
                userThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void simulateUserWork(int userId) {
        Random random = new Random();

        while (!stopSignal.get()) {
            String userName = " User " + userId;
            String userIp = " 178.63.0." + userId;
            LocalDateTime eventDate = LocalDateTime.now();
            EventState eventState = getRandomEventState(random);

            Event event = new Event(userName, userIp, eventDate, eventState);
            eventList.add(event);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private EventState getRandomEventState(Random random) {
        int index = random.nextInt(EventState.values().length);
        return EventState.values()[index];
    }

    public List<Event> getEventList() {
        synchronized (eventList) {
            return eventList;
        }
    }
}