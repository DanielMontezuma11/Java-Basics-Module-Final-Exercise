public class FTTeacher extends Teacher{

    private int yearsOfExperience;

    public FTTeacher(String name, double baseSalary, int yearsOfExperience) {
        super(name, baseSalary);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public double calculateSalary(){
        return 0;
    }
}
