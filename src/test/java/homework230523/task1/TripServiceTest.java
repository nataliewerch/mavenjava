package homework230523.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripServiceTest {
    private TripService tripService;
    private List<Trip> trips;


    @BeforeEach
    void init() {
        tripService = new TripService();
        trips = new ArrayList<>();
        trips.add(new Trip("Berlin", "München", 7, 250,
                LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 23)));
        trips.add(new Trip("Berlin", "Kassel", 5, 150,
                LocalDate.of(2023, 8, 16), LocalDate.of(2023, 9, 13)));
        trips.add(new Trip("Berwang", "Hamburg", 10, 350,
                LocalDate.of(2023, 6, 15), LocalDate.of(2023, 6, 28)));
        trips.add(new Trip("Bonn", "Warburg", 4, 100,
                LocalDate.of(2023, 5, 5), LocalDate.of(2023, 6, 23)));
    }

    @Test
    void getPriceRange() {
        double minPrice = 100;
        double maxPrice = 350;
        List<Trip> tripList = tripService.getPriceRange(trips, minPrice, maxPrice);
        for (Trip trip : tripList) {
            double price = trip.getPrice();
            Assertions.assertTrue(price >= minPrice && price <= maxPrice);
        }
    }

    @Test
    void getStartCity() {
        String startCity = "Bonn";
        List<Trip> tripList = tripService.getStartCity(trips, startCity);
        for (Trip trip : tripList) {
            Assertions.assertEquals(startCity, trip.getSource());
        }
    }

    @Test
    void getFinishCity() {
        String finishCity = "Warburg";
        List<Trip> tripList = tripService.getStartCity(trips, finishCity);
        for (Trip trip : tripList) {
            Assertions.assertEquals(finishCity, trip.getDestination());
        }
    }
}