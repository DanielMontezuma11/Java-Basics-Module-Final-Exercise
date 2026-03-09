import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private String classroom;
    private Teacher teacher;
    private List<Student> studentList;

    public Course(String name, String classroom, Teacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.studentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent (Student student){
        studentList.add(student);
    }
}
