import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean activo = true;
        int accion = 0;

        //University
        University icesi = new University();

        //Teachers
        //FT = Full Time; PT = Part Time
        Teacher domicianoFT = new FTTeacher("Domiciano", 2000000, 3);
        Teacher claudiaFT = new FTTeacher("Claudia", 3500000, 5);
        Teacher ramiroPT = new PTTeacher("Ramiro", 1500000, 14);
        Teacher dianaPT = new PTTeacher("Diana", 1250000, 12);

        icesi.teachers.add(domicianoFT);
        icesi.teachers.add(claudiaFT);
        icesi.teachers.add(ramiroPT);
        icesi.teachers.add(dianaPT);

        //Students
        Student daniel = new Student("1", "Daniel", 21);
        Student darwin = new Student("1", "Darwin", 21);
        Student ricardo = new Student("1", "ricardo", 23);
        Student sara = new Student("1", "sara", 20);
        Student santiago = new Student("1", "santiago", 20);
        Student laura = new Student("1", "laura", 22);

        icesi.students.add(daniel);
        icesi.students.add(darwin);
        icesi.students.add(ricardo);
        icesi.students.add(sara);
        icesi.students.add(santiago);
        icesi.students.add(laura);

        //Classes
        Course cl1 = new Course("Algoritmos y programación I", "401E", claudiaFT);
        cl1.addStudent(daniel);
        cl1.addStudent(darwin);
        cl1.addStudent(ricardo);

        Course cl2 = new Course("Sistemas operativos", "202M", ramiroPT);
        cl1.addStudent(sara);
        cl1.addStudent(darwin);
        cl1.addStudent(santiago);

        Course cl3 = new Course("Innovación y emprendimiento", "108F", dianaPT);
        cl1.addStudent(santiago);

        Course cl4 = new Course("Aplicaciones moviles", "206M", domicianoFT);
        cl1.addStudent(darwin);
        cl1.addStudent(daniel);
        cl1.addStudent(laura);
        cl1.addStudent(sara);

        System.out.println("---------------------------------------------------------------------------------------------------------" +
                "\n-                                           GLOBANT UNIVERSITY                                          -" +
                "\n---------------------------------------------------------------------------------------------------------");
        do{
            System.out.println("- Selecciona una de las siguientes opciones:                                                            -" +
                    "\n- 1) Mostrar la información de todos los profesores                                                     -" +
                    "\n- 2) Mostrar las clases disponibles                                                                     -" +
                    "\n- 3) Crear un nuevo estudiante y añadirlo a una clase existente                                         -" +
                    "\n- 4) Crear una nueva clase con toda su información (Profesor, Salón de clases, Lista de estudiantes)    -" +
                    "\n- 5) Listar todas las clases de un estudiante en específico (ID)                                        -" +
                    "\n- 6) Salir                                                                                              -" +
                    "\n---------------------------------------------------------------------------------------------------------");
            accion = sc.nextInt();

            switch (accion){
                case 1:
                    System.out.println("TODOS LOS PROFES");
                    break;
                case 2:
                    System.out.println("TODAS LAS CLASES");
                    break;
                case 3:
                    System.out.println("CREANDO ESTUDIANTE");
                    break;
                case 4:
                    System.out.println("CREANDO CLASES");
                    break;
                case 5:
                    System.out.println("LISTANDO TODAS LAS CLASES");
                    break;
                case 6:
                    System.out.println("SALIENDO");
                    activo = false;
                    break;
                default:
                    System.out.println("Por favor ingresa una opción valida");
                    System.out.println("---------------------------------------------------------------------------------------------------------");

            }
        }while(activo);

    }
}