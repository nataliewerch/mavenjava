package homework230523.task3;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZoneDateTimeTest {

    public static void main(String[] args) {
        String str = "Pacific/Midway";
        ZoneId zoneId = ZoneId.of(str);
        ZonedDateTime dateTime = ZonedDateTime.now(zoneId);
        System.out.println(dateTime);
        System.out.println(dateTime.getZone());
        System.out.println(dateTime.toOffsetDateTime());
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getHour());
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d/MM/yyyy hh:mm:ss")));

    }
}
