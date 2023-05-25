package homework160523.task4;

public class StudentApp {

    public static void main(String[] args) {
        Service service = new Service();
        service.addStudents("Ivan", 20, Degree.BACHELOR);
        service.addStudents("Anton", 23, Degree.MAGISTRACY);
        service.addStudents("Anna", 18, Degree.BACHELOR);
        service.addStudents("Inna", 25, Degree.MAGISTRACY);
        service.getAllStudents();
        System.out.println();
        service.getAllStudents(Degree.BACHELOR);

        System.out.println("Средний возраст всех студентов: " + service.getAverageAge());
        System.out.println("Сумма возраста всех студентов:  " + service.getSumAge());
        System.out.println("Сумма возраста всех студентов в зависимости от учебной степени: " + service.getSumAge(Degree.MAGISTRACY));
    }
}
