public class PTTeacher extends Teacher {

    private double activeHoursPerWeek;

    public PTTeacher(String name, double baseSalary, double activeHoursPerWeek) {

        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double calculateSalary() {

        return baseSalary * activeHoursPerWeek;
    }

    public double getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    public void setActiveHoursPerWeek(double activeHoursPerWeek) {
        this.activeHoursPerWeek = activeHoursPerWeek;
    }
}
