public class Student {
    @SuppressWarnings("FieldMayBeFinal")
    private int id;
    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    private double CGPA;

    public Student(int id, String name, double CGPA) {
        this.id = id;
        this.name = name;
        this.CGPA = CGPA;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + CGPA;
    }
}
