package homework250523;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    private Horse horse = new Horse("Horse 1");

    @Test
    void getName() {
        String expectedName = "Horse 1";
        Assertions.assertEquals(expectedName, horse.getName());
    }

    @Test
    void getStep() {
        Assertions.assertTrue(horse.getStep() >= 0 && horse.getStep() <= 2);
    }

    @Test
    void run() {
        horse.run();
        Assertions.assertTrue(HorseRaceApp.resultMap.get(horse.getName()) >= 0 && HorseRaceApp.resultMap.containsKey(horse.getName()));
    }
}