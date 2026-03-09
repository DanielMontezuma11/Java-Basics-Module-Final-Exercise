public class PTTeacher extends Teacher {

    private int activeHoursPerWeek;

    public PTTeacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return 0;
    }
}
