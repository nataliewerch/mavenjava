package homework230523.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTest {

    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1984, 5, 16);
        String myBirthday = getMyBirthDay(birthday);
        System.out.println("День моего рождения: " + myBirthday);
        System.out.println("Является ли дата: " + myBirthday + " пятницей? " + isFriday(birthday));
        System.out.println("Десять лет назад от " + myBirthday + " было " + subtractTenYearsFromBirthday(birthday));

    }

    public static String getMyBirthDay(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        return date.format(formatter);

    }

    public static boolean isFriday(LocalDate localDate) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
            return true;
        }return false;
    }

    public static String subtractTenYearsFromBirthday(LocalDate localDate) {
        LocalDate tenYearsAgo = localDate.minusYears(10);
        return getMyBirthDay(tenYearsAgo);
    }
}
