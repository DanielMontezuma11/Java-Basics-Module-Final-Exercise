package model;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public static University initializeUniversity(){

        //model.University
        University university = new University();

        //Teachers
        //FT = Full Time; PT = Part Time
        Teacher domicianoFT = new FTTeacher("Domiciano", 200000, 3);
        Teacher claudiaFT = new FTTeacher("Claudia", 350000, 5);
        Teacher ramiroPT = new PTTeacher("Ramiro", 150000, 14);
        Teacher dianaPT = new PTTeacher("Diana", 125000, 12);

        university.teachers.add(domicianoFT);
        university.teachers.add(claudiaFT);
        university.teachers.add(ramiroPT);
        university.teachers.add(dianaPT);

        //Students
        Student daniel = new Student("1107364743", "Daniel", 21);
        Student darwin = new Student("1102356901", "Darwin", 21);
        Student ricardo = new Student("1907364743", "ricardo", 23);
        Student sara = new Student("15146643", "sara", 20);
        Student santiago = new Student("1102479743", "santiago", 20);
        Student laura = new Student("12863364743", "laura", 22);

        university.students.add(daniel);
        university.students.add(darwin);
        university.students.add(ricardo);
        university.students.add(sara);
        university.students.add(santiago);
        university.students.add(laura);

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

        university.courses.add(cl1);
        university.courses.add(cl2);
        university.courses.add(cl3);
        university.courses.add(cl4);

        return university;
    }
    public List<Course> findCoursesByStudentId(String document){
        List<Course> coursesStudent = new ArrayList<>();
        for (Course course : courses){
            for (Student student : course.getStudentList()){
                if (student.getDocument().equals(document)){
                    coursesStudent.add(course);
                    break;
                }
            }
        }
        return coursesStudent;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
