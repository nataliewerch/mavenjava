package homework010623;

import java.util.List;

public class EventApp {

    public static void main(String[] args) throws InterruptedException {
        EventCreator creator = new EventCreator();
        creator.startSimulation();
        creator.stopSimulation();

        List<Event> eventList = creator.getEventList();
        FirewallEventListener listener = new FirewallEventListener(eventList);
        listener.startProcessing();
    }
}