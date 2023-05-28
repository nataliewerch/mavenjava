package homework230523.task1;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TripService {
    Scanner scanner = new Scanner(System.in);

    public List<Trip> getSortedTrips(List<Trip> trips) {
        return trips.stream()
                .sorted(Comparator.comparingDouble(Trip::getPrice))
                .collect(Collectors.toList());
    }

    public List<Trip> getDescSortTrips(List<Trip> trips) {
        return trips.stream()
                .sorted(Comparator.comparingDouble(Trip::getPrice).reversed())
                .collect(Collectors.toList());
    }

    public List<Trip> getPriceRange(List<Trip> trips, double minPrice, double maxPrice) {
        return trips.stream()
                .filter(trip -> trip.getPrice() >= minPrice && trip.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<Trip> getStartCity(List<Trip> trips, String startCity) {
        return trips.stream()
                .filter(s -> startCity.equals(s.getSource()))
                .collect(Collectors.toList());
    }

    public List<Trip> getFinishCity(List<Trip> trips, String finishCity) {
        return trips.stream()
                .filter(s -> finishCity.equals(s.getDestination()))
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsInRange(List<Trip> trips, LocalDate startDate, LocalDate endDate) {
        return trips.stream()
                .filter(trip -> trip.getStartDate().isAfter(startDate) && trip.getReturnDate().isBefore(endDate))
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsByStartDateAndRadius(List<Trip> trips, LocalDate startDate, int radius) {
        return trips.stream()
                .filter(trip -> trip.getStartDate().isAfter(startDate.minusDays(radius)) && trip.getStartDate().isBefore(startDate.plusDays(radius)))
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsByReturnDateAndRadius(List<Trip> trips, LocalDate returnDate, int radius) {
        return trips.stream()
                .filter(trip -> trip.getReturnDate().isAfter(returnDate.minusDays(radius)) && trip.getStartDate().isBefore(returnDate.plusDays(radius)))
                .collect(Collectors.toList());
    }

    public void printBriefInformation(List<Trip> trips) {
        long count = trips.stream().count();
        double minPrice = trips.stream()
                .mapToDouble(Trip::getPrice)
                .min()
                .orElse(0);
        double maxPrice = trips.stream()
                .mapToDouble(Trip::getPrice)
                .max()
                .orElse(0);
        List<String> startCity = trips.stream()
                .map(Trip::getSource)
                .distinct()
                .collect(Collectors.toList());
        List<String> finishCity = trips.stream()
                .map(Trip::getDestination)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Количество доступных поездок: " + count);
        System.out.println("Цены в диапозоне от " + minPrice + " до " + maxPrice + " Евро");
        System.out.println("Список городов отправления: " + startCity);
        System.out.println("Список городов назаначения: " + finishCity);
    }

    public void tripService(List<Trip> trips) {
        String option = scanner.nextLine();

        switch (option.toUpperCase()) {
            case "A" -> printAllTrips(trips);
            case "B" -> printSortedTrips(trips);
            case "C" -> printDescSortTrips(trips);
            case "D" -> printPriceRange(trips);
            case "E" -> printStartCity(trips);
            case "F" -> printFinishCity(trips);
            case "G" -> printBriefInformation(trips);
            case "H" -> printTripsInRange(trips);
            case "I" -> printTripsByStartDateAndRadius(trips);
            case "J" -> printTripsByReturnDateAndRadius(trips);
            default -> System.out.println("Заданной опции не существует!!! Попробуйте еще раз!");
        }
    }

    private void printAllTrips(List<Trip> trips) {
        trips.forEach(System.out::println);
    }

    private void printSortedTrips(List<Trip> trips) {
        List<Trip> sortedTrips = getSortedTrips(trips);
        sortedTrips.forEach(System.out::println);
    }

    private void printDescSortTrips(List<Trip> trips) {
        List<Trip> sortedTrips = getDescSortTrips(trips);
        sortedTrips.forEach(System.out::println);
    }

    private void printPriceRange(List<Trip> trips) {
        System.out.println("Введите минимальную цену ");
        double minPrice = scanner.nextDouble();
        System.out.println("Введите максимальную цену ");
        double maxPrice = scanner.nextDouble();
        List<Trip> tripsRange = getPriceRange(trips, minPrice, maxPrice);
        tripsRange.forEach(System.out::println);
    }

    private void printStartCity(List<Trip> trips) {
        List<String> collect = trips.stream()
                .map(Trip::getSource)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Выберети город отправления: " + collect);
        String startCity = scanner.nextLine();
        List<Trip> startCityTrips = getStartCity(trips, startCity);
        startCityTrips.forEach(System.out::println);
    }

    private void printFinishCity(List<Trip> trips) {
        List<String> collect = trips.stream()
                .map(Trip::getDestination)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Выберети город назначения: " + collect);
        String finishCity = scanner.nextLine();
        List<Trip> finishCityTrips = getFinishCity(trips, finishCity);
        finishCityTrips.forEach(System.out::println);
    }

    private void printTripsInRange(List<Trip> trips) {
        System.out.println("Введите начальную дату в формате ГГГГ-ММ-ДД: ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Введите конечную дату в формате ГГГГ-ММ-ДД ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
        List<Trip> tripsInRange = getTripsInRange(trips, startDate, endDate);
        tripsInRange.forEach(System.out::println);
    }

    private void printTripsByStartDateAndRadius(List<Trip> trips) {
        System.out.println("Введите дату начала поездки в формате ГГГГ-ММ-ДД ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите диапозон дней начала поезки ");
        int radius = scanner.nextInt();
        List<Trip> tripList = getTripsByStartDateAndRadius(trips, startDate, radius);
        tripList.forEach(System.out::println);
    }

    private void printTripsByReturnDateAndRadius(List<Trip> trips) {
        System.out.println("Введите дату окончания поездки в формате ГГГГ-ММ-ДД");
        LocalDate returnDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите диапозон дней для даты окончания поезки");
        int radius = scanner.nextInt();
        List<Trip> tripList = getTripsByReturnDateAndRadius(trips, returnDate, radius);
        tripList.forEach(System.out::println);
    }
}


