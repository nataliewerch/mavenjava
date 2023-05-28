package homework230523.task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TripService tripService = new TripService();
        List<Trip> trips = new ArrayList<>();
        trips.add(new Trip("Berlin", "München", 7, 250,
                LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 23)));
        trips.add(new Trip("Berlin", "Kassel", 5, 150,
                LocalDate.of(2023, 8, 16), LocalDate.of(2023, 9, 13)));
        trips.add(new Trip("Berwang", "Hamburg", 10, 350,
                LocalDate.of(2023, 6, 15), LocalDate.of(2023, 6, 28)));
        trips.add(new Trip("Bonn", "Warburg", 4, 100,
                LocalDate.of(2023, 5, 5), LocalDate.of(2023, 6, 23)));

        System.out.println("Выберете опцию из предложенных ниже: ");
        System.out.println("A - список доступных поездок.");
        System.out.println("B - список доступных поездок отсортированных по цене по возрастанию");
        System.out.println("C - список доступных поездок отсортированных по цене по убыванию.");
        System.out.println("D - список поездок со стоимостью в заданном диапазоне цен.");
        System.out.println("E - список поездок из заданного города отправления.");
        System.out.println("F - список поездок в заданный город прибытия.");
        System.out.println("G - краткая информация о доступных поездках.");
        System.out.println("H - список доступных поездок в заданном диапозоне дат.");
        System.out.println("I - список начала поездок с указанным диапозоном.");
        System.out.println("J - список окончания поездок с указанным диапозоном.");

        tripService.tripService(trips);
    }
}
