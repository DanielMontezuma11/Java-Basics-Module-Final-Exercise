public class PTTeacher extends Teacher {

    private int activeHoursPerWeek;

    public PTTeacher(String name, double baseSalary, int activeHoursPerWeek) {

        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double calculateSalary() {

        return baseSalary * activeHoursPerWeek;
    }
}
