package homework010623;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    private final int eventId;
    private String userName;
    private String userIp;
    private LocalDateTime eventDate;
    private EventState eventState;
    private static AtomicInteger nextEventId = new AtomicInteger(1);

    public Event(String userName, String userIp, LocalDateTime eventDate, EventState eventState) {
        this.eventId = getNextEventId();
        this.userName = userName;
        this.userIp = userIp;
        this.eventDate = eventDate;
        this.eventState = eventState;
    }

    public int getEventId() {
        return eventId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public EventState getEventState() {
        return eventState;
    }

    private static int getNextEventId() {
            return nextEventId.getAndIncrement();

    }
}
