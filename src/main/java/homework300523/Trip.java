package homework300523;

import java.time.LocalDate;

public class Trip {
    private String source;
    private String destination;
    private int hours;
    private double price;
    private LocalDate startDate;
    private LocalDate returnDate;

    public Trip(String source, String destination, int hours, double price, LocalDate startDate, LocalDate returnDate) {
        this.source = source;
        this.destination = destination;
        this.hours = hours;
        this.price = price;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getHours() {
        return hours;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "" + source + " - " + destination +
                "; время в пути: " + hours + " ч." +
                "; цена: " + price + " Евро" +
                "; дата отправления: " + startDate +
                "; дата возвращения: " + returnDate;
    }

}



