package model;

public class FTTeacher extends Teacher {

    private int yearsOfExperience;

    public FTTeacher(String name, double baseSalary, int yearsOfExperience) {
        super(name, baseSalary);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public double calculateSalary(){
        return baseSalary * (1.1 * yearsOfExperience);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
