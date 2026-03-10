package ui;

import model.*;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private University university;
    private Scanner sc = new Scanner(System.in);

    public Menu(University university) {
        this.university = university;
    }

    public void start(){
        boolean activo = true;

        do{
            showMenu();
            int accion = sc.nextInt();

            switch (accion){
                case 1:
                    showAllTeachersInfo();
                    break;
                case 2:
                    showAllClassesInfo();
                    break;
                case 3:
                    createAndAssignNewStudent();
                    break;
                case 4:
                    createNewClass();
                    break;
                case 5:
                    listAllClassesByStudentId();
                    break;
                case 6:
                    activo = false;
                    System.out.println("Saliendo del sistema..." +
                            "\n---------------------------------------------------------------------------------------------------------");
                    break;
                default:
                    System.out.println("Por favor ingresa una opción valida" +
                            "\n---------------------------------------------------------------------------------------------------------");

            }
        }while(activo);

    }

    private void showMenu(){
        System.out.println("---------------------------------------------------------------------------------------------------------" +
                "\n-                                           GLOBANT UNIVERSITY                                          -" +
                "\n---------------------------------------------------------------------------------------------------------" +
                "\n- Selecciona una de las siguientes opciones:                                                            -" +
                "\n- 1) Mostrar la información de todos los profesores                                                     -" +
                "\n- 2) Mostrar las clases disponibles                                                                     -" +
                "\n- 3) Crear un nuevo estudiante y añadirlo a una clase existente                                         -" +
                "\n- 4) Crear una nueva clase con toda su información (Profesor, Salón de clases, Lista de estudiantes)    -" +
                "\n- 5) Listar todas las clases de un estudiante en específico (ID)                                        -" +
                "\n- 6) Salir                                                                                              -" +
                "\n---------------------------------------------------------------------------------------------------------");
    }

    private void showAllTeachersInfo(){
        System.out.println("Estos son nustros profesores:");
        for(Teacher teacher : university.getTeachers()){
            if (teacher instanceof FTTeacher){
                System.out.println("- " + teacher.getName() + ": profesor de tiempo completo con " + ((FTTeacher) teacher).getYearsOfExperience() + " año(s) de experiencia,"
                        + "\nun salario base de: $" + teacher.getBaseSalary() + " y un salario calculado de: $" + teacher.calculateSalary());
            }else{
                System.out.println("- " + teacher.getName() + ": profesor de medio tiempo con " + ((PTTeacher) teacher).getActiveHoursPerWeek() + " hora(s) activas a la semana," +
                        "\nun salario base de: $" + teacher.getBaseSalary() + " y un salario calculado de: $" + teacher.calculateSalary());
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    private void showAllClassesInfo(){
        int idClase2;
        Course clase;
        System.out.println("Estas son todas nuestras clases disponibles:");
        for(Course course : university.getCourses()){
            System.out.println("Id:" + course.getId() + " Nombre:" + course.getName());
        }
        System.out.println("Seleccione una de las clases para ver toda su información (Escriba unicamente el id de la clase)");
        idClase2 = sc.nextInt();

        clase = university.getCourses().get(idClase2);

        System.out.println("Id:" + clase.getId() + " Nombre:" + clase.getName() + " Salón:" + clase.getClassroom() + " Profesor(a):" + clase.getTeacher().getName() +
                "\nEsta es la lista de estudiantes incritos:");

        for (Student student : clase.getStudentList()){
            System.out.println("Document:" + student.getDocument() + " Nombre:" + student.getName() + " Edad:" + student.getAge());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    private void createAndAssignNewStudent(){
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
        university.getStudents().add(newStudent);
        System.out.println("Creando estudiante..." +
                "\nEstas son nuestras clases disponibles:");
        for (Course course : university.getCourses()){
            System.out.println("Id: " + course.getId() + " Nombre: " + course.getName());
        }
        System.out.println("A qué clase le gustaria añadir al nuevo estudiante? (Escriba unicamente el id de la clase)");
        clase1 = sc.nextInt();
        university.getCourses().get(clase1).addStudent(newStudent);
        System.out.println("Estudiante añadido exitosamente. Puede verificar el proceso seleccionando la opción 2." +
                "\n---------------------------------------------------------------------------------------------------------");

    }

    private void createNewClass(){
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
        for(Teacher teacher : university.getTeachers()){
            System.out.println("Id:" + teacher.getId() + " Nombre:" + teacher.getName());
        }
        System.out.println("Seleccione el profesor que desea asignar a la nueva clase (Digite unicamente el id del profesor):");
        id4 = sc.nextInt();
        teacher4 = university.getTeachers().get(id4);
        Course newClass = new Course(nombreClase4, salon4, university.getTeachers().get(id4));
        do{
            System.out.println("Esta es nuestra lista de estudiantes disponibles:");
            for(Student student : university.getStudents()){
                System.out.println("Id:" + student.getId() + " Nombre:" + student.getName());
            }
            System.out.println("Seleccione el estudiante que desea asignar a la nueva clase (Digite unicamente el id del estudiante):");
            eid4 = sc.nextInt();
            newClass.addStudent(university.getStudents().get(eid4));
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
                university.getCourses().add(newClass);
                System.out.println("---------------------------------------------------------------------------------------------------------");
            }
        }while(continuar);
    }

    private void listAllClassesByStudentId(){
        int id5;
        List<Course> courses5;
        System.out.println("Estos son todos nuestros estudiantes");
        for(Student student : university.getStudents()){
            System.out.println("Id:" + student.getId() + " Nombre:" + student.getName() + " Documento:" + student.getDocument() + " Edad:" + student.getAge());
        }
        System.out.println("Selecciona uno para ver todas sus clases (Digita unicamente su ID).");
        id5 = sc.nextInt();

        System.out.println("Buscando..." +
                "\nEstas son todas las clases en las que el estudiante " + university.getStudents().get(id5).getName() + " se encuentra:");

        courses5 = university.findCoursesByStudentId(university.getStudents().get(id5).getDocument());
        if(courses5.isEmpty()){
            System.out.println("El estudiante no se encuentra inscrito en ninguna clase");
        }else{
            for (Course course : courses5){
                System.out.println("Id:" + course.getId() + " Nombre:" + course.getName() + " Salón:" + course.getClassroom() + " Profesor(a):" + course.getTeacher().getName());
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");

    }
}
