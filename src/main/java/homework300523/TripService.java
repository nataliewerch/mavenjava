package homework300523;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TripService {
    Scanner scanner = new Scanner(System.in);
    private Logger logger = new Logger();

    public List<Trip> getSortedTripsByPriceAsc(List<Trip> trips) {
        return trips.stream()
                .sorted(Comparator.comparingDouble(Trip::getPrice))
                .collect(Collectors.toList());
    }

    public List<Trip> getDescSortTripsByPriceDesc(List<Trip> trips) {
        return trips.stream()
                .sorted(Comparator.comparingDouble(Trip::getPrice).reversed())
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsInPriceRange(List<Trip> trips, double minPrice, double maxPrice) {
        return trips.stream()
                .filter(trip -> trip.getPrice() >= minPrice && trip.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsFilteredByStartCity(List<Trip> trips, String startCity) {
        return trips.stream()
                .filter(s -> startCity.equals(s.getSource()))
                .collect(Collectors.toList());
    }

    public List<Trip> getFilteredByFinishCity(List<Trip> trips, String finishCity) {
        return trips.stream()
                .filter(s -> finishCity.equals(s.getDestination()))
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsInDatesRange(List<Trip> trips, LocalDate startDate, LocalDate endDate) {
        return trips.stream()
                .filter(trip -> trip.getStartDate().isAfter(startDate) && trip.getReturnDate().isBefore(endDate))
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsFilteredByStartDateAndDateRadius(List<Trip> trips, LocalDate startDate, int radius) {
        return trips.stream()
                .filter(trip -> trip.getStartDate().isAfter(startDate.minusDays(radius)) && trip.getStartDate().isBefore(startDate.plusDays(radius)))
                .collect(Collectors.toList());
    }

    public List<Trip> getTripsFilteredByReturnDateAndDateRadius(List<Trip> trips, LocalDate returnDate, int radius) {
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

        logger.writeToTheLog("\n    Выбрана опция: G - краткая информация о доступных поездках. \n    Ваш результат: \n    " + "Количество доступных поездок: " + count + "\n" +
                "    Цены в диапозоне от " + minPrice + " до " + maxPrice + " Евро\n" + "    Список городов отправления: " + startCity + "\n" + "    Список городов назаначения: " + finishCity + "\n");

        System.out.println("Количество доступных поездок: " + count);
        System.out.println("Цены в диапозоне от " + minPrice + " до " + maxPrice + " Евро");
        System.out.println("Список городов отправления: " + startCity);
        System.out.println("Список городов назаначения: " + finishCity);
    }

    public void tripService(List<Trip> trips) {
        printOptionsInfo();
        String option = scanner.nextLine();
        while (!option.equalsIgnoreCase("Q")) {
            switch (option.toUpperCase()) {
                case "A" -> printAndWriteToTheLogAllTrips(trips);
                case "B" -> printAndWriteToTheLogSortedTripsByPriceAsc(trips);
                case "C" -> printAndWriteToTheLogDescSortTripsByPriceDesc(trips);
                case "D" -> printAndWriteToTheLogTripsInPriceRange(trips);
                case "E" -> printAndWriteToTheLogTripsFilteredByStartCity(trips);
                case "F" -> printAndWriteToTheLogFilteredByFinishCity(trips);
                case "G" -> printBriefInformation(trips);
                case "H" -> printAndWriteToTheLogTripsInDatesRange(trips);
                case "I" -> printAndWriteToTheLogTripsFilteredByStartDateAndDateRadius(trips);
                case "J" -> printAndWriteToTheLogTripsFilteredByReturnDateAndDateRadius(trips);
                default -> {
                    System.out.println("Заданной опции не существует!!! Попробуйте еще раз!");
                    logger.writeToTheLog("\n     Выбрана несуществующая опция!!!");
                }
            }
            printOptionsInfo();
            option = scanner.nextLine();
        }
        scanner.close();
    }

    private void printAndWriteToTheLogAllTrips(List<Trip> trips) {
        logger.writeToTheLog("\n    Выбрана опция: A - список доступных поездок. \n    Ваш результат: \n    " + trips + "\n");
        trips.forEach(System.out::println);
    }

    private void printAndWriteToTheLogSortedTripsByPriceAsc(List<Trip> trips) {
        List<Trip> sortedTrips = getSortedTripsByPriceAsc(trips);
        logger.writeToTheLog("\n    Выбрана опция: B - список доступных поездок отсортированных по цене по возрастанию. \n    Ваш результат: \n    " + sortedTrips + "\n");
        sortedTrips.forEach(System.out::println);
    }

    private void printAndWriteToTheLogDescSortTripsByPriceDesc(List<Trip> trips) {
        List<Trip> sortedTrips = getDescSortTripsByPriceDesc(trips);
        logger.writeToTheLog("\n    Выбрана опция: C - список доступных поездок отсортированных по цене по убыванию. \n    Ваш результат: \n" + sortedTrips + "\n");
        sortedTrips.forEach(System.out::println);
    }

    private void printAndWriteToTheLogTripsInPriceRange(List<Trip> trips) {
        System.out.println("Введите минимальную цену ");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Введите максимальную цену ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();
        List<Trip> tripsRange = getTripsInPriceRange(trips, minPrice, maxPrice);
        logger.writeToTheLog("\n    Выбрана опция: D - список поездок со стоимостью от " + minPrice + " до " + maxPrice + " евро. \n    Ваш результат: \n" + tripsRange + "\n");
        tripsRange.forEach(System.out::println);
    }

    private void printAndWriteToTheLogTripsFilteredByStartCity(List<Trip> trips) {
        List<String> collect = trips.stream()
                .map(Trip::getSource)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Выберети город отправления: " + collect);
        String startCity = scanner.nextLine();
        List<Trip> startCityTrips = getTripsFilteredByStartCity(trips, startCity);
        logger.writeToTheLog("\n    Выбрана опция: E - список поездок из города " + startCity + ". \n    Ваш результат: \n " + startCityTrips + "\n");
        startCityTrips.forEach(System.out::println);
    }

    private void printAndWriteToTheLogFilteredByFinishCity(List<Trip> trips) {
        List<String> collect = trips.stream()
                .map(Trip::getDestination)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Выберети город назначения: " + collect);
        String finishCity = scanner.nextLine();
        List<Trip> finishCityTrips = getFilteredByFinishCity(trips, finishCity);
        logger.writeToTheLog("\n    Выбрана опция: F - с список поездок в город " + finishCity + ". \n    Ваш результат: \n " + finishCityTrips + "\n");
        finishCityTrips.forEach(System.out::println);
    }

    private void printAndWriteToTheLogTripsInDatesRange(List<Trip> trips) {
        System.out.println("Введите начальную дату в формате ГГГГ-ММ-ДД: ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Введите конечную дату в формате ГГГГ-ММ-ДД ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
        List<Trip> tripsInRange = getTripsInDatesRange(trips, startDate, endDate);
        logger.writeToTheLog("\n    Выбрана опция: H - список доступных поездок диапозоне дат от " + startDate + " до " + endDate + ". \n    Ваш результа: " + tripsInRange + "\n");
        tripsInRange.forEach(System.out::println);
    }

    private void printAndWriteToTheLogTripsFilteredByStartDateAndDateRadius(List<Trip> trips) {
        System.out.println("Введите дату начала поездки в формате ГГГГ-ММ-ДД ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите диапозон дней начала поезки ");
        int radius = scanner.nextInt();
        scanner.nextLine();
        List<Trip> tripList = getTripsFilteredByStartDateAndDateRadius(trips, startDate, radius);
        logger.writeToTheLog("\n    Выбрана опция: I - список начала поездок с " + startDate + " в диапозоне " + radius + " дней. \n    Ваш результа: " + tripList + "\n");
        tripList.forEach(System.out::println);
    }

    private void printAndWriteToTheLogTripsFilteredByReturnDateAndDateRadius(List<Trip> trips) {
        System.out.println("Введите дату окончания поездки в формате ГГГГ-ММ-ДД");
        LocalDate returnDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите диапозон дней для даты окончания поезки");
        int radius = scanner.nextInt();
        scanner.nextLine();
        List<Trip> tripList = getTripsFilteredByReturnDateAndDateRadius(trips, returnDate, radius);
        logger.writeToTheLog("\n    Выбрана опция: J - список окончания поездок с " + returnDate + " в диапозоне " + radius + " дней. \n    Ваш результа: " + tripList + "\n");
        tripList.forEach(System.out::println);
    }

    private void printOptionsInfo() {
        System.out.println();
        System.out.println("_______________________________________");
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
        System.out.println("___________________________________________");
        System.out.println();
    }
}


