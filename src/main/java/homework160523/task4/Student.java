package homework160523.task4;

public class Student {

    private int id;
    private String name;
    private int age;
    private Degree degree;

    public Student(int id, String name, int age, Degree degree) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Degree getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", degree=" + degree +
                '}';
    }
}



