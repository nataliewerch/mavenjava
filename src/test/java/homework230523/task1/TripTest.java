package homework230523.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripTest {
    private Trip trip;

    @BeforeEach
    void  init() {
        trip = new Trip("Berlin", "München", 7, 250, LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 23));
    }

    @Test
    void getSource() {
        Assertions.assertEquals("Berlin", trip.getSource() );
    }

    @Test
    void getDestination() {
        Assertions.assertEquals("München", trip.getDestination());
    }

    @Test
    void getHours() {
        Assertions.assertEquals(7, trip.getHours());

    }

    @Test
    void getPrice() {
        Assertions.assertEquals(250, trip.getPrice());

    }

    @Test
    void getStartDate() {
        Assertions.assertEquals(LocalDate.of(2023, 5, 15), trip.getStartDate());
    }

    @Test
    void getReturnDate() {
        Assertions.assertEquals(LocalDate.of(2023, 5, 23), trip.getReturnDate());

    }
}