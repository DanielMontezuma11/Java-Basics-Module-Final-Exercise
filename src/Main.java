import java.util.List;
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
        Student daniel = new Student("1107364743", "Daniel", 21);
        Student darwin = new Student("1102356901", "Darwin", 21);
        Student ricardo = new Student("1907364743", "ricardo", 23);
        Student sara = new Student("15146643", "sara", 20);
        Student santiago = new Student("1102479743", "santiago", 20);
        Student laura = new Student("12863364743", "laura", 22);

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
                            System.out.println("- " + teacher.getName() + ": profesor de tiempo completo con " + ((FTTeacher) teacher).getYearsOfExperience() + " año(s) de experiencia,"
                                    + "\nun salario base de: $" + teacher.getBaseSalary() + " y un salario calculado de: $" + teacher.calculateSalary());
                        }else{
                            System.out.println("- " + teacher.getName() + ": profesor de medio tiempo con " + ((PTTeacher) teacher).getActiveHoursPerWeek() + " hora(s) activas a la semana," +
                                    "\nun salario base de: $" + teacher.getBaseSalary() + " y un salario calculado de: $" + teacher.calculateSalary());
                        }
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    int idClase2;
                    Course clase;
                    System.out.println("Estas son todas nuestras clases disponibles:");
                    for(Course course : icesi.courses){
                        System.out.println("Id:" + course.getId() + " Nombre:" + course.getName());
                    }
                    System.out.println("Seleccione una de las clases para ver toda su información (Escriba unicamente el id de la clase)");
                    idClase2 = sc.nextInt();

                    clase = icesi.courses.get(idClase2);

                    System.out.println("Id:" + clase.getId() + " Nombre:" + clase.getName() + " Salón:" + clase.getClassroom() + " Profesor(a):" + clase.getTeacher().getName() +
                            "\nEsta es la lista de estudiantes incritos:");

                    for (Student student : clase.getStudentList()){
                        System.out.println("Document:" + student.getDocument() + " Nombre:" + student.getName() + " Edad:" + student.getAge());
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    String nombre1;
                    String documento1;
                    int edad1;
                    int clase1;
                    sc.nextLine();
                    System.out.println("Ingresa el nombre del nuevo estudiante");
                    nombre1 = sc.nextLine();

                    System.out.println("Ingresa el # de documento del nuevo estudiante");
                    documento1 = sc.nextLine();

                    System.out.println("Ingresa la edad del nuevo estudiante");
                    edad1 = sc.nextInt();

                    Student newStudent = new Student(documento1, nombre1, edad1);
                    icesi.students.add(newStudent);
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
                    String nombreClase4;
                    String salon4;
                    int id4;
                    Teacher teacher4;
                    int eid4;
                    String decision;
                    boolean continuar = true;

                    sc.nextLine();
                    System.out.println("Digite el nombre de la nueva clase:");
                    nombreClase4 = sc.nextLine();
                    System.out.println("Digite el salón asignado para la nueva clase:");
                    salon4 = sc.nextLine();
                    System.out.println("Esta es nuestra lista de profesores disponibles:");
                    for(Teacher teacher : icesi.teachers){
                        System.out.println("Id:" + teacher.getId() + " Nombre:" + teacher.getName());
                    }
                    System.out.println("Seleccione el profesor que desea asignar a la nueva clase (Digite unicamente el id del profesor):");
                    id4 = sc.nextInt();
                    teacher4 = icesi.teachers.get(id4);
                    Course newClass = new Course(nombreClase4, salon4, icesi.teachers.get(id4));
                    do{
                        System.out.println("Esta es nuestra lista de estudiantes disponibles:");
                        for(Student student : icesi.students){
                            System.out.println("Id:" + student.getId() + " Nombre:" + student.getName());
                        }
                        System.out.println("Seleccione el estudiante que desea asignar a la nueva clase (Digite unicamente el id del estudiante):");
                        eid4 = sc.nextInt();
                        newClass.addStudent(icesi.students.get(eid4));
                        sc.nextLine();
                        System.out.println("Estudiante añadido exitosamente. Desea añadir un estudiante mas (S para si, N para no)?");
                        decision = sc.nextLine();
                        if(decision.equalsIgnoreCase("N")){
                            continuar = false;
                            System.out.println("Clase creada exitosamente. Esta es la información completa:" +
                                    "\nId:" + newClass.getId() + " Nombre:" + newClass.getName() + " Salón:" + newClass.getClassroom() + " Profesor:" + newClass.getTeacher().getName() +
                                    "\nEsta es la lista de estudiantes inscritos:");
                            for (Student student : newClass.getStudentList()){
                                System.out.println("Document:" + student.getDocument() + " Nombre:" + student.getName());
                            }
                            icesi.courses.add(newClass);
                            System.out.println("---------------------------------------------------------------------------------------------------------");
                        }
                    }while(continuar);


                    break;
                case 5:
                    int id5;
                    List<Course> courses5;
                    System.out.println("Estos son todos nuestros estudiantes");
                    for(Student student : icesi.students){
                        System.out.println("Id:" + student.getId() + " Nombre:" + student.getName() + " Documento:" + student.getDocument() + " Edad:" + student.getAge());
                    }
                    System.out.println("Selecciona uno para ver todas sus clases (Digita unicamente su ID).");
                    id5 = sc.nextInt();

                    System.out.println("Buscando..." +
                            "\nEstas son todas las clases en las que el estudiante " + icesi.students.get(id5).getName() + " se encuentra:");

                    courses5 = icesi.findCoursesByStudentId(icesi.students.get(id5).getDocument());
                    if(courses5.isEmpty()){
                        System.out.println("El estudiante no se encuentra inscrito en ninguna clase");
                    }else{
                        for (Course course : courses5){
                            System.out.println("Id:" + course.getId() + " Nombre:" + course.getName() + " Salón:" + course.getClassroom() + " Profesor(a):" + course.getTeacher().getName());
                        }
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------");

                    break;
                case 6:
                    System.out.println("Saliendo del sistema..." +
                            "\n---------------------------------------------------------------------------------------------------------");
                    activo = false;
                    break;
                default:
                    System.out.println("Por favor ingresa una opción valida");
                    System.out.println("---------------------------------------------------------------------------------------------------------");

            }
        }while(activo);

    }
}