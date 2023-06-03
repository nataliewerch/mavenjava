package homework300523;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TripApp {
    public static void main(String[] args) {
        TripService tripService = new TripService();
        List<Trip> trips = Arrays.asList(
                new Trip("Berlin", "München", 7, 250,
                        LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 23)),
                new Trip("Berlin", "Kassel", 5, 150,
                        LocalDate.of(2023, 8, 16), LocalDate.of(2023, 9, 13)),
                new Trip("Berwang", "Hamburg", 10, 350,
                        LocalDate.of(2023, 6, 15), LocalDate.of(2023, 6, 28)),
                new Trip("Bonn", "Warburg", 4, 100,
                        LocalDate.of(2023, 5, 5), LocalDate.of(2023, 6, 23)));


        tripService.tripService(trips);
    }
}
