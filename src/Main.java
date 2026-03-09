//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //University
        University icesi = new University();

        //Teachers
        //FT = Full Time; PT = Part Time
        Teacher carlosFT = new FTTeacher("Carlos", 2000000, 3);
        Teacher claudiaFT = new FTTeacher("Claudia", 3500000, 5);
        Teacher ramiroPT = new PTTeacher("Ramiro", 1500000, 14);
        Teacher dianaPT = new PTTeacher("Diana", 1250000, 12);

        icesi.teachers.add(carlosFT);
        icesi.teachers.add(claudiaFT);
        icesi.teachers.add(ramiroPT);
        icesi.teachers.add(dianaPT);
        

    }
}