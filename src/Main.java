import com.sun.media.sound.FFT;

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
        Teacher domicianoFT = new FTTeacher("Domiciano", 200000, 3);
        Teacher claudiaFT = new FTTeacher("Claudia", 350000, 5);
        Teacher ramiroPT = new PTTeacher("Ramiro", 150000, 14);
        Teacher dianaPT = new PTTeacher("Diana", 125000, 12);

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
        cl2.addStudent(sara);
        cl2.addStudent(darwin);
        cl2.addStudent(santiago);

        Course cl3 = new Course("Innovación y emprendimiento", "108F", dianaPT);
        cl3.addStudent(santiago);

        Course cl4 = new Course("Aplicaciones moviles", "206M", domicianoFT);
        cl4.addStudent(darwin);
        cl4.addStudent(daniel);
        cl4.addStudent(laura);
        cl4.addStudent(sara);

        icesi.courses.add(cl1);
        icesi.courses.add(cl2);
        icesi.courses.add(cl3);
        icesi.courses.add(cl4);

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
                    System.out.println("Estos son nustros profesores:");
                    for(Teacher teacher : icesi.teachers){
                        if (teacher.getClass().equals(FTTeacher.class)){
                            System.out.println("El profesor de tiempo completo: " + teacher.getName() + " Con " + ((FTTeacher) teacher).getYearsOfExperience() + " año(s) de experiencia, un salario base de: " + teacher.getBaseSalary() + " y un salario calculado de: " + teacher.calculateSalary());
                        }else{
                            System.out.println("El profesor de tiempo parcial: " + teacher.getName() + " Con " + ((PTTeacher) teacher).getActiveHoursPerWeek() + " hora(s) activas a la semana, un salario base de: " + teacher.getBaseSalary() + " y un salario calculado de: " + teacher.calculateSalary());
                        }
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    int idClase;
                    Course clase;
                    System.out.println("Estas son todas nuestras clases disponibles:");
                    for(Course course : icesi.courses){
                        System.out.println("Id:" + course.getId() + " Nombre:" + course.getName());
                    }
                    System.out.println("Seleccione una de las clases para ver toda su información (Escriba unicamente el id de la clase)");
                    idClase = sc.nextInt();

                    clase = icesi.courses.get(idClase);

                    System.out.println("Id:" + clase.getId() + " Nombre:" + clase.getName() + " Salón:" + clase.getClassroom() + " Profesor(a):" + clase.getTeacher().getName() +
                            "\nEsta es la lista de estudiantes incritos:");

                    for (Student student : clase.getStudentList()){
                        System.out.println("Id:" + student.getId() + " Nombre:" + student.getName() + " Edad:" + student.getAge());
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    String nombre1;
                    String id1;
                    int edad1;
                    int clase1;
                    sc.nextLine();
                    System.out.println("Ingresa el nombre del nuevo estudiante");
                    nombre1 = sc.nextLine();

                    System.out.println("Ingresa el id del nuevo estudiante");
                    id1 = sc.nextLine();

                    System.out.println("Ingresa la edad del nuevo estudiante");
                    edad1 = sc.nextInt();

                    Student newStudent = new Student(id1, nombre1, edad1);
                    System.out.println("Creando estudiante..." +
                            "\nEstas son nuestras clases disponibles:");
                    for (Course course : icesi.courses){
                        System.out.println("Id: " + course.getId() + " Nombre: " + course.getName());
                    }
                    System.out.println("A qué clase le gustaria añadir al nuevo estudiante? (Escriba unicamente el id de la clase)");
                    clase1 = sc.nextInt();
                    icesi.courses.get(clase1).addStudent(newStudent);
                    System.out.println("Estudiante añadido exitosamente. Puede verificar el proceso seleccionando la opción 2." +
                            "\n---------------------------------------------------------------------------------------------------------");
                    /*Course claseprueba = icesi.courses.get(clase1);
                    for(Student studiante : claseprueba.getStudentList()){
                        System.out.println(studiante.getName());
                    }*/

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